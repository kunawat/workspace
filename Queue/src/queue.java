
public class queue {
	public int head=0;
	public int tail=0;
	
	public void enqueue(int A[], int k){
		if(tail==head-1){
			return;
		}
		else{
			A[tail]=k;
			tail=(tail+1)%(A.length);
		}
	}
	public int dequeue(int A[]){
		if(head==tail){
			return 0;
		}
		int x=A[head];
		head++;
		return x;
	}
}
