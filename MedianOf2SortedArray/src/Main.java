import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] A = new int[n];
		int [] B = new int[n];
		for(int i=0;i<n;i++){
			A[i]=s.nextInt();
		}
		for(int i=0;i<n;i++){
			B[i]=s.nextInt();
		}
		System.out.println(median(A,B,0,n-1,n));
	}
	public static float median(int[] a, int[] b, int s, int e, int n){
		if(s>e) return -1;
		int mid=(s+e)/2;
		
		int j=n-1-mid;
		
		if(mid==0)return (a[mid]+b[j])/2;
		if(a[mid]>b[j] && a[mid]<b[j+1]){
			
			return ((float)(a[mid]+b[j]))/2;
		}
		else if(a[mid]<b[j]){
			
			return median(a,b,mid+1,e,n);
		}
		else{
			
			return median(a,b,0,mid-1,n);
		}
	}
}
