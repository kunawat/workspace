//Given an array of integers. Find a peak element in it.
//An array element is peak if it is NOT smaller than its neighbors. 
//For corner elements, we need to consider only one neighbor.
//O(logN)
import java.util.*;
public class Main {
	public static void main(String arg[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] A =new int[n];
		for(int i=0;i<n;i++){
			A[i]=s.nextInt();
		}
		int i=peak(A,0,n-1);
		System.out.println("index: "+i);
	}
	public static int peak(int[] A, int s , int e){
		if(s>e)
			return -1;
		if(s==e)return s;
		int mid =(s+e)/2;
		if(mid==s && mid>A[s+1]){
			return mid;
		}
		else{
			if(A[mid]>A[mid-1] && A[mid]>A[mid+1]){
				return mid;
			}
			else if(A[mid-1]>A[mid])return peak(A,s,mid-1);
			else return peak(A,mid+1,e);
		}
	}
}
