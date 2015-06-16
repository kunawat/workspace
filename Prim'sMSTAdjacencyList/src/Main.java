
//errors- not perfect problems in decrease key
import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		LinkedList<AdjNode>[] adj = new LinkedList[v];
		int n = s.nextInt();
		for(int i=0;i<n;i++){
			int src=s.nextInt();
			int des=s.nextInt();
			int w=s.nextInt();
			AdjNode temp= new AdjNode(des,w);
			if(adj[src]==null)adj[src]= new LinkedList();
			if(adj[des]==null)adj[des]=new LinkedList();
			adj[src].add(temp);
			temp=new AdjNode(src,w);
			adj[des].add(temp);
		}
		node[] ver = new node[v];
		for(int i=1;i<v;i++){
			ver[i]= new node(i,Integer.MAX_VALUE);
		}
		ver[0]=new node(0,0);
		
		heap.size=v;
		heap h = new heap();
		int[] parent= new int[v];
		boolean[] isMst= new boolean[v]; 
		
		parent[0]=-1;
		int[] key = new int[v];
		for(int i=0;i<v; i++)key[i]=Integer.MAX_VALUE;
		for(int i=0;i<v;i++){
			node x= h.extrMin(ver);
			int id=x.ver;
			isMst[id]=true;
			System.out.println(id);
			if(adj[id]!=null)	
			for(ListIterator<AdjNode> iter=adj[id].listIterator(); iter.hasNext();){
				AdjNode uv = iter.next();
				
				int a=uv.des;
				
				if(isMst[a]==false && key[a]>uv.weight){
					key[a]=uv.weight;
					parent[a]=id;
					System.out.println(a+" "+uv.weight);
					h.decreaseKey(ver, a, key[a]);
					System.out.println(ver[0].key);
				}
			}
		}
		for(int i=1;i<v;i++){
			System.out.println(parent[i]+" "+i+ " "+ key[i]);
		}
		int sum=0;
		
	}
	public static class AdjNode{
		int des;
		int weight;
		public AdjNode(int des, int weight){
			this.des=des;
			this.weight=weight;
		}
	}
	public static class node{
		int ver;
		int key;
		
		public node(int v, int k) {
			super();
			this.ver = v;
			this.key = k;
		}
	}
	public static class heap{
		static int size=-1;
		public void heapify(node[] a, int idx){
			int left=2*idx+1;
			int right=2*idx+2;
			int smallest=idx;
			
			if(left<size && a[idx].key>a[left].key){
				smallest=left;
			}
			if(right<size && a[right].key<a[smallest].key){
				smallest=right;
			}
			if(smallest!=idx){
				node temp=a[idx];
				a[idx]=a[smallest];
				a[smallest]=temp;
			}
		}
		
		public node extrMin(node a[]){
			node temp=a[0];
			a[0]=a[--size];
			heapify(a,0);
			return temp;
		}
		public void insert(node a[], node x){
			a[size++]=x;
			heapify(a,(size-2)/2);
		}
		public void decreaseKey(node[] a, int v, int k){
			a[v].key=k;
			int p =(v-1)/2;
			while(v!=0 && a[p].key>k){
				node tem=a[p];
				a[p]=a[v];
				a[v]=tem;
				v=p;
				p=(v-1)/2;
			}
		}
	}
}
