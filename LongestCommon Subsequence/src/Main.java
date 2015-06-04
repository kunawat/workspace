import java.util.*;
public class Main {
	public static void main(String[] args){
		 Scanner s= new Scanner (System.in);
		 int n=s.nextInt();
		// int m=s.nextInt();
		char[] X=new char[n];
	char[] Y=new char[n];
		int i=0;
		
		while(i<n){
			X[i++]=s.next().charAt(0);
		}
		i=0;
		while(i<n){
			Y[i]=X[n-i-1];
			i++;
		}
		
		
		LCS_length(X,Y);
	}
	public static void LCS_length(char[] X, char[] Y){
		int m=X.length;
		int n=Y.length;
		int[][] c =new int[m+1][n+1];
		char[][] b =new char[m+1][n+1];
		for(int i=0;i<=m;i++){
			c[i][0]=0;
		}
		for(int i=0;i<=n;i++){
			c[0][i]=0;
		}
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(X[i-1]==Y[j-1]){
					c[i][j]=1+c[i-1][j-1];
					b[i][j]='\\';
				}
				else if(c[i-1][j]>=c[i][j-1]){
					c[i][j]=c[i-1][j];
					b[i][j]='|';
				}
				else{
					c[i][j]=c[i][j-1];
					b[i][j]='_';
				}
			}
		}
		System.out.println(c[m][n]);
		print(b,X,m,n);
	}
	public static void print(char[][] b,char[] X,int i,int j){
		if(i==0 || j==0)return;
		if(b[i][j]=='\\'){
			print(b,X,i-1,j-1);
			System.out.print(X[i-1]);
		}
		else if(b[i][j]=='|')print(b,X,i-1,j);
		else print(b,X,i,j-1);
	}
}
