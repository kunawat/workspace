import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        //int A[] = new int[n];
        int j;
        int ans=0;
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int i=0; i<n; i++){
            j = s.nextInt();
            if(!m.containsKey(j)){
               int beg = j;
                int end =j;
                m.put(j,j);
                if(m.containsKey(j-1)){
                    beg=m.get(j-1);
                }
                 if(m.containsKey(j+1)){
                    end=m.get(j+1);
                }
                int temp = m.get(beg);
                m.put(beg,end);
                m.put(end,temp);
                
                if(end-beg+1>ans){
                    ans=end-beg+1;
                }
            } 
        }
        System.out.println(ans);
    }
}