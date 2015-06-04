
public class func {
	public static int heap_size=0;
	public int parent(int i){
		return (i-1)/2;
	}
	
	public int right(int i){
		return (2*i)+2;
	}
	
	public int left(int i){
		return (i*2)+1;
	}
	public void exchange(int A[],int a, int b){
		int t=A[a];
		A[a]=A[b];
		A[b]=t;
	}
	
	public void heapify(int A[],int  i){
		int l = left(i);
		int r = right(i);
		int largest=i;
		if(l<=heap_size-1){
			if(A[l]>A[i])largest=l;
		}
		if(r<=heap_size-1){
			if(A[r]>A[largest])largest=r;
		}

		if(largest != i){
			exchange(A,largest,i);
	
			heapify(A,largest);
		}
	}
	public void build(int A[]){
		heap_size=A.length;
		for(int i=parent(A.length-1); i>=0;i--){
			heapify(A,i);
		}
	}
	public void sort(int A[]){
		for(int i=A.length-1; i>=1; i--){
			exchange(A,0,i);
			heap_size=heap_size-1;
			heapify(A,0);
		}
	}
	public int max(int A[]){
		return A[0];
	}
	public int extract_max(int A[]){
		if(heap_size<1)
			return 0;
		int max =A[0];
		A[0]=A[heap_size-1];
		heap_size=heap_size-1;
		heapify(A,0);
		return max;
	}
	public void increase_key(int A[],int i,int key){
		if(key<A[i])return;
		A[i]=key;
		while(i>0){
			int p =parent(i);
			if(A[i]>A[p]){
				exchange(A,i,p);
				i=p;
			}
			else break;
		}
	}
	public void insert (int A[], int key){
		heap_size=heap_size+1;
		A[heap_size-1]=Integer.MIN_VALUE;
		increase_key(A,heap_size-1,key);
	}
	public void delete(int A[],int i){
		A[i]=A[heap_size-1];
		heap_size=heap_size-1;
		heapify(A,i);
	}
}
