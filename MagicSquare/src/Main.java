import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s =new Scanner(System.in);
		int n =s.nextInt();//must be odd
		int num=n*n;
		int r=n/2;
		int c=n-1;
		int magicsquare[][] = new int[n][n];
		for(int i=1;i<=num;){
			
			if(r==-1 && c==n){
				r=0;
				c=n-2;
			}
			else{
				if(c==n)c=0;
				else if(r<0)r=n-1;
			}
			if(magicsquare[r][c]>0){
				r=r+1;
				c=c-2;
				continue;
			}
			else{
				magicsquare[r][c]=i++;
			}
			r--;
			c++;
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(magicsquare[i][j]+" ");
			}
			System.out.println();
		}		
	}
}
