import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		tree T = new tree();
		node x = new node();
		x.key="100";
		T.tree_insert(x);
		node y = new node();
		y.key="1";
		T.tree_insert(y);
		node z = new node();
		z.key="110";
		T.tree_insert(z);
		node w = new node();
		w.key="0";
		T.tree_insert(w);
		T.preorder_tree_walk(T.root);
	}
}
