import java.util.Scanner;
public class Main {
	public static void main(String [] args){
		Scanner s = new Scanner (System.in); 
		int n=s.nextInt();
		int[] A = new int[n];
		stack x= new stack();
		x.push(A,1);
		x.push(A,2);
		x.push(A,3);
		x.push(A,4);
		x.pop(A);
		for(int i=0;i<=x.top;i++){
			System.out.println(A[i]);
		}
	}
}