// Ajay Jain (Based on Mr. Greenstein's program)
// November 27, 2012
// DogInheritance2.java
// This program is an example of inheritance.
// Topics:
//		1) Use of "super" reserved word for constructors
//		2) Overload method
//		3) Making superclass "abstract"

public class DogInheritance2 {
	public static void main (String [] args) {
/*
		Dog dog1 = new Dog();
		dog1.SetName("Governer Mittens");
		dog1.SetNoise();
		dog1.CallDog();
		dog1.Noise();
		dog1.WhatToEat();
		dog1.FavoriteActivity();
*/

		Poodle noodle = new Poodle();
		noodle.SetName("Frenchie");
		noodle.SetNoise("Whoosh");
		noodle.CallDog();
		noodle.Noise();
		noodle.WhatToEat();
		noodle.FavoriteActivity();
	}	// end main
}	// end class DogInheritance


abstract class Dog {
	protected String name, noise, eats;
	private String activity;

	public Dog() {
		eats = "beef";
		activity = "fetch";
	}
	
	public void SetName (String name) { this.name = name; }

	public void SetNoise () { noise = "woof"; }
	
	public void SetNoise (String noise) { this.noise = noise; }
	
	public void Noise () { System.out.println(noise + " " + noise); }
	
	public void CallDog () { System.out.println("Come here " + name); }
	
	public void WhatToEat () { System.out.println("Would you like some " + eats + "?"); }

	public void FavoriteActivity () {
		System.out.println("Let's go out to play " + activity);
	}
}


class Poodle extends Dog {
	public Poodle () {
		super();
		eats = "filet minion";
	}
}


