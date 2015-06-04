
import java.util.*;

public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		char[] n=(s.next()).toCharArray();
		int c = s.nextInt();
		int l=n.length;
		//System.out.println(n+" "+c);
		int[][] a = new int[c+1][3];
		int[][] b = new int[c+1][3];
		int x =n[0]-48;
		int min=Math.max(0,x);
		int max=Math.min(9,x);
		
		
		for(int j=min;j<=max;j++){
			int m=j%3;
			int k=Math.abs(x-j);
			for(int p=0;p<=(c-k);p++){
				
				a[k+p][(m+0)%3]++;
				a[k+p][(m+2)%3]++;
				a[k+p][(m+1)%3]++;
			}
		}
		for(int i=1;i<l;i++){
			x =n[i]-48;
			//System.out.println(x);
			min=Math.max(0,x-c);
			max=Math.min(9,x+c);
			
			
			for(int j=min;j<=max;j++){
				int m=j%3;
				int k=Math.abs(x-j);
				for(int p=0;p<=(c-k);p++){
					
					if(a[p][0]>0)b[k+p][(m+0)%3]+=a[p][0];
					if(a[p][1]>0)b[k+p][(m+1)%3]+=a[p][1];
					if(a[p][2]>0)b[k+p][(m+2)%3]+=a[p][2];
				}
			
			}
			for(int f=0;f<3;f++){
				for(int p=0;p<=c;p++){
					a[p][f]=b[p][f];
				}
			}
			for(int f=0;f<3;f++){
				for(int p=0;p<=c;p++){
					System.out.print(a[p][f]);
				}
				System.out.println();
			}
			for(int f=0;f<3;f++){
				for(int p=0;p<=c;p++){
					b[p][f]=0;
				}
			}
			
		}
		int ans=0;
		for(int i=0;i<c;i++){
			ans=ans+a[i][0];
		}
		System.out.println(ans);
	}
}
