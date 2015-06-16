 //If the trader is allowed to make at most 2 transactions in a day,
 //where as second transaction can only start after first one is complete (Sell->buy->sell->buy). 
 //Given stock prices throughout day, find out maximum profit that a share trader could have made.
import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s= new Scanner (System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for(int i=0;i<n;i++){
			A[i]=s.nextInt();
		}
		int[] profit = new int[n];
		int maxPrice=A[n-1];
		for(int i=n-2;i>=0;i--){
			if(A[i]>maxPrice)maxPrice=A[i];
			profit[i]=Math.max(profit[i+1],maxPrice-A[i]);
		}
		int minPrice=A[0];
		for(int i=1;i<n;i++){
			if(A[i]<minPrice)minPrice=A[i];
			profit[i]=Math.max(profit[i-1],profit[i]+A[i]-minPrice);
		}
		System.out.println(profit[n-1]);
	}
}
