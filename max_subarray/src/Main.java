import java.util.*;

public class Main {
 public static void main(String args[]){
	Scanner s = new Scanner (System.in);
	int n= s.nextInt();
	int i=0;
	int[] A = new int[n];
	while(i<n){
		A[i++]=s.nextInt();
	}
	int sum=Integer.MIN_VALUE;
	int temp=0;
	for(i=0;i<n;i++){
		temp=Math.max(temp+A[i], A[i]);
		sum=Math.max(sum, temp);
	}
	System.out.println(sum);
 }
}
