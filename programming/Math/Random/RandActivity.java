// Ajay Jain
// September 24, 2012

import java.lang.Math;

public class RandActivity {

	public static void main (String args[]) {
		System.out.println((byte) Math.ceil(Math.random()*100));
	}
	public int find () {
		int rand = (int) (Math.random()*99);
		if (!(rand <= 99 || rand >= 2)) {
			return find();
		}
		return rand;
	}
}
