package max_no;

import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int a= s.nextInt();
		while(a>0){
		long n=s.nextInt();
		int i=0;
		long x=n;
		long t=1;
		while(x>0){
			x=x/10;
			i++;
			t=t*10;
		}
		if(n%10==0 && (n/(t/100))%10==0){
			n=Math.max((n/(t/10))+((n%(t/10))*10),n/10);
		}
	
		System.out.println(max(n));
		a--;
		}
	}
	public static long max(long n){
		int i=0;
		long x=n;
		long t=1;
		while(x>0){
			x=x/10;
			i++;
			t=t*10;
		}
		t=t/10;
		x=n;
		long max=n;
		if(n%10==n){
			return n;
		}
		int j;
		for( j=0;j<i && (x%t)/(t/10)>0;j++){
			long y=x/t;
			x=x%t;
			
			x=x*10+y;
			if(max<x)max=x;
			
		}
		x=n;
		for(;j<i && x%10>0;j++){
			long y= x%10;
			x=x/10;
			x=y*t+x;
			if(max<x){
				max=x;
			}
		}
		return max;
	}
}
