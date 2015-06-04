	
public class list {
	node head=null;
	public void insert(int x){
		if(head==null){
			
			head =new node(x);
		}
		else{
			node n = new node(x);
			n.next=head;
			head.prev=n;
			head=n;
		}
	}
	public node search(int x){
		node n=head;
		while(n!=null && n.key!=x){
			n= n.next;
		}
		return n;
	}
	public void delete (node x){
		if(x.prev!=null)
			x.prev.next=x.next;
		else{
			head=x.next;
		}
		if(x.next!=null)x.next.prev=x.prev;
	}
	public void reverse(){
		
		node a=head.next.next;
		head.next.next=head;
		node x;
		 x=head.next;
		while(a.next!=null ){
			node b=null;
		
	
				b=a.next;
				a.next=x;	
				x=a;
			a=b;
			
		}
		a.next=x;
		head.setNext(null);
		head=a;
		
	}
}
