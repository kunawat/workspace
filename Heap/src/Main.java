import java.util.*;
public class Main{
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		int A[] = new int[n];
		func h =new func();
		for(int i=0;i<n;i++){
			A[i]=s.nextInt();
		}
		
		h.build(A);
		System.out.println(A[0]);
		int key=s.nextInt();
		h.delete(A, key);
		h.insert(A, 7);
	
		h.sort(A);
		for(int i=0;i<n;i++){
			System.out.println(A[i]);
		}
	}
}