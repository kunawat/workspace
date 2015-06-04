import java.util.*;
public class Main {

	public static void main(String args[]){
		Scanner s= new Scanner(System.in);
		int n=s.nextInt();
		int sum=0;
		int[] A = new int[n];
		for(int i=0;i<n;i++){
			A[i]=s.nextInt();
			sum+=A[i];
		}
		sum=sum/2;
		boolean b[][]= new boolean[sum+1][n+1];
		for(int i=0;i<sum+1;i++){
			b[i][0]=true;
		}
		for(int i=0;i<n+1;i++){
			b[0][i]=false;
		}
		for(int i=1;i<sum+1;i++){
			for(int j=1;j<n+1;j++){
				if(i>=A[j-1])
				b[i][j]=b[i][j-1] || b[i-A[j-1]][j-1];
				else
					b[i][j]=b[i][j-1];
			}
		}
		if(b[sum][n])System.out.println("Yup");
		else System.out.println("naa");
	}
}
