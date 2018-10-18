package lab1;
import java.util.Scanner;
import java.util.Locale;
 
public class Pasha {
 
    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        int length = scan.nextInt();
        
        if(length % 2 != 0)
        {
            System.out.printf(Locale.US,"%d", 0);
        }
        else
        {
            int n = length/4;
            if(length % 4 == 0)
            {
                n -= 1;
            }
            System.out.printf(Locale.US,"%d", n);
        }
        // System.out.printf(Locale.US,"Wczytano %s , %d, %f",s,i,d);

    }
}