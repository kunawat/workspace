
import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n= s.nextInt();
		int[] Value= new int[n];
		int[] Weight=new int[n];
		int W=s.nextInt();
		for(int i=0;i<n;i++){
			Value[i]=s.nextInt();
			Weight[i]=s.nextInt();
		}
		int[][] S = new int[n][W+1];

		for(int i=Weight[n-1];i<=W;i++){
			S[n-1][i]=Value[n-1];
		}
		int w=W;
		for(int i=n-2;i>=0;i--){
			for(w=0;w<=W;w++){
				if(w<Weight[i])S[i][w]=S[i+1][w];
				else S[i][w]=Math.max(S[i+1][w-Weight[i]]+Value[i],S[i+1][w]);
			}
		}
		System.out.println(S[0][W]);
	}
}
