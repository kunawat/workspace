import java.util.Scanner;
public class Main {
	public static void main(String [] args){
		Scanner s = new Scanner (System.in); 
		tree t = new tree();
		for(int i=0;i<7;i++){
			int n= s.nextInt();
			node x= new node(n);
			t.tree_insert(x);
		}
		t.permute(7,3);
		/*System.out.println(t.rank(t.tree_search(5)));
		System.out.println(t.select(t.root, 4).key);
		System.out.println("Inorder");
		t.inorder_tree_walk(t.root);
	
		System.out.println("Preorder");
		t.preorder_tree_walk(t.root);	
		System.out.println("Postorder");
		t.postorder_tree_walk(t.root);
		System.out.println("minimum: "+t.tree_minimum(t.root).key);
		System.out.println("maxnimum: "+t.tree_maximum(t.root).key);
		
		System.out.println("Successor: "+t.successor(t.tree_search(14)).key);
		System.out.println("Predecessor: "+t.predecessor(t.tree_search(14)).key);
		t.tree_delete(t.tree_search(10));
		t.inorder_tree_walk(t.root);*/
	}
}
