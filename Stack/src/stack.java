
public class stack {
public int top=-1;
	public boolean isempty(){
		if(top==-1){
			return true;
		}
		else return false;
	}
	public void push(int A[],int k){
		top=top+1;
		if (top==A.length){
			return;
		}
		A[top]=k;
	}
	public int pop(int A[]){
		if(top==-1){
			return 0;
		}
		else{
			top=top-1;
			return A[top+1];
		}
	
		
	}
}
