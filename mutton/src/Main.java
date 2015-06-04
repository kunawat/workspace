
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException{
		Scanner s = new Scanner(System.in);
		//BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		int t= s.nextInt();
		int[] b = new int[t];
		int max=0;
		for(int i=0;i<t;i++){
			b[i]=s.nextInt();
			if(max<b[i])max=b[i];
		}

			int[] a = new int[max+1];
			a[0]=0;
			a[1]=1;
			if(max>=2)a[2]=1;
			for(int i=3;i<=max;i++){
				a[i]=(a[i-2]+a[i-3])%1000000007;
			}
			for(int i=0;i<t;i++){
			System.out.println((a[b[i]-1]+a[b[i]])%1000000007);
			
		}
	}
	
}
