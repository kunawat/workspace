package chef;

import java.util.Arrays;
import java.util.Scanner;
public class Main{
	public static void main(String args[]){
	
		Scanner s = new Scanner (System.in);
		int t = s.nextInt();
		while(t>0){
			int k = s.nextInt();
			int Q = s.nextInt();
			int[] M = new int[k];
			int[] S = new int[k];
			for(int i=0;i<k;i++){
				M[i]=s.nextInt();
			}
			for(int i=0;i<k;i++){
				S[i]=s.nextInt();
			}
			Arrays.sort(M);
			Arrays.sort(S);
			for(int i=0;i<Q;i++){
				int q = s.nextInt();
				int ans=0;
				int x=0;
				int y=0;	
				for(int j=1;j<q;j++){
					if(y>=k-1)x++;
					else if (x>=k-1)y++;
					else {
						int z=0;
						if(( z=(M[x+1]-M[x]))==(S[y+1]-S[y]) ){
							y++;
							int a=x;
							while(a<k-1 &&M[a+1]-M[a]==z){
								a++;
								j++;
							}
						}
						else if((M[x+1]-M[x])>(S[y+1]-S[y]) ){
							y++;
							
						}
							else x++;
					}
				}
				System.out.println(M[x]+S[y]);
			}	
			t--;
		}
	}
	
}