import java.util.Scanner;
public class Main {
	public static void main(String [] args){
		Scanner s = new Scanner (System.in); 
		tree t = new tree();
		for(int i=0;i<7;i++){
			int n= s.nextInt();
		node x= new node(n,0);
		t.tree_insert(x);
		}

		
	
		/*System.out.println("Preorder");
		t.preorder_tree_walk(t.root);
			t.tree_delete(t.tree_search(1));*/
		t.inorder_tree_walk(t.root);
		node z =new node(5,0);
		node x=t.persistent_tree_insert(z);
		System.out.println("Inorder");
		t.inorder_tree_walk(x);
	}
}
