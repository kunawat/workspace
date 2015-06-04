import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner (System.in);
		
		int t = s.nextInt();
		while(t>0){
			int X = s.nextInt();
			int Y = s.nextInt();
			int P = s.nextInt();
			int N = s.nextInt();
			float D = s.nextFloat();
			int ans=0;
			for(int i=0;i<N;i++){
				int x = s.nextInt();
				int y = s.nextInt();
				int p = s.nextInt();
				if(P>=p && D>=(float)Math.sqrt((X-x)*(X-x)+(Y-y)*(Y-y))){
					ans++;
				}
			}
			
			System.out.println(ans);
			t--;
			
		}
		
	}
}
