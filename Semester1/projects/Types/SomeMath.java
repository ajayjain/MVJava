// Ajay Jain
// September 6, 2012
// SomeMath.java
// Write a program to compute math expressions and display all the appropriate data types that can be assigned to the result. The program must print out the math expression, the result produced by Java, and the data type name declared for the assigned variable.

public class SomeMath {
      public static void main(String[] args) {
      		byte b = 21 / 6;
            System.out.println("21/6 = " + b + "(byte)");
      		short sh = 21 / 6;
            System.out.println("21/6 = " + sh + "(short)");
            long l = 21 / 6;
            System.out.println("21/6 = " + l + "(long)");
            int i = 21 / 6;
            System.out.println("21/6 = " + i + "(int)");
            float f = 21 / 6;
            System.out.println("21/6 = " + f + "(float)");
            double d = 21 / 6;
            System.out.println("21/6 = " + d + "(double)");
            char ch = 21 / 6;
            System.out.println("21/6 = " + ch + "(char)");
            
            f = (float) 5 + 9;
            System.out.println("(float) 5 + 9 = " + f + "(float)");
            d = (float) 5 + 9;
            System.out.println("(float) 5 + 9 = " + d + "(double)");
            
            b = 57 % 11;
            System.out.println("57 % 11 = " + b + "(byte)");
      		sh = 57 % 11;
            System.out.println("57 % 11 = " + sh + "(short)");
            l = 57 % 11;
            System.out.println("57 % 11 = " + l + "(long)");
            i = 57 % 11;
            System.out.println("57 % 11 = " + i + "(int)");
            f = 57 % 11;
            System.out.println("57 % 11 = " + f + "(float)");
            d = 57 % 11;
            System.out.println("57 % 11 = " + d + "(double)");
            ch = 57 % 11;
            System.out.println("57 % 11 = " + ch + "(char)");
            
            System.out.println("7 * 4.0 = " + f + "(float)");
            d = 7 * 4.0;

            d = (double) 45 / 6;
            System.out.println("(double) 45 / 6 = " + d + "(double)");
            
            b = (int) 12.75 + 2;
            System.out.println("(int) 12.75 + 2 = " + b + "(byte)");
      		sh = (int) 12.75 + 2;
            System.out.println("(int) 12.75 + 2 = " + sh + "(short)");
            l = (int) 12.75 + 2;
            System.out.println("(int) 12.75 + 2 = " + l + "(long)");
            i = (int) 12.75 + 2;
            System.out.println("(int) 12.75 + 2 = " + i + "(int)");
            f = (int) 12.75 + 2;
            System.out.println("(int) 12.75 + 2 = " + f + "(float)");
            d = (int) 12.75 + 2;
            System.out.println("(int) 12.75 + 2 = " + d + "(double)");
            ch = (int) 12.75 + 2;
            System.out.println("(int) 12.75 + 2 = " + ch + "(char)");
            
            b = (int) 'Q';
            System.out.println("(int) 'Q' = " + b + "(byte)");
      		sh = (int) 'Q';
            System.out.println("(int) 'Q' = " + sh + "(short)");
            l = (int) 'Q';
            System.out.println("(int) 'Q' = " + l + "(long)");
            i = (int) 'Q';
            System.out.println("(int) 'Q' = " + i + "(int)");
            f = (int) 'Q';
            System.out.println("(int) 'Q' = " + f + "(float)");
            d = (int) 'Q';
            System.out.println("(int) 'Q' = " + d + "(double)");
            ch = (int) 'Q';
            System.out.println("(int) 'Q' = " + ch + "(char)");
            
            b = (char) 103;
            System.out.println("(char) 103 = " + b + "(byte)");
      		sh = (char) 103;
            System.out.println("(char) 103 = " + sh + "(short)");
            l = (char) 103;
            System.out.println("(char) 103 = " + l + "(long)");
            i = (char) 103;
            System.out.println("(char) 103 = " + i + "(int)");
            f = (char) 103;
            System.out.println("(char) 103 = " + f + "(float)");
            d = (char) 103;
            System.out.println("(char) 103 = " + d + "(double)");
            ch = (char) 103;
            System.out.println("(char) 103 = " + ch + "(char)");
            
            b = (byte) 27;
            System.out.println("(byte) 27 = " + b + "(byte)");
      		sh = (byte) 27;
            System.out.println("(byte) 27 = " + sh + "(short)");
            l = (byte) 27;
            System.out.println("(byte) 27 = " + l + "(long)");
            i = (byte) 27;
            System.out.println("(byte) 27 = " + i + "(int)");
            f = (byte) 27;
            System.out.println("(byte) 27 = " + f + "(float)");
            d = (byte) 27;
            System.out.println("(byte) 27 = " + d + "(double)");
            ch = (byte) 27;
            System.out.println("(byte) 27 = " + ch + "(char)");
            
      		sh = (short) 552;
            System.out.println("(short) 552 = " + sh + "(short)");
            l = (short) 552;
            System.out.println("(short) 552 = " + l + "(long)");
            i = (short) 552;
            System.out.println("(short) 552 = " + i + "(int)");
            f = (short) 552;
            System.out.println("(short) 552 = " + f + "(float)");
            d = (short) 552;
            System.out.println("(short) 552 = " + d + "(double)");
            ch = (short) 552;
            System.out.println("(short) 552 = " + ch + "(char)");
            
            l = (long) 13579;
            System.out.println("(long) 13579 = " + l + "(long)");
            f = (long) 13579;
            System.out.println("(long) 13579 = " + f + "(float)");
            d = (long) 13579;
            System.out.println("(long) 13579 = " + d + "(double)");
            
            d = 26.34 + 5.7 * 3.4 / 1.8 + 22.7;
            System.out.println("26.34 + 5.7 * 3.4 / 1.8 + 22.7 = " + d + "(double)");
            
            b = 18 - 6 + 125 / 17 % 6;
            System.out.println("18 - 6 + 125 / 17 % 6 = " + b + "(byte)");
      		sh = 18 - 6 + 125 / 17 % 6;
            System.out.println("18 - 6 + 125 / 17 % 6 = " + sh + "(short)");
            l = 18 - 6 + 125 / 17 % 6;
            System.out.println("18 - 6 + 125 / 17 % 6 = " + l + "(long)");
            i = 18 - 6 + 125 / 17 % 6;
            System.out.println("18 - 6 + 125 / 17 % 6 = " + i + "(int)");
            f = 18 - 6 + 125 / 17 % 6;
            System.out.println("18 - 6 + 125 / 17 % 6 = " + f + "(float)");
            d = 18 - 6 + 125 / 17 % 6;
            System.out.println("18 - 6 + 125 / 17 % 6 = " + d + "(double)");
            ch = 18 - 6 + 125 / 17 % 6;
            System.out.println("18 - 6 + 125 / 17 % 6 = " + ch + "(char)");
            
            d = (double)65 / 4 - (int)5.6 * 4;
            System.out.println("(double)65 / 4 - (int)5.6 * 4 = " + d + "(double)");
            
            b = (char)(85 + 3 % 14 - 92 / 7 % 11);
            System.out.println("(char)(85 + 3 % 14 - 92 / 7 % 11) = " + b + "(byte)");
      		sh = (char)(85 + 3 % 14 - 92 / 7 % 11);
            System.out.println("(char)(85 + 3 % 14 - 92 / 7 % 11) = " + sh + "(short)");
            l = (char)(85 + 3 % 14 - 92 / 7 % 11);
            System.out.println("(char)(85 + 3 % 14 - 92 / 7 % 11) = " + l + "(long)");
            i = (char)(85 + 3 % 14 - 92 / 7 % 11);
            System.out.println("(char)(85 + 3 % 14 - 92 / 7 % 11) = " + i + "(int)");
            f = (char)(85 + 3 % 14 - 92 / 7 % 11);
            System.out.println("(char)(85 + 3 % 14 - 92 / 7 % 11) = " + f + "(float)");
            d = (char)(85 + 3 % 14 - 92 / 7 % 11);
            System.out.println("(char)(85 + 3 % 14 - 92 / 7 % 11) = " + d + "(double)");
            ch = (char)(85 + 3 % 14 - 92 / 7 % 11);
            System.out.println("(char)(85 + 3 % 14 - 92 / 7 % 11) = " + ch + "(char)");
            
            b = (int)(86 + 67.2 / 14.4) % 14;
            System.out.println("(int)(86 + 67.2 / 14.4) % 14 = " + b + "(byte)");
      		sh = (int)(86 + 67.2 / 14.4) % 14;
            System.out.println("(int)(86 + 67.2 / 14.4) % 14 = " + sh + "(short)");
            l = (int)(86 + 67.2 / 14.4) % 14;
            System.out.println("(int)(86 + 67.2 / 14.4) % 14 = " + l + "(long)");
            i = (int)(86 + 67.2 / 14.4) % 14;
            System.out.println("(int)(86 + 67.2 / 14.4) % 14 = " + i + "(int)");
            f = (int)(86 + 67.2 / 14.4) % 14;
            System.out.println("(int)(86 + 67.2 / 14.4) % 14 = " + f + "(float)");
            d = (int)(86 + 67.2 / 14.4) % 14;
            System.out.println("(int)(86 + 67.2 / 14.4) % 14 = " + d + "(double)");
            ch = (int)(86 + 67.2 / 14.4) % 14;
            System.out.println("(int)(86 + 67.2 / 14.4) % 14 = " + ch + "(char)");
            
            d = (double)34 + (int)'V' / 8;
            System.out.println("(double)34 + (int)'V' / 8 = " + d + "(double)");
      }
}
