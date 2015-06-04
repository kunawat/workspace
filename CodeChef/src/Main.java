import java.util.*;
import java.lang.*;
import java.io.*;
public class Main{
	public static void main(String args[]) throws java.lang.Exception{
		
			Scanner s = new Scanner (System.in);
			int t=s.nextInt();
			while(t>0){
				long n = s.nextLong();
				int k = s.nextInt();
				long mod=1000000007;
				long sum=0;
				for(long i=n; i>0; i--){
					sum =(sum + ((i-n+1)*pow(k,i))%mod)%mod;
					
				}
				sum=((sum*(sum-1)%mod)*(sum-2))%mod;
				System.out.println(sum);
				t--;
			}
	}
	public static long pow(long k, long i){
		long mod=1000000007;
		if(i==1)return k%mod;
		else if(i==2)return (k*k)%mod;
		else{
			if(i%2==0) return pow(pow(k,i/2),2)%mod;
			else return (pow(pow(k,i/2),2)*k)%mod;
		}
		
	}
} 