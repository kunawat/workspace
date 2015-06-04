import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n =s.nextInt();
		int[][] a = new int[n][2];
		for(int i=0;i<n;i++){
			a[i][0]=s.nextInt();
			a[i][1]=s.nextInt();
		}
		Arrays.sort(a, new Comparator<int[]>(){
			public int compare(int[] o1, int[] o2){
			return Integer.compare(o1[0],o2[0]);
			}
		});
		int wait=0;
		int x=a[0][1];
		for(int i=1;i<n;i++){
			if(x-a[i][0]>0){
			wait=wait+(x-a[i][0]);
			}
			else 
			x=x+a[i][1];
			
			
		}
		float ans= (((float)wait)/((float)n));
		System.out.println(ans);
	}
}
