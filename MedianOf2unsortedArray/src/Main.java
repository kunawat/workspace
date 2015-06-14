import java.util.Scanner;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m=s.nextInt();
		int[] A = new int[n];
		int [] B = new int[m];
		for(int i=0;i<n;i++){
			A[i]=s.nextInt();
		}
		for(int i=0;i<m;i++){
			B[i]=s.nextInt();
		}
		int sum=m+n;
		
		System.out.println(median(A,B,0,n-1,m,sum));
	}
	public static float median(int[] a, int[] b, int s, int e, int n, int sum){
		if(s>e){
			if(s==0){
				if(sum%2==1){
					
					return b[sum/2];
				}
				else{
					
					return ((float)(b[sum/2-1]+b[sum/2]))/2;
				}
			}
			else{
				if(sum%2==0){
					
					if(n-s-2<0){
						return ((float)(a[s-1]+b[n-s-1]))/2;
					}
					else return ((float)(b[n-s-1]+b[n-s-2]))/2;
				}
				else {
					
					return b[sum/2-s];
				}
			}
		}
		int mid=(s+e)/2;
		
		int j=(sum/2)-1-mid;
		
		if(mid==0 && sum/2==n){
			
			return ((float)(a[mid]+b[j]))/2;
		}
		
		if(a[mid]>b[j] && a[mid]<b[j+1]){
			if(sum%2==0){
				
			return ((float)(a[mid]+b[j]))/2;
			}
			else {
				
				return a[mid];
			}
		}
		else if(a[mid]<b[j]){
			
			return median(a,b,mid+1,e,n,sum);
		}
		else{
			
			return median(a,b,0,mid-1,n,sum);
		}
	}
}
