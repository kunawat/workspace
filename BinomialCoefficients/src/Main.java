import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		int k= s.nextInt();
		int c[] = new int[k+1];
		c[0]=1;
		for(int i=1;i<=n;i++){
			for(int j=Math.min(i,k);j>0;j--){
				c[j]=c[j]+c[j-1];
			}
		}
		System.out.println(c[k]);
	}
}
