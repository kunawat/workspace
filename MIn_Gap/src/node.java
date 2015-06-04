
public class node {
	node parent;
	node left;
	node right;
	int key;
	int color;
	int height;
	int min;
	int max;
	int min_gap;
	public node(int key,int c) {
		super();
		this.key = key;
		this.color=c;
	}
}
