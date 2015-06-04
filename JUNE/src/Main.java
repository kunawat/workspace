import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int t= s.nextInt();
		while(t>0){
			String n = s.next();
			
			int k = n.length();
			int[] x = new int[10];
			for(int i=0; i<k; i++){
				
				x[(int)(n.charAt(i))-48]++;
			}
			
			long ans=0;
			for(int i=0; i<k; i++){
				long sum=0;
				long z=fact(k-i-1);
				for(int j=0;j<(int)(n.charAt(i))-48;j++){
					
					if(x[j]>0){
						long a =z;
						if(x[j]>2)
						a=a/fact(x[j]-1);
						for(int q =j+1;q<10;q++){
							a=a/fact(x[q]);
						}
						sum=sum+a;
					}
					
				}
				
				ans =ans+sum;
				x[(int)(n.charAt(i))-48]--;
				
				
			}
			System.out.println(ans+1);
			t--;
		}
		
	}
	public static long fact(int n){
		long ans =1;
		for(int i=2;i<=n;i++){
			ans=ans*i;
		}
		return ans;
	}
}