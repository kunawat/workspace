
public class table {
	
	public  node search(list A[], int k){
		return A[k].head;
	}
	public void insert(list A[],node x){
		
		A[x.key].insert(x.key);
	}
	public void delete(list A[], node x){
		A[x.key].delete(x);
	}
}
