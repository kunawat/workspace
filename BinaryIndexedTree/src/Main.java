import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n =s.nextInt();
		int[] A = new int[n];
		int[] BT = new int[n+1];
		for(int i=0;i<n;i++){
			A[i]=s.nextInt();
		}
		for(int i=0;i<n;i++){
			update(A[i],BT,i,n);
		}
		
		System.out.println(getSum(4,BT));
	}
	
	public static void update(int val,int [] BT, int index, int n){
		index++;
		while(index<=n){
			BT[index]=BT[index]+val;
			index=index+(index & (-index));
		}
	}
	
	public static int getSum(int index, int[] BT){
		index++;
		int sum=0;
		while(index>0){
			sum=sum+BT[index];
			index=index-(index & (-index));
		}
		return sum;
	}
}
