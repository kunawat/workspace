import java.util.*;		
public class tree {
	node root;
	public void inorder_tree_walk(node x){
		
		Stack <node> s = new Stack <node>();
		s.push(x);
		boolean check=true;
		while(!s.isEmpty()){
			while(x.left!=null){
				s.push(x.left);
				x=x.left;
			}
			
			while(check){
				if(!s.isEmpty()){
					x=s.pop();
					System.out.println(x.key);
					if(x.right!=null){
						s.push(x.right);
						x=x.right;
						check=false;
					}
			   }
		    }
			check=true;
		}
	}
	public void preorder_tree_walk(node x){
		System.out.println(x.key);
		if(x.left!=null)preorder_tree_walk(x.left);
		if(x.right!=null)preorder_tree_walk(x.right);
	}
	public void postorder_tree_walk(node x){

		if(x.left!=null)postorder_tree_walk(x.left);
		if(x.right!=null)postorder_tree_walk(x.right);
		System.out.println(x.key);
	}
	public node tree_search( int k){
		node x=root;
		while(x!=null && x.key!=k){
			if(x.key<k)x=x.right;
			else x=x.left;
		}
		return x;
	}
	public node tree_minimum(node x){
		while(x.left!=null){
			x=x.left;
		}
		return x;
	}
	public node tree_maximum(node x){
		while(x.right!=null){
			x=x.right;
		}
		return x;
	}
	public node successor(node x){
		if(x.right!=null){
			return(tree_minimum(x.right));
		}
		node y=x.parent;
		while(y!=null && x==y.right){
			x=y;
			y=y.parent;
		}
		return y;
	}
	public node predecessor(node x){
		if(x.left!=null){
			return(tree_maximum(x.left));
		}
		node y=x.parent;
		while(y!=null && x==y.left){
			x=y;
			y=y.parent;
		}
		return y;
	}
	public void tree_insert(node z ){
		 
		node x=root;
		
		node y=null;
		while(x!=null){
			x.height++;
			y=x;
			if(x.key>z.key){
				x=x.left;
			}
			else{
				x=x.right;
			}
		}
		z.parent=y;
		if(y==null)root=z;
		else if(z.key<y.key)y.left=z;
		else y.right=z;
		z=z.parent;
		while(z!=null ){
			int l=0;
			int r=0;
			if(z.left!=null)l=z.left.height;
			if(z.right!=null)r=z.right.height;
			if(Math.abs(l-r)==2){
				balance(z);
				break;
			}
			z=z.parent;
		}
	}
	public void transplant(node u, node v){
		if(u.parent==null)root=v;
		else{
			
			if(u.parent.left==u)u.parent.left=v;
			else u.parent.right=v;
		}
		if(v!=null)v.parent=u.parent;
	}
	public void tree_delete(node x){
		if(x.left==null){
			transplant(x,x.right);
		}
		else if(x.right==null){
			transplant(x,x.left);
		}
		else{
			node y=tree_minimum(x.right);
			if(y!=x.right){
				transplant(y,y.right);
				y.right=x.right;
				y.right.parent=y;
			}
			transplant(x,y);
			y.left=x.left;
			y.left.parent=y;
		}
	}
	public void left_rotate(node x){
		node y=x.right;
		x.right=y.left;
		if(y.left!=null)y.left.parent=x;
		y.parent=x.parent;
		if(x.parent==null)root=y;
		else{
			if(x.parent.left==x)x.parent.left=y;
			else x.parent.right=y;
		}
		y.left=x;
		x.parent=y;
		int l=0;
		int r=0;
		if(x.left!=null)l=x.left.height;
		if(x.right!=null)r=x.right.height;
		x.height=Math.max(l,r);
		l=0;
		r=0;
		if(y.left!=null)l=y.left.height;
		if(y.right!=null)r=y.right.height;
		y.height=Math.max(l,r);
		y=y.parent;
		while(y!=null){
			l=0;
			r=0;
			if(y.left!=null)l=y.left.height;
			if(y.right!=null)r=y.right.height;
			y.height=Math.max(l,r);
			y=y.parent;
		}
	}
	public void right_rotate(node x){
		node y=x.left;
		x.left=y.right;
		if(y.right!=null)y.right.parent=x;
		y.parent=x.parent;
		if(x.parent==null)root=y;
		else{
			if(x.parent.left==x)x.parent.left=y;
			else x.parent.right=y;
		}
		y.right=x;
		x.parent=y;
		int l=0;
		int r=0;
		if(x.left!=null)l=x.left.height;
		if(x.right!=null)r=x.right.height;
		x.height=Math.max(l,r);
		l=0;
		r=0;
		if(y.left!=null)l=y.left.height;
		if(y.right!=null)r=y.right.height;
		y.height=Math.max(l,r);
		y=y.parent;
		while(y!=null){
			l=0;
			r=0;
			if(y.left!=null)l=y.left.height;
			if(y.right!=null)r=y.right.height;
			y.height=Math.max(l,r);
			y=y.parent;
		}
	}
	public void balance(node x){
		if(x.left.height>x.right.height){
			if(x.left.right!=null){
				if(x.left.left!=null){
					if(x.left.right.height>x.left.left.height)left_rotate(x.left);
				}
				else if(x.left.right.height==2)left_rotate(x.left);
			}
			
			right_rotate(x);
			
		}
		else{
				if(x.right.left!=null){
				if(x.right.right!=null){
					if(x.right.left.height>x.right.right.height)right_rotate(x.right);
				}
				else if(x.right.left.height==2)right_rotate(x.right);
			}
			
			left_rotate(x);
			
		}
	}
}
