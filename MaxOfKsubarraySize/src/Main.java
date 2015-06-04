import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k=s.nextInt();
		int A[] = new int[n];
		for(int i=0;i<n;i++){
			A[i]=s.nextInt();
		}
		ArrayDeque<Integer> d = new ArrayDeque<Integer>(k);
		int i=0;
		for(;i<k;i++){
			while(!d.isEmpty() && A[i]>=A[d.getLast()]){
				d.removeLast();
			}
			d.addLast(i);
		}
		for(;i<n;i++){
			System.out.println(A[d.getFirst()]);
			while(!d.isEmpty() && d.getFirst()<=i-k){
				d.removeFirst();
			}
			while(!d.isEmpty() && A[i]>=A[d.getLast()]){
				d.removeLast();
			}
			d.addLast(i);
		}
	}
}
