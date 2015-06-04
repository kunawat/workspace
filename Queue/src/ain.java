import java.util.Scanner;
public class ain {
	public static void main(String [] args){
		Scanner s = new Scanner (System.in); 
		int n=s.nextInt();
		int[] A = new int[n];
		queue x= new queue();
		x.enqueue(A, 1);
		x.enqueue(A,2);
		x.enqueue(A,3);
		x.enqueue(A,4);
		x.dequeue(A);
		for(int i=x.head;i<x.tail;i++){
			System.out.println(A[i]);
		}
	}
}