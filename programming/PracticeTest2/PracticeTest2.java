// Ajay Jain
// , 2012
// PracticeTest2.java
// This program

public class PracticeTest2 {
	public static void main(String[] args) {
		String meal = "Good Eats";
		String traditions = "Watch some football.";
		String guests = "Family and Friends";

		System.out.printf("(a) \"%s\"\n", traditions.substring(9));	
		System.out.println(traditions.substring(9).getClass());
		
		System.out.println("(c) "+guests.lastIndexOf("i")+"");
		System.out.println(traditions.substring(9).getClass());
		
		System.out.println("meal.substring(6, 7): "+meal.substring(6, 7));
		System.out.println(meal.substring(6, 7).getClass());
		
		System.out.println("i: "+guests.indexOf('a', 4));
		
		System.out.println("(e): "+guests.indexOf(meal.substring(6, 7)));
		//System.out.println(guests.indexOf(meal.substring(6, 7)).getClass());
		
		char bee = 'B';
		while ( bee != 'b')   {
			   System.out.print ( "queen " + bee );
			   bee = (char)((int)bee + 8);
			   System.out.println ( "buzz" );
		}

			
	}
}

/*
public class String extends Object {
	
}

public class Object {
	public String getClass() {
		return ...;
	}
}
*/
