import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
public class FillWithIntegers   {
   private int counter, max, number;
   public FillWithIntegers ( ) {
             counter = max = number = 0;
   }
   public static void main ( String [] args ) {
             FillWithIntegers fill = new FillWithIntegers ( );
             fill.PlaceNumbers ( );
   }
   public void PlaceNumbers ( ) {
             File f = new File ( "numbers.txt" );
             PrintWriter makesOutput = null;
             try {
                    makesOutput = new PrintWriter ( f );
             }
             catch ( IOException e )
             {
                    System.out.println("Cannot create file to be written to");
                    System.exit(1);
             }
             max = (int)(Math.random() * 501) + 100;
             while ( counter < max ) {
                    number = (int)(Math.random() * 100) + 1;
                    System.out.print ( number + " " );
                    makesOutput.print ( number + " " );
                    counter++;
                    if ( counter % 16 == 0 )   {
                           System.out.println ( "\n" );
                           makesOutput.println ( "\n" );
                    }
             }
             System.out.println ( );
             makesOutput.println ( );
             makesOutput.close ( );
   }
}
