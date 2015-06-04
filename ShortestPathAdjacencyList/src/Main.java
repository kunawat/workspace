import java.util.*;
public class Main {

	public static void main(String[] args) {
	
		Scanner s = new Scanner (System.in);
		int vertices = s.nextInt();
		List<node>[] adjList = new LinkedList[vertices];
		int edges=s.nextInt();
		for(int i=0;i<edges;i++){
			int u =s.nextInt();
			int v = s.nextInt();
			int distance= s.nextInt();
			node n = new node(v,distance);
			adjList[u].add(n);
			adjList[v].add(new node(u,distance));
		}
		vertex[] v = new vertex[vertices];
		Map<Integer,vertex> map= new HashMap<Integer,vertex>();
		for(int i=1;i<vertices;i++){
			vertex ver = new vertex(i,Integer.MAX_VALUE);
			v[i]=ver;
			map.put(i,ver);
		}
		vertex ver= new vertex(0,0);
		map.put(0, ver);
		func heap = new func();
		heap.build(v);
		
		
	}

	public static class node{
		int index;
		int distance;
		public node(int index, int distance) {
			super();
			this.index = index;
			this.distance = distance;
		}
	}
	public static class vertex{
		int index;
		int distance;
		public vertex(int index, int distance) {
			super();
			this.index = index;
			this.distance = distance;
		}
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
		public void exchange(vertex A[],int a,int b){
			vertex t=A[a];
			A[a]=A[b];
			A[b]=t;
		}
		
		public void heapify(vertex[] v,int  i){
			int l = left(i);
			int r = right(i);
			int smallest=i;
			if(l<=heap_size-1){
				if(v[l].distance<v[i].distance)smallest=l;
			}
			if(r<=heap_size-1){
				if(v[r].distance<v[smallest].distance)smallest=r;
			}

			if(smallest != i){
				exchange(v,smallest,i);
		
				heapify(v,smallest);
			}
		}
		public void build(vertex[] v){
			heap_size=v.length;
			for(int i=parent(v.length-1); i>=0;i--){
				heapify(v,i);
			}
		}
	
	
		public void delete(vertex[] A,int i){
			A[i]=A[heap_size-1];
			heap_size=heap_size-1;
			heapify(A,i);
		}
	}

}	