// Exercise:
//		- Create an abstract class "Cat"
//		- Create a constructor and two methods for Cat class
//		- Create a subclass for Cat (e.g. "Persian")
//		- Override one of the Cat methods in your subclass

public class CatInheritance {
	public static void main (String [] args) {

		NyanCat poptart = new NyanCat();
		poptart.SetName("Poptart");
		poptart.Eat();
		poptart.Draw();
	}
}

abstract class Cat {
	protected String name, eats;
	
	public Cat() {
		eats = "yummy food";
	}
	
	public void Eat() {
		System.out.println("OM NOM NOM! "+name+" eats "+eats);
	}
	
	public void SetName(String name) {
		this.name = name;
	}
}

class NyanCat extends Cat {
	public NyanCat() {
		eats = "space dust";
	}
	
	public void Eat() {
		System.out.println("OM NOM NOM! THE GLORIOUS "+name+" eats "+eats+"!!!");
	}
	
	public void Draw() {
		System.out.println("---------");
		System.out.println("--------");
	}
}
