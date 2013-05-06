// Ajay Jain
// November 5, 2012
// StringExample.java
// A program...

public class StringExample {
	public static void main(String[] args) {
		String str1 = "Hello There";
		int spaceindex = str1.indexOf(' ');
		System.out.println("*"+str1.substring(spaceindex)+"*");
		System.out.println("*"+str1.substring(spaceindex+1)+"*");
		System.out.println("*"+str1.substring(0,spaceindex)+"*");
		
		String str5 = "   \n\t   Vote on election day  \t  \n";
		System.out.println("*"+str5.trim()+"*");
		System.out.println("salad".substring(0,2));
		System.out.println("salad".substring(2));
		System.out.println("Watce some football.".indexOf('e', 4));
	}
}
