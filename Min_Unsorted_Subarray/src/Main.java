import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(s.readLine());
		
		int[] A = new int[n];
		Stack<Integer> S = new Stack<Integer>();
		Queue<Integer> Q = new LinkedList<Integer>();
		String[] x =s.readLine().split(" ");
		
		for(int i=0;i<n;i++){
			A[i]=Integer.parseInt(x[i]);
			S.push(A[i]);
			Q.add(A[i]);
		}
		
		int i=1;
		while( A[i]>A[i-1]){
			i++;
		}
		int count =0;
		int index =i;
		int max=A[i-1];
		int min= index;
		while(i>=1 && A[i-1]>A[index]){
			i--;
			count++;
		}
		for(int j=index+1;j<n;j++){
			if(A[j]<A[min])min=j;
		}
		
		while(i>=1 && A[i-1]>A[min]){
			i--;
			count++;
		}
		for(int j=index+1;j<n;j++){
			if(A[j]<max){
					count =count+(j-index);
						index=j;
						
			}
			else{
					max=A[j];
				}
		}
		if(count>0)count++;
		System.out.println(count);
	}
}