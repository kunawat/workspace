import java.util.Scanner;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner (System.in);
		int n=s.nextInt();
		String[] l = new String[n];
		for(int i=0;i<n;i++){
			l[i]=s.next();
			
		}
		int M=s.nextInt();
		print_neatly(l,n,M);
	}
	public static void print_neatly(String[] l,int n, int M){
		int[][] extras = new int[n][n];
		for(int i=0;i<n;i++){
			extras[i][i]=M-l[i].length();
			for(int j=i+1;j<n;j++){
				extras[i][j]=extras[i][j-1]-1-l[j].length();
			}
		}

		int[][] lc= new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<i;j++){
				lc[i][j]=Integer.MAX_VALUE;
			}
			for(int j=i;j<n;j++){
				if(extras[i][j]<0){
					lc[i][j]=Integer.MAX_VALUE;
					
				}
				else if(j==n-1 && extras[i][j]>=0)lc[i][j]=0;
				else{
					lc[i][j]=extras[i][j]*extras[i][j]*extras[i][j];
				}
			}
		}
		int[] C=new int[n+1];
		int[] P=new int[n+1];
		C[0]=0;
		P[0]=0;
		for(int i=0;i<n;i++){
			C[i+1]=Integer.MAX_VALUE;
			for(int j=0;j<=i;j++){
				if(lc[j][i]!=Integer.MAX_VALUE){
				if(C[i+1]>C[j]+lc[j][i]){
					C[i+1]=C[j]+lc[j][i];
					P[i+1]=j+1;
				
				}
				}
			}
		
		}
		System.out.println(C[n]);
		print(l,P,n);
	}
	public static int print(String[] l, int[] P, int n){
		int i=P[n];
		System.out.println(P[n]);
		int k;
		if(i==1){
			k=1;
			
		}
		else{
			print(l,P,i-1);
			k=i;
		}
		for(int j=k; j<=n;j++){
			System.out.print(l[j-1] +" ");
			if(j==n)System.out.println();
		}
		return k;
	}
}
