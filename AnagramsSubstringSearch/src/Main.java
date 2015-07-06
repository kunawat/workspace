import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		String text=s.nextLine();
		String pat =s.nextLine();
		int n =text.length();
		int m=pat.length();
		int x=0;
		for(int i=0;i<m;i++){
			x=x^text.charAt(i);
			x=x^pat.charAt(i);
		}
		if(x==0){
			System.out.println("index: "+0);
		}
		for(int i=m;i<n;i++){
			x=x^text.charAt(i);
			x=x^text.charAt(i-m);
			if(x==0){
				System.out.println("index: "+(i-m+1));
			}
		}
		
	}
}
