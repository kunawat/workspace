import java.util.*; 
public class Main {
	public static void main(String args[]){
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int[][] a= new int[n][n]; 
		for(int i=0;i<n;i++){
			a[i][0]=s.nextInt();
			a[i][1]=s.nextInt();
		}
		Arrays.sort(a, new Comparator<int[]>() {
		    public int compare(int[] o1, int[] o2) {
		        return ((Integer) o2[0]).compareTo(o1[0]);
		    }
		});
		int wait=0;
		int x=a[n-1][1];
		for(int i=n-2;i>=0;i--){
			wait+=x-a[i][0];
			x+=a[i][1];
		}
		double ans= ((double)wait)/n;
		System.out.println("Avg Wait Time: "+ans);
		System.out.println("Avg Response Time: "+ans);
	}
}
