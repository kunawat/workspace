
public class sort {
	public void counting_sort(int A[],int B[], int k){
		int C[] = new int[k+1];
		for(int i=0;i<=k;i++){
			C[i]=0;
		}
		for(int i=0;i<A.length;i++){
			C[A[i]]++;
		}
		for(int i=1;i<=k;i++){
			C[i]=C[i]+C[i-1];
		}
		for(int i=A.length-1;i>=0;i--){
			B[C[A[i]]-1]=A[i];
			C[A[i]]--;
		}
	}
}
