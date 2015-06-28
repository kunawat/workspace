import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int r=4;
		int n =2*r+1;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int x=r-i;
				int y=r-j;
				if(x*x+y*y<=r*r+1){
					System.out.print(".");
				}
				else System.out.print(" ");
			}
			System.out.println();
		}
	}
}
