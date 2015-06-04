
public class node {
	node next=null;
	int key;
	node prev=null;
	public node(int key) {
		super();
		this.key = key;
	}
	public node getNext() {
		return next;
	}
	public void setNext(node next) {
		this.next = next;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public node getPrev() {
		return prev;
	}
	public void setPrev(node prev) {
		this.prev = prev;
	}
}
