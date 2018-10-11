import java.util.Scanner;
import java.util.Locale;
 
public class Party {
 
    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        int n = scan.nextInt();
        int[] arr;
        arr = new int[n];
        System.out.printf(Locale.US,"%d", n);
        for(int i = 0; i < n; i++)
        {
            arr[i] = scan.nextInt();
        }
        int maxDepth = 1;

        for(int i = 0; i < n; i++)
        {
            int manager = arr[i];
            int depth = 1;
            
            while(manager != -1)
            {
                depth += 1;
                manager = arr[manager];

            }
            maxDepth = Math.max(maxDepth, depth);
        }

        System.out.printf(Locale.US,"%d", maxDepth);

    }
}