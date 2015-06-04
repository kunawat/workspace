import java.util.Random;
public class sort {
	public void exchange(int A[],int a, int b){
		int t=A[a];
		A[a]=A[b];
		A[b]=t;
	}
	public int partition(int A[], int p, int r){
		int x=A[r];
		int i=p-1;
		int k=p-1;
		for(int j=p;j<r;j++){
			if(A[j]<x){
				i++;
				k++;
				exchange(A,k,j);
				exchange(A,k,i);
			}
			if(A[j]==x){
				k++;
				exchange(A,k,j);
			}
		}
		exchange(A,i+1,r);
		return i+1;
	}
	public void quicksort(int A[], int p, int r){
		while(p<r){
			int q =randomized_partition(A,p,r);
			if(q-p<r-q){
				quicksort(A,p,q-1);
				p=q+1;
			}
			else{
				quicksort(A,q+1,r);
				r=q-1;
			}
		}
	}
	public int randomized_partition(int A[],int p,int r){
		Random generator = new Random(); 
		int i = generator.nextInt(r-p+1) + p;
		exchange(A,i,r);
		return partition(A,p,r);

	}
}
