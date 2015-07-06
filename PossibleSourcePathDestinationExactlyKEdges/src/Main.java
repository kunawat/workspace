import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int graph[][] = { {0, 1, 1, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
              };
		int n =4;// no. of vertices
		int k=2;
		int u=0;
		int v=3;
		int[][] ans = new int[k][n]; // ans[k-1][v] will contain ans
		for(int i=0;i<n;i++){
			ans[0][i]=graph[u][i];
		}
		for(int i=1;i<k;i++){
			for(int j=0;j<n;j++){
				if(ans[i-1][j]>0)
				for(int m=0;m<n;m++){
					ans[i][m]+= (ans[i-1][j])*graph[j][m];
				}
			}
		}
		System.out.println(ans[k-1][v]);
	}
}
