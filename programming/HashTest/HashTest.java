// Ajay Jain
// , 2012
// HashTest.java
// This program

import java.util.Hashtable;

public class HashTest {
	public static Hashtable table;
	
	public static void main(String[] args) {
		table = new Hashtable();
		print();
		table.put("a", "asdf");
		table.put("b", "yoyoyo");
		table.put('c', 22);
		table.put(33, 22);
		String k = "asdfasdf";
		table.put(k, "kewl");
		print();
		System.out.println(table.get(k));
	}
	
	public static void print() {
		System.out.println(table.toString());
	}
}
