import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner s = new Scanner(System.in);
    	int n= s.nextInt();
    	
    	int k=s.nextInt();
    	
    	int[] A = new int[n];
    

    	for(int i=0;i<n;i++){
    		
    		A[i]=s.nextInt();
    	
    	}
    	for (int i=0;i<k;i++){
    		int t=s.nextInt();
    		if(t==2){
    			int x =s.nextInt();
    			if(x>n)System.out.println(1);
    			else if(x<=0)System.out.println(1);
    			else{
    				if(x!=A[0] && x!=A[n-1])System.out.println(12);
    				else System.out.println(1);
    			}
    			
    		}
    		else{
    			
    			int a=s.nextInt();
    			int b=s.nextInt();
    			if(a!=b){
    			for(int j=0; j<n;j++){
    				if(A[j]==a)A[j]=b;
    				else if(A[j]==b)A[j]=a;
    			}}
    		}
    	}
  
    }
    
  
}