import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int t= s.nextInt();
		while(t>0){
		int n = s.nextInt();
		int[] A = new int[n+1];
		long c=1;
		int d=1;
		if(n%2==1){
			n=n-1;
			d=26;
		}
		for(int i=1;i<=n;i++){
			if(A[i]==0){
				c=(c*26)%1000000007;
				
				while(A[i]==0){
					A[i]++;
					if(i<=n/2)
					i=i*2;
					else i=(2*i)-(n+1);
				}
			}
		}
		long x=(c*d)%1000000007;
		System.out.println(x);
		t--;
		}
	}
}
