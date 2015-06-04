import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int t =s.nextInt();
		for(int i=1;i<=t;i++){
			int n =s.nextInt();
			String a = s.nextLine();
			int c=0;
			int ans=0;
			for(int j=1;j<=n+1;j++){
				if(c<j-1){
					ans=ans+j-1-c;
					c=c+j-1-c;
				}
				c=c+a.charAt(j)-48;
			}
			System.out.println("case #"+i+": "+ans);
		}
	}
}
