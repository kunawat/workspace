import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int t=1;
		int x =Integer.SIZE;
		System.out.println(x);
		for(int i=0; i<32;i++){
			n=n^t;
			t=t<<1;
		}
		System.out.println(n);
	}
}
