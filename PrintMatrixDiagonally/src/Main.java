import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		 int M[][] = {{1, 2, 3, 4},
                 {5, 6, 7, 8},
                 {9, 10, 11, 12},
                 {13, 14, 15, 16},
                 {17, 18, 19, 20},
                };
		 int c=4;
		 int r=5;
		 for(int i=0;i<r;i++){
			 for(int j=0;j<=i && j<c;j++){
				 System.out.print(M[i-j][j]+" ");
			 }
			 System.out.println();
		 }
		 for(int i=1; i<c;i++){
			 for(int j=i;j<c;j++){
				 System.out.print(M[r-1-j+i][j]+" ");
			 }
			 System.out.println();
		 }
	}
}
