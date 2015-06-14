import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		//n- No. of elements in array
		int n =s.nextInt();
		int[] A = new int[n];
		// Input array elements
		for(int i=0;i<n;i++){
			A[i]=s.nextInt();
		}
		Stack<Integer> st= new Stack<Integer>();
		int stacksum=0;//keeps the sum of elements in stack
		int ans=0;//contains ans till i-th index in below loop
		
		for(int i=0;i<n;i++){
			//to keep the stack elements in increasing order pop
			//the smaller elements and update stacksum
			while(!st.isEmpty() && st.peek()>A[i]){
				stacksum=stacksum-st.peek();
				st.pop();
			}
			
			//push new element and update stacksum
			st.push(A[i]);
			stacksum=stacksum+A[i];
			//update ans if stacksum is greater than ans
			if(stacksum>ans)ans=stacksum;
		}
		System.out.println(ans);
	}
}
