
public class table {
	public void insert(int A[],int k){
		int i=0;
		while(i<A.length){
			int j=h(A,k,i);
			if(A[j]<0){
				A[j]=k;
				return;
			}
			i++;
		}
	}
	public int search(int A[],int k){//-2 for null
		int i=0;
		int j=h(A,k,i);
		while(i<A.length || A[j]==-2){
			j=h(A,k,i);
			if(A[j]==k){
		
				return k;
			}
			i++;
		}
		return -2;
	}
	public void delete(int A[], int k){//-1 for deleted
		int i=0;
		int j=h(A,k,i);
		while(i<A.length || A[j]==-2){
			j=h(A,k,i);
			if(A[j]==k){
				
				A[j]=-1;
				return ;
			}
			i++;
		}
	}
	public int h(int A[],int k, int i){
		int a=k%(A.length);
		int b= k%(A.length-1)+1;
		b=(a+i*b)%(A.length);
		return b;
	}
}
