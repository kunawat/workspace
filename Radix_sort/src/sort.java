
public class sort {
	public void radix_sort(int A[], int d){
		int j=1;
		int B[] = new int[A.length];
		while(j<=d){
			int t=1;
			for(int i=1;i<j;i++){
				t=t*10;
			}
					
			int C[] = new int[10];
			for(int i=0;i<=9;i++){
				C[i]=0;
			}
			for(int i=0;i<A.length;i++){
				C[((A[i]/t)%10)]++;
			}
			for(int i=1;i<=9;i++){
				C[i]=C[i]+C[i-1];
			}
			for(int i=A.length-1;i>=0;i--){
				B[C[((A[i]/t)%10)]-1]=A[i];
				C[((A[i]/t)%10)]--;
			}
			for(int i=0;i<A.length;i++){
				A[i]=B[i];
			}
			j++;
		}
		
	}
	public int digit(int i){
		int c=1;
		while(i/10>0){
			c++;
			i=i/10;
		}
		return c;
	}
}
