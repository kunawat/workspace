import java.util.*;
public class Main {
	public static void main(String [] args) throws Exception{
		Scanner s = new Scanner (System.in); 
		try{
		int t=s.nextInt();
		while(t>0){
			int n=s.nextInt();
			int z=s.nextInt();
			int[][] A = new int[n+1][2];
			int i=0;
			
			int min=Integer.MAX_VALUE;
			while(i<n){
				A[i][0]=s.nextInt();
				A[i][1]=s.nextInt();
				i++;
			}
			A[n][0]=0;
			A[n][1]=0;
			int c=0;
			for(int j=0;j<=n-z;){
				int x=Math.max(A[j][0],A[j+z][0]);
				int y=Math.max(A[j][1],A[j+z][1]);
				int a=x*y;
				
					min=a;
					x=j+z;
				
				for(int k=j+1;k<j+z;k++){
					int l=A[k][0]*A[k][1];
					if(l<min){
						min=l;
						x=k;
					}
				}
				j=x;
			}
			System.out.println(min);
		}
		}
		catch(Exception e){
			return;
		}
	}
}
