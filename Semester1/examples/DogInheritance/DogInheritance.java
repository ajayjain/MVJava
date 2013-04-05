// DogInheritance.java
// This program is an example of inheritance.
// Topics:
//		- SubClass Dog
//		- Use of "this" reserved word for an object
//		- Extend dog class to Poodle
//		- Override methods

public class DogInheritance {
	public static void main(String[] args) {
		Dog dog1 = new Dog();
		dog1.SetName("Governer Mittens");
		System.out.println("Come here "  + dog1.GetName());
		
		Poodle dog2 = new Poodle();
		dog2.SetName("President Obama");
		System.out.println("Come here "  + dog2.GetName());
		dog2.Talk();
		dog2.SetNoise("woof! Yes we can! woof!");
		dog2.Talk();
	}
}

class Animal {
	String name;
	
	public Animal() {};
	
	public void SetName(String name) { this.name = name; }
	public String GetName() { return name; }
	public void Talk() { System.out.println("<silence>"); }
}

class Dog extends Animal {
	String noise, eats;
	
	public Dog() { eats = "beef"; noise = "bark!"; }
	public void SetNoise(String noise) { this.noise = noise; }
	public void Talk() { System.out.println(name+" says "+noise); }
}

class Poodle extends Dog {
	public Poodle() { eats = "filet minon"; }
}
