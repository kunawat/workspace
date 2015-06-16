import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		node[] a = new node[n];
		for(int i=0;i<n;i++){
			a[i]= new node(s.next().charAt(0), s.nextInt());
		}
		heap h = new heap();
		h.build(a);
		heap.size=a.length;
		while(heap.size!=1){
			node x =h.extrMin(a);
			node y =h.extrMin(a);
			node top=new node('$',x.freq+y.freq);
			top.left=x;
			top.right=y;
			h.insert(a, top);
			
		}
		int[] ans = new int[2*n-1];
		print(a[0],ans,0);
		
	}
	public static void print(node a, int[] ans, int top){
		if(a.left!=null){
			ans[top]=0;
			print(a.left,ans,top+1);
		}
		if(a.right!=null){
			ans[top]=1;
			print(a.right,ans,top+1);
		}
		if(a.left==null && a.right==null){
			System.out.println(a.c+ " :");
			printArr(ans,top);
			System.out.println();
		}
	}
	public static void printArr(int[] ans, int top){
		
		for(int i=0;i<top;i++){
			System.out.print(ans[i]);
		}
	}
	public static class node{
		char c;
		int freq;
		node left=null;
		node right=null;
		public node(char c, int freq) {
			super();
			this.c = c;
			this.freq = freq;
		}
	}
	public static class heap{
		static int size=-1;
		public void heapify(node[] a, int idx){
			int left=2*idx+1;
			int right=2*idx+2;
			int smallest=idx;
			
			if(left<size && a[idx].freq>a[left].freq){
				smallest=left;
			}
			if(right<size && a[right].freq<a[smallest].freq){
				smallest=right;
			}
			if(smallest!=idx){
				node temp=a[idx];
				a[idx]=a[smallest];
				a[smallest]=temp;
			}
		}
		public void build(node[] a){
			int n=a.length-1;
			for(int i=(n-1)/2;i>=0;i--){
				heapify(a,i);
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
	}
}
