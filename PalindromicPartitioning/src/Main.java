import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		char[] c =s.next().toCharArray();
		int n =c.length;
		boolean[][] pal= new boolean[n][n];
		for(int i=0;i<n;i++)pal[i][i]=true;
		for(int l=2;l<=n;l++){
			for(int i=0;i<n-l+1;i++){
				int j=i+l-1;
				if(l==2){
					if(c[i]==c[j])pal[i][j]=true;
					else pal[i][j]=false;
				}
				else{
					pal[i][j]=(c[i]==c[j])&&pal[i+1][j-1];
				}
			}
		}
		int[] count= new int[n];
		
		for(int i=0;i<n;i++){
			count[i]=Integer.MAX_VALUE;
			if(pal[0][i])count[i]=0;
			else{
				for(int k=0;k<i;k++){
					if(pal[k+1][i]==true && count[k]+1<count[i]){
						count[i]=count[k]+1;
					}
				}
			}
		}
		System.out.println(count[n-1]);
		
	}
}
