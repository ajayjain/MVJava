// Electric.java
// Ajay Jain
// October 9, 2012
// This class calculates the electric bill for a PG&E customer.

// Class Variables:
//		type: type of bill (R, C, I)
//		fullType: type of bill (Residential, Commercial, Industrial)
//		peak: peak kW*hr used
//		offPeak: off-peak kW*hr used
//		cost: bill total

// Class Method:
//		GetData: read data from the used
//		CalculateCost: calculate the bill
//		PrintInfo: print bill total and information



import java.util.Scanner;

public class Electric {
	private char type;
	private String fullType;
	private double peak, offPeak, cost;
	
	public Electric() {}
	
	public void GetData() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter the type of electric bill, R for residential, C for commercial, I for industrial -> ");
		String typeInput = s.next();
		char t = typeInput.charAt(0);
		if (typeInput.length() == 1 && (t == 'R' || t == 'C' || t == 'I'))
			type = t;
		else {
			System.out.println("Error, please try again.");
			GetData();
			return;
		}
		
		if (type == 'I') {
			System.out.print("Enter the number of kilowatt hours of electricity used during peak hours \t       -> ");
			peak = s.nextDouble();
			
			System.out.print("Enter the number of kilowatt hours of electricity used during off-peak hours \t       -> ");
			offPeak = s.nextDouble();
		} else {
			System.out.print("Enter the number of kilowatt hours of electricity used \t\t\t\t       -> ");
			peak = s.nextDouble();
		}
	}
	
	public double CalculateCost() {
		double c;
		
		switch (type) {
			case 'R':
				fullType = "Residential";
				c = 12 + peak * 0.095;
				break;
			case 'C':
				fullType = "Commercial";
				c = peak <= 1000 ? 120 : 120 + (peak - 1000) * 0.083;
				break;
			case 'I':
				fullType = "Industrial";
				double peakCost = (peak <= 1000) ?
					152 : 152 + (peak - 1000) * 0.109;
				double offPeakCost = (offPeak <= 1000) ?
					108 : 108 + (offPeak - 1000) * 0.047;
				c = peakCost + offPeakCost;
				break;
			default: throw new Error("Something strange happened!");
		}
		
		cost = c;
		return cost;
	}
	
	public void PrintInfo() {
		System.out.println("\n\n"+fullType+" Bill\n");
		System.out.printf("Peak Hours \t\t%10.2f\n",peak);
		if (type == 'I') System.out.printf("Off-Peak Hours \t\t%10.2f\n",offPeak);
		System.out.printf("Cost \t\t\t$%9.2f\n",cost);
	}
}
