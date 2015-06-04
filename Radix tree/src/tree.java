import java.util.*;		
public class tree {
	node root= new node();
	
	public void preorder_tree_walk(node x){
		if(x.key!=null)
		System.out.println(x.key);
		if(x.left!=null)preorder_tree_walk(x.left);
		if(x.right!=null)preorder_tree_walk(x.right);
	}

	
	
	public void tree_insert(node z ){
		 
		node x=root;
		
		node y=x;
		for(int i=0;i<z.getKey().length()-1;i++){
			
			if(z.key.charAt(i)==0){
				if(x.left==null){
					node a= new node();
					x.left=a;
					a.parent=x;
				}
				x=x.left;
			}
			else{
				if(x.right==null){
				node a= new node();
				x.right=a;
				a.parent=x;
				}
				x=x.right;
			}
			y=x;
		}
		z.parent=y;
		if(z.key.charAt(z.key.length()-1)==0)y.left=z;
		else y.right=z;
	}
	

}
