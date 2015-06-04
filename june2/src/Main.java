import java.util.*;
public class Main{
	public static void main(String args[]){
	
		Scanner s = new Scanner (System.in);
		int t = s.nextInt();
		while(t>0){
		int n=s.nextInt();
		int[] A= new int[4];
		A[0]=2;
		A[1]=1;
		A[2]=2;
		A[3]=0;
		int[] B= new int[4];
		B[0]=3;
		B[1]=1;
		B[2]=1;
		B[3]=0;
		if(n==1)System.out.println(1);
		else if(n==2)System.out.println(3);
		else{
		A=pow(A,n-2);
		
		B=Multiply(B,A);
		System.out.println(B[0]);
		}
		t--;
		}
	}
	public static int[] pow(int[] A, int n){
		if(n==1)return A;
		if (n==2)return Multiply(A,A);
		else{
			if(n%2==0) return pow(pow(A,n/2),2);
			else return Multiply(pow(pow(A,n/2),2),A);
		}
	}
	public static int[] Multiply(int[] A, int[] B){
		int p =(A[0]*B[0]+A[1]*B[2])%2000000014;
		int q =(A[0]*B[1]+A[1]*B[3])%2000000014;
		int r =(A[2]*B[0]+A[3]*B[2])%2000000014;
		int s =(A[2]*B[1]+A[3]*B[3])%2000000014;
		A[0]=p;
		A[1]=q;
		A[2]=r;
		A[3]=s;
		return A;
	}
}