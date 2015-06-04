import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n =s.nextInt();
		char[][] A = new char[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				A[i][j]=s.next().charAt(0);
			}
		}
		int ans =0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(A[i][j]=='O'){
					A[i][j]='T';
					node S= new node(i,j);
					ArrayList<node> Q= new ArrayList<node>();
					Q.add(S);
					ans++;
					while(!Q.isEmpty()){
						node u =Q.remove(0);
						int x=u.x;
						int y=u.y;
						if(x>0){
							if(A[x-1][y]=='O'){
								A[x-1][y]='T';
								node v = new node(x-1,y);
								Q.add(v);
							}
						}
						if(x<n-1){
							if(A[x+1][y]=='O'){
								A[x+1][y]='T';
								node v = new node(x+1,y);
								Q.add(v);
							}
						}
						if(y>0){
							if(A[x][y-1]=='O'){
								A[x][y-1]='T';
								node v = new node(x,y-1);
								Q.add(v);
							}
						}
						if(y<n-1){
							if(A[x][y+1]=='O'){
								A[x][y+1]='T';
								node v = new node(x,y+1);
								Q.add(v);
							}
						}
						A[x][y]='X';
					}
				}
			}
		}
		System.out.println(ans);
	}
	public static class node{
		int x;
		int y;
		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
