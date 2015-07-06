import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n =s.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i]=s.nextInt();
		}
		
		System.out.println(llap(a,n));
	}
	
	public static int llap(int[] a, int n){
		
		if(n<=2)return n;
		
		int[][] l= new int[n][n];
		
		for(int i=0; i<n;i++){
			l[i][n-1]=2;
		}
		int llap=2;
		for(int j=n-2;j>=1;j--){
			
			int i=j-1;
			int k=j+1;
			while(i>=0 && k<=n-1){
				
				if((a[i]+a[k])<a[j]*2)k++;
				else if((a[i]+a[k])>a[j]*2){
					l[i][j]=2;
					i--;
				}
				else{
					l[i][j]=l[j][k]+1;
					llap=Math.max(l[i][j], llap);
					i--;
					k++;
				}
			}
			while(i>=0){
				l[i][j]=2;
				
				i--;
			}
		}
		return llap;
	}
}
