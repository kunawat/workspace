import java.util.*;
public class Main{
	public static void main(String[] args) throws Exception {
		try{
			Scanner s =new Scanner(System.in);
			int n = s.nextInt();
			int m = s.nextInt();
			int q = s.nextInt();
			s.nextLine();
			int A[][]= new int[n][m];
			int[] H = new int[n];
			list[] l = new list[n];
			for(int i=0;i<n;i++){
				l[i]=new list();
				String[] t=s.nextLine().split(" ");
				int count=0;
				int max=0;
				for(int j=0;j<m;j++){
					
					A[i][j]=Integer.parseInt(t[j]);
					if(A[i][j]==0){
						
						l[i].insert(j);
						
						if(max<count)max=count;
					}
					else{
						count++;
					}
				}
				H[i]=max;
			}
			func f = new func();
			f.build(H);
			
			for(int i=0;i<q;i++){
				
				int a =s.nextInt()-1;
				int b = s.nextInt()-1;
				if(A[a][b]==1){
					A[a][b]=0;
					
					l[a].insert(b);
					
				}
				else{
					A[a][b]=1;
					
					node q1 =l[a].search(b);
					
					
					l[a].delete(q1);
					
					
				}
				int max=0;
				if(l[a].head==null)max=m;
				else max=l[a].max(m);
				f.change(H, a, max);
				System.out.println(f.max(H));
			}
			
		}
		catch(Exception e){}
		
	}

public static class func {
	public static int heap_size=0;
	public int parent(int i){
		return (i-1)/2;
	}
	
	public int right(int i){
		return (2*i)+2;
	}
	
	public int left(int i){
		return (i*2)+1;
	}
	public void exchange(int A[],int a, int b){
		int t=A[a];
		A[a]=A[b];
		A[b]=t;
	}
	
	public void heapify(int A[],int  i){
		int l = left(i);
		int r = right(i);
		int largest=i;
		if(l<=heap_size-1){
			if(A[l]>A[i])largest=l;
		}
		if(r<=heap_size-1){
			if(A[r]>A[largest])largest=r;
		}

		if(largest != i){
			exchange(A,largest,i);
	
			heapify(A,largest);
		}
	}
	public void build(int A[]){
		heap_size=A.length;
		for(int i=parent(A.length-1); i>=0;i--){
			heapify(A,i);
		}
	}
	
	public int max(int A[]){
		return A[0];
	}
	
	public void change(int A[],int i,int key){
		if(key<A[i]){
			A[i]=key;
			heapify(A,i);
			return;
		}
		A[i]=key;
		while(i>0){
			int p =parent(i);
			if(A[i]>A[p]){
				exchange(A,i,p);
				i=p;
			}
			else break;
		}
	}
	
}

	public static class node {
		node next=null;
		int key;
		node prev=null;
		public node(int key) {
			super();
			this.key = key;
		}
		
	}

	public static class list {
		node head=null;
		public int max(int a){
			
			node n=head;
			int max=head.key;
			while(n.next!=null){
				int x=n.next.key-n.key-1;
				if(x>max)max=x;
			}
			if(a-n.key-1>max)max=a-n.key-1;
			return max;
		}
		public node search(int x){
			node n=head;
			while(n!=null && n.key!=x){
				n= n.next;
			}
			return n;
		}
		public void insert(int x){
			
			if(head==null){
				
				head =new node(x);
				//System.out.println(head.key);
			}
			else{
				
				node n = new node(x);
				if(head.key>n.key){
					n.next=head;
					head=n;
					return;
				}
				node a =head;
				while(a.next!=null){
					if(a.key<=n.key && n.key<=a.next.key){
						node temp=a.next;
						a.next=n;
						n.next=temp;
						return;
					}
					a=a.next;
				}
				a.next=n;
				//System.out.println(head.key);
			}
		}
		
		public void delete (node x){
			if(x.prev!=null)
				x.prev.next=x.next;
			else{
				head=x.next;
			}
			if(x.next!=null)x.next.prev=x.prev;
		}
		
	}
	
	
} 