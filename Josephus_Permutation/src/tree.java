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
			x.size++;
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
				node z=y.parent;
				while(z!=x){
					z.size--;
					z=z.parent;
				}
			}
			transplant(x,y);
			y.size=x.size-1;
			y.left=x.left;
			y.left.parent=y;
		}
		node y=x.parent;
		while(y!=null){
			y.size--;
			y=y.parent;
		}
	}
	public node select(node x, int i){
		int r=1;
		if(x.left!=null)r=x.left.size+1;
		if(r==i)return x;
		else{
			if(r>i){
				return select(x.left,i);
			}
			else return select(x.right,i-r);
		}
	}
	public int rank(node x){
		int r=0;
		if(x.left!=null)r=x.left.size+1;
		node y=x;
		while(y!=root){
			if(y==y.parent.right){
				int s=0;
				if(y.parent.left!=null)s=y.parent.left.size+1;
				r=r+s+1;
				y=y.parent;
			}
		}
		return r;
	}
	public void permute(int n, int m){
		int j=1;
		for(int k=n;k>=1;k--){
			j=(j+m-2)%k+1;
			node x=select(root,j);
			System.out.println(x.key);
			tree_delete(tree_search(x.key));
		}
	}
}
