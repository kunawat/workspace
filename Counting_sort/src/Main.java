import java.util.Scanner;
public class Main {
	public static void main(String [] args){
		Scanner s = new Scanner (System.in); 
		int n=s.nextInt();
		int[] A = new int[n];
		int[] B = new int[n];
		int i=0;
		int max=0;
		while(i<n){
			A[i]=s.nextInt();
			if(A[i]>max){
				max=A[i];		
			}
			i++;
		}
		sort x =new sort();
		x.counting_sort(A,B,max);
		for(i=0;i<n;i++){
			System.out.println(B[i]);
		}
	}
}
