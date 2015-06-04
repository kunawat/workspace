
public class sort {
	public void merge_sort(int[] A, int p, int r){
		if(p<r){
			int q= (p+r)/2;
			merge_sort(A,p,q);
			merge_sort(A,q+1,r);
			merge(A,p,q,r);
		}	
	}
	
	public void merge(int[] A, int p, int q, int r){
		int n1=q-p+1;
		int n2=r-q;
		int[] L =new int[n1];
		int[] M =new int[n2];
		for(int i=0;i<n1;i++){
			L[i]=A[p+i];
		}
		for(int i=0;i<n2;i++){
			M[i]=A[q+1+i];
		}
		int i=0, j=0, k=p;
		for(k=p;k<=r;){
			if(i==n1) A[k++]=M[j++];
			else if(j==n2) A[k++]=L[i++];
			else if(L[i]<=M[j]){
				A[k++]=L[i++];
			}
			else A[k++]=M[j++];
		}	
	}
}
