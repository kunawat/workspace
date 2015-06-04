import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int t= s.nextInt();
		while(t>0){
			int n= s.nextInt();
			int[] A = new int[n];
			for(int i=0; i<n; i++){
				A[i]=s.nextInt();
			}
			Arrays.sort(A);
			long ans=1;
			for(int j=n-1;j>=0;j--){
				for(int k=j-1;k>=0;k--){
					
					int gcd=gcd(Math.max(A[j],A[k]),Math.min(A[j],A[k]));
					if(gcd!=0){
					A[j]=A[j]/gcd;
					A[k]=A[k]/gcd;
					}
					if(A[j]==1)break;
				}
				ans=(ans*A[j])%(1000000007);
			}
			System.out.println(ans);
			t--;
		}
		
	}
	public static int gcd (int x, int y){
		while(x>=1){
			int t =y%x;
			y=x;
			x=t;
		}
		return y;
	}
}
