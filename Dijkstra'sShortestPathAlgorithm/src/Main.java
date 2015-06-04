import java.util.*;
public class Main {

	public static void main(String[] args) {
	
		Scanner s = new Scanner (System.in);
		int vertices = s.nextInt();
		int graph[][] = new int[vertices][vertices];
		int edges=s.nextInt();
		for(int i=0;i<edges;i++){
			int u =s.nextInt();
			int v = s.nextInt();
			int distance= s.nextInt();
			graph[u][v]=distance;
			graph[v][u]=distance;
		}
		dijkstra(graph,vertices);
	}
	public static void dijkstra(int[][] graph, int vertices){
		int[] distance = new int [vertices];
		boolean sptSet[] = new boolean[vertices];
		for(int i=0;i<vertices;i++){
			distance[i]=Integer.MAX_VALUE;
			sptSet[i]=false;
		}
		distance[0]=0;
		for(int i=0;i<vertices-1;i++){
			int u = minDistance(distance,sptSet);
			sptSet[u]=true;
			for(int j=0;j<vertices;j++){
				if(!sptSet[j] && graph[u][j]>0 && distance[u]!=Integer.MAX_VALUE && distance[u]+graph[u][j]<distance[j]){
					distance[j]=distance[u]+graph[u][j];
				}
			}
		}
		printSolution(distance);
	}
	public static int minDistance(int[] distance, boolean[] sptSet){
		int vertices=distance.length;
		int min= Integer.MAX_VALUE;
		int vertex=0;
		for(int i=0;i<vertices;i++){
			if(!sptSet[i] && min>distance[i]){
				min=distance[i];
				vertex=i;
			}
		}
		return vertex;
	}
	public static void printSolution(int[] distance){
		int vertices=distance.length;
		System.out.println("Vertex    DistanceFromSource");
		for(int i=0;i<vertices;i++){
			System.out.println(i+"          "+distance[i]);
		}
	}

}	