import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner s= new Scanner (System.in);
		int n= s.nextInt();
		int[] p=  new int[n+1];
		int i=0;
		while(n>=i){
			p[i]=s.nextInt();
			i++;
		}
		Print_Optimal_Parens(Matrix_Chain_Order(p),0,n-1);
	}
	public static int[][] Matrix_Chain_Order(int[] p){
		int n=p.length-1;
		int[][] m =new int[n][n];
		int[][] s =new int[n][n];
		for(int i=0;i<n;i++){
			m[i][i]=0;
		}
		for(int l=2; l<=n;l++){
			for(int i=0;i<=n-l;i++){
				int j=i+l-1;
				m[i][j]=Integer.MAX_VALUE;
				for(int k=i;k<j;k++){
					int q=m[i][k]+m[k+1][j]+(p[i]*p[k+1]*p[j+1]);
					if(q<m[i][j]){
						m[i][j]=q;
						s[i][j]=k;
					}
				}
			}
		}
		System.out.println(m[0][n-1]);
		return s;
	}
	public static void Print_Optimal_Parens(int[][] s,int i, int j){
		if(i==j)System.out.print("A"+i);
		else{
			System.out.print("(");
			Print_Optimal_Parens(s,i,s[i][j]);
			Print_Optimal_Parens(s,s[i][j]+1,j);
			System.out.print(")");
		}
	}
}
