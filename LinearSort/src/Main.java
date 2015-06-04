import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main{
public static void main(String[] args) throws  IOException{
BufferedReader s =new BufferedReader(new InputStreamReader(System.in));
int n =Integer.parseInt(s.readLine());
int[] A = new int[n];
String[] x = s.readLine().split(" ");

for(int i=0;i<n;i++){
	A[i]=Integer.parseInt(x[i]);
}
sort(A,n);
} 
public static void sort(int[] A, int n){
	A=countsort(A,n,1);

	A=countsort(A,n,n);
	for(int i=0;i<n;i++){
		System.out.println(A[i]);
	}
}
public static int[] countsort(int[] A, int n, int exp){
	int[] count = new int[n];
	int[] B = new int[n];
	for(int i=0;i<n;i++){
		count[(A[i]/exp)%n]++;
	}
	for(int i=1;i<n;i++){
		count[i]=count[i]+count[i-1];
	}
	for(int i=n-1;i>=0;i--){
		B[count[(A[i]/exp)%n]-1]=A[i];
		count[(A[i]/exp)%n]--;
	}
	for(int i=0;i<n;i++){
		A[i]=B[i];
	}
	return A;
}
}