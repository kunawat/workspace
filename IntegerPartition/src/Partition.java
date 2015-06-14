import java.util.*;
public class Partition { 

    public static int partition(int n) {
        return partition(n, n, "");
    }
    public static int partition(int n, int max, String prefix) {
        if (n == 0) {
            System.out.println(prefix);
            return 1;
        }
        int x=0;
        for (int i = Math.min(max, n); i >= 1; i--) {
           x+= partition(n-i, i, prefix + " " + i);
        }
        return x;
    }


    public static void main(String[] args) { 
    	Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        
        int x=partition(N);
        System.out.println(x);
    }

}