
public class node {
	node parent;
	node left;
	node right;
	int key;
	int color;
	int height;
	public node(int key,int c) {
		super();
		this.key = key;
		this.color=c;
	}
}
