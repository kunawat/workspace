import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] a = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				a[i][j] =s.nextInt();
				if(a[i][j]==-1){
					a[i][j]=Integer.MAX_VALUE;
				}		
			}
		}
		for(int k=0;k<n;k++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(a[i][k]!=Integer.MAX_VALUE && a[k][j]!=Integer.MAX_VALUE && a[i][k]+a[k][j]<a[i][j]){
						a[i][j]=a[i][k]+a[k][j];
					}
				}
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				
				if(a[i][j]==Integer.MAX_VALUE){
					System.out.print(-1+" ");
				}	
				else System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}
