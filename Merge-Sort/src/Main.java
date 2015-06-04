import java.util.Scanner;
public class Main {
	public static void main(String [] args){
		Scanner s = new Scanner (System.in); 
		int n=s.nextInt();
		int[] A = new int[n];
		int i=0;
		while(i<n){
			A[i++]=s.nextInt();
		}
		sort x =new sort();
		x.merge_sort(A,0,n-1);
		for(i=0;i<n;i++){
			System.out.println(A[i]);
		}
	}
}
