import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n =s.nextInt();
		if(n<=6){
			System.out.println(6);
		}
		else{
			int i=0;
			int[] a = new int[n];
			for(i=0;i<6;i++){
				a[i]=i+1;
			}
			for(i=6;i<n;i++){
				a[i]=Math.max((a[i-3])*2,Math.max(a[i-5]*4, a[i-4]*3));
			}
			for( i=0;i<n;i++){
				System.out.println(a[i]);
			}
		}
		
	}
}
