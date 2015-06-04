
public class table {
	public  node search(list A[], int k){
		return A[h(k)].search(k);
	}
	public void insert(list A[],node x){
		
		A[h(x.key)].insert(x.key);
	}
	public void delete(list A[], node x){
		A[h(x.key)].delete(search(A,x.key));
	}
	public int h(int key){
		return (key%3);
	}
}
