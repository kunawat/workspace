import java.util.*;
public class Mian {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int x =n;
		int y=1;
		while(x>y){
			x=(x+y)/2;
			
			y=n/x;
			
		}
		System.out.println(x);
	}
}
