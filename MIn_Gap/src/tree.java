import java.util.Stack;

		
public class tree {
	node root;
	node nil=new node(0,1);

	
	
	public void inorder_tree_walk(node x){
		if(x.left!=null){
			inorder_tree_walk(x.left);
	
		}
		if(x!=nil)System.out.println(x.key );
		if(x.right!=null){
			inorder_tree_walk(x.right);
		}
	}
	public void preorder_tree_walk(node x){
		if(x!=nil)System.out.println(x.key);
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
		while(x.left!=nil){
			x=x.left;
		}
		return x;
	}
	public node tree_maximum(node x){
		while(x.right!=nil){
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
		if(root==null)x=nil;
		node y=nil;
		
			while(x!=nil){
				y=x;
				if(x.key>z.key){
					if(x.min>z.key)x.min=z.key;
					x=x.left;
				}
				else{
					if(x.max<z.key)x.max=z.key;
					x=x.right;
				}
			}
		
		z.parent=y;
		if(y==nil){root=z;
		nil.min = Integer.MAX_VALUE;
		nil.min_gap = Integer.MAX_VALUE;
		nil.max=Integer.MIN_VALUE;
		}
		else if(z.key<y.key)y.left=z;
		else y.right=z;
		z.left=nil;
		z.right=nil;
		z.color=0;
		z.min=z.key;
		z.max=z.key;
		z.min_gap=Integer.MAX_VALUE;
		node x1=z;
		z=z.parent;
		while(z!=nil){
			
			z.min_gap=findMinGap(z);
			z=z.parent;
		}
		RB_insert_fixup(x1);
	}
	public node persistent_tree_insert(node z ){
		Stack<node> S =new Stack<node>();
		node root1=new node(0,1);
		S.push(root1);
		node x=root;
		copy(root1,x);

		node y=nil;
		node a=root1;
			while(x!=nil){
				y=a;
				if(x.key>z.key){
					x=x.left;
					if(x!=nil){
						node b = new node(0,1);
						S.push(b);
						copy(b,x);
						a.left=b;
						a=b;
					}
				}
				else{
					x=x.right;
					if(x!=nil){
						node b = new node(0,1);
						S.push(b);
						copy(b,x);
						a.right=b;
						a=b;
					}
				}
			}
		
		
		
		 if(z.key<y.key)y.left=z;
		else y.right=z;
		z.left=nil;
		z.right=nil;
		z.color=0;
		persistent_insert_fixup(S,z);
		return root1;
	}
	public void persistent_insert_fixup(Stack S, node z){
		node p=(node)S.pop();
		node gp= (node)S.pop();
		while(z!=root && p.color==0){
			
			if(gp.left==p){
				node y=gp.right;
				if(y.color==0){
					y.color=1;
					p.color=1;
					gp.color=0;
					z=gp;
					 p=(node)S.pop();
					 gp= (node)S.pop();
					
				}
				else{
					if(z==p.right){
						z=p;
						left_rotate(z);
					}
					p.color=1;
					gp.color=0;
					right_rotate(gp);
				}
			}
			else{
				node y=gp.left;
				if(y.color==0){
					y.color=1;
					p.color=1;
					gp.color=0;
					z=gp;
					 p=(node)S.pop();
					 gp= (node)S.pop();
				}
				else{
					if(z==p.left){
						z=p;
						right_rotate(z);
					}
					p.color=1;
					p.color=0;
					left_rotate(gp);
				}
			}
		}
		root.color=1;
	}
	public void copy(node x, node y){
		x.left=y.left;
		x.right=y.right;
		x.key=y.key;
		x.color=y.color;
		
	}
	public void RB_insert_fixup(node z){
		while(z!=root && z.parent.color==0){
			if(z.parent.parent.left==z.parent){
				node y=z.parent.parent.right;
				if(y.color==0){
					y.color=1;
					z.parent.color=1;
					z.parent.parent.color=0;
					z=z.parent.parent;
				}
				else{
					if(z==z.parent.right){
						z=z.parent;
						left_rotate(z);
					}
					z.parent.color=1;
					z.parent.parent.color=0;
					right_rotate(z.parent.parent);
				}
			}
			else{
				node y=z.parent.parent.left;
				if(y.color==0){
					y.color=1;
					z.parent.color=1;
					z.parent.parent.color=0;
					z=z.parent.parent;
				}
				else{
					if(z==z.parent.left){
						z=z.parent;
						right_rotate(z);
					}
					z.parent.color=1;
					z.parent.parent.color=0;
					left_rotate(z.parent.parent);
				}
			}
		}
		root.color=1;
	}
	public int findMinGap(node z){
		int p=z.left.min_gap;
		int q=z.right.min_gap;
		int r=Integer.MAX_VALUE;
		int s=Integer.MAX_VALUE;
		if(z.left!=nil)
			r=z.key-z.left.max;
		if(z.right!=nil) s=z.right.min-z.key;
		z.min_gap=Math.min(Math.min(p,r),Math.min(q,s));
		return z.min_gap;
	}
	public void transplant(node u, node v){
		if(u.parent==nil)root=v;
		else{
			
			if(u.parent.left==u)u.parent.left=v;
			else u.parent.right=v;
		}
		v.parent=u.parent;
	}
	public void tree_delete(node x){;
		node y=x;
		int y_original_color=y.color;
		node z;
		if(x.left==nil){
			z=x.right;
			transplant(x,x.right);
		}
		else if(x.right==nil){
			z=x.left;
			transplant(x,x.left);
		}
		else{
			 y=tree_minimum(x.right);
			 y_original_color=y.color;
			 z=y.right;
			if(y!=x.right){
				transplant(y,y.right);
				y.right=x.right;
				y.right.parent=y;
				node a =y.parent;
				while(a!=x){
					a.min_gap=findMinGap(a);
					a=a.parent;
				}
			}
			transplant(x,y);
			copy1(y,x);
			y.min_gap=findMinGap(y);
			y.left=x.left;
			y.left.parent=y;
			y.color=x.color;
			node a =y.parent;
			while(a!=nil){
				a.min_gap=findMinGap(a);
				a=a.parent;
			}
			if(y_original_color==1)RB_delete_fixup(z);
		}
	}
	public void RB_delete_fixup(node x){
		node w;
		while(x!=root && x.color==1){
			if(x==x.parent.left){
				w=x.parent.right;
				if(w.color==0){
					w.color=1;
					x.parent.color=0;
					left_rotate(x.parent);
					w=x.parent.right;
				}
				if(w.right.color==1 && w.left.color==1){
					w.color=0;
					x=x.parent;
				}
				else{
					if(w.right.color==1){
						w.left.color=1;
						w.color=0;
						right_rotate(w);
						w=x.parent.right;
					}
					w.color=x.parent.color;
					x.parent.color=1;
					w.right.color=1;
					left_rotate(x.parent);
					x=root;
				}
			}
			else{
				w=x.parent.left;
				if(w.color==0){
					w.color=1;
					x.parent.color=0;
					right_rotate(x.parent);
					w=x.parent.left;
				}
				if(w.right.color==1 && w.left.color==1){
					w.color=0;
					x=x.parent;
				}
				else{
					if(w.left.color==1){
						w.right.color=1;
						w.color=0;
						left_rotate(w);
						w=x.parent.left;
					}
					w.color=x.parent.color;
					x.parent.color=1;
					w.left.color=1;
					right_rotate(x.parent);
					x=root;
				}
			}
		}
		x.color=1;
	}
	public void left_rotate(node x){
		node y=x.right;
		x.right=y.left;
		if(y.left!=nil)y.left.parent=x;
		y.parent=x.parent;
		if(x.parent==nil)root=y;
		else{
			if(x.parent.left==x)x.parent.left=y;
			else x.parent.right=y;
		}
		y.left=x;
		x.parent=y;
		copy1(y,x);
		if(x.right!=nil)x.max=x.right.max;
		else x.max=x.key;
		
		x.min_gap=findMinGap(x);
		
	}
	public void copy1(node x, node y){
		x.min=y.min;
		x.max=y.max;
		x.min_gap=y.min_gap;
	}
	public void right_rotate(node x){
		node y=x.left;
		x.left=y.right;
		if(y.right!=nil)y.right.parent=x;
		y.parent=x.parent;
		if(x.parent==nil)root=y;
		else{
			if(x.parent.left==x)x.parent.left=y;
			else x.parent.right=y;
		}
		y.right=x;
		x.parent=y;
		copy1(y,x);
		if(x.left!=nil)x.min=x.left.min;
		else x.min=x.key;
	
		x.min_gap=findMinGap(x);
	}
}
