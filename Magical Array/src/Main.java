import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int n= s.nextInt();
		int[] A = new int[n+1];
		int i=0;
		int moves=0;
		while(i<n){
			int k =s.nextInt();
			if(k<=0){
				A[1]++;
				moves=moves+1-k;
			}
			else if(k>n){
				A[n]++;
				moves=moves+k-n;
			}
			else{
				A[k]++;
			}
			i++;
		}
		for(i=n;i>0;i--){
			if(A[i]>1){
				moves=moves+A[i]-1;
				A[i-1]=A[i-1]+A[i]-1;
			}
			else if(A[i]<1){
				moves=moves+1-A[i];
				A[i-1]=A[i-1]+A[i]-1;
			}
		}
		System.out.println(moves);
	}
}
