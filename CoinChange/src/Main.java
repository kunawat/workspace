import java.util.*;

public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n =s.nextInt();
		int m =s.nextInt();
		int[] a = new int[m];
		for(int i=0;i<m;i++){
			a[i]=s.nextInt();
		}
		int ans[]= new int[n+1];
		ans[0]=1;
		for(int i=0;i<m;i++){
			for(int j=a[i];j<=n;j++){
				ans[j]+=ans[j-a[i]];
			}
		}
		System.out.println(ans[n]);
	}
}
