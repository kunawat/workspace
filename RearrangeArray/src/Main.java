//Given an array of size n where all elements are in range from 0 to n-1,
//change contents of arr[] so that arr[i] = j is changed to arr[j] = i.
import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n =s.nextInt();
		int[] A = new int[n];
		for(int i=0;i<n;i++){
			A[i]=s.nextInt()+1;
		}
		for(int i=0;i<n;i++){
			if(A[i]>0){
				int idx= A[i]-1;
				int value=i;
				int temp=-1;
				while(idx!=i){
					//System.out.println(idx);
					temp=A[idx]-1;
					A[idx]=-value;
					value=idx;
					idx=temp;
					
				}
				A[idx]=-value;
			}
		}
		for(int i=0;i<n;i++){
			System.out.println(Math.abs(A[i]));
		}
	}
}
