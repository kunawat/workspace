import java.util.*;

public class Main {
	public static void main(String args[]){
		Scanner s= new Scanner(System.in);
		int v=s.nextInt(); // no. of vertices
		int n = s.nextInt(); //no.of edges
		int[][] A = new int[n][3];
		for(int i=0;i<n;i++){
			A[i][0]=s.nextInt();
			A[i][1]=s.nextInt();
			A[i][2]=s.nextInt();
		}
		Arrays.sort(A, new Comparator<int[]>(){
			public int compare(int[] a, int[]b){
				return Integer.compare(a[2],b[2]);
			}
		});
		int[] parent= new int[v];
		for(int i=0;i<v;i++){
			parent[i]=i;
		}
		int[] rank= new int[v];
		int[][] mst = new int[v-1][2];
		int j=0;
		for(int i=0;i<n && j<v-1;i++){
			int x = find(A[i][0],parent);
			int y= find(A[i][1],parent);
			if(x!=y){
				mst[j][0]=x;
				mst[j++][1]=y;
				union(x,y,rank,parent);
			}
		}
		for(int i=0;i<v-1;i++){
			System.out.println(mst[i][0]+" "+mst[i][1]);
		}
	}
	public static int find(int x, int[] parent){
		if(parent[x]!=x){
			parent[x]=find(parent[x],parent);
		}
		return parent[x];
	}
	public static void union(int x,int y, int[]rank, int parent[]){
		int xp =find(x,parent);
		int yp =find(y,parent);
		if(rank[xp]<rank[yp]){
			parent[xp]=yp;
		}
		else if(rank[yp]<rank[xp]){
			parent[yp]=xp;
		}
		else{
			parent[xp]=yp;
			rank[yp]++;
		}
	}
	
}
