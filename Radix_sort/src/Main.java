import java.util.Scanner;
public class Main {
	public static void main(String [] args){
		Scanner s = new Scanner (System.in); 
		int n=s.nextInt();
		int[] A = new int[n];
		int i=0;
		sort x =new sort();
		int max=0;
		while(i<n){
			A[i]=s.nextInt();
			
			if(x.digit(A[i])>max){
				max=x.digit(A[i]);		
			}
			i++;
		}
	
		x.radix_sort(A,max);
		for(i=0;i<n;i++){
			System.out.println(A[i]);
		}
	}
}
