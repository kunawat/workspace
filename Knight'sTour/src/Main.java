import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int[][] a = new int[8][8];
		for(int i=0;i<8;i++){
			for(int j=0;j<8; j++){
				a[i][j]=-1;
			}
			
		}
		if(tour(a,0,0,0)){
			for(int i=0;i<8;i++){
				for(int j=0;j<8; j++){
					if(a[i][j]<10)
					System.out.print(a[i][j]+"   ");
					else System.out.print(a[i][j]+"  ");
				}
				System.out.println();
			}
		}
		else{
			System.out.println("Np Such Path");
		}
	   
	}
	public static boolean tour(int[][] a, int x, int y, int m){
		
		if(m==64){
			return true;
		}
		
		if(x<0 || x>=8 || y<0 || y>=8 || a[x][y]>=0)return false;
		
		else{
			a[x][y]=m;
			int xMove[] = {  2, 1, -1, -2, -2, -1,  1,  2 };
		    int yMove[] = {  1, 2,  2,  1, -1, -2, -2, -1 };
		    int i=0;
		    for(;i<8;i++){
		    	if(tour(a, x+xMove[i], y+yMove[i],m+1))break;
		    	
		    }
		    if(i==8){
		    	a[x][y]=-1;
		    	return false;
		    }
		    else return true;
		}
	}
}
