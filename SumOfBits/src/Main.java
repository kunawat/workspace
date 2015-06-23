//sum of bits in numbers from 1 to n.

import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		while(true){
		int n =s.nextInt();
		System.out.println(func(n));
		}
	}
	public static int func(int n){
		if(n==0)return 0;
		if(n==1)return 1;
		
		int k =(int) Math.floor(Math.log10((int)n)/0.3010);
		
		int count=(int) (k*Math.pow(2,k-1));
		
		int x =(int) (n-Math.pow(2,k)+1);
		
		count=count+x+func(x-1);
		return count;
	}
}
