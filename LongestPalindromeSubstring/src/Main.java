import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		String q=s.next();
		char[] c = q.toCharArray();
		int n =c.length;
		int max=1;
		String x="";
		for(int i=0;i<n;i++){
			int l=1;
			while(i-l>=0 && i+l<n && c[i-l]==c[i+l])l++;
			int a=2*(l-1)+1;
			if(max<a){
				max=a;
				x=q.substring(i-l+1,a+i-l+1);
			}
			if(i>=1 && c[i]==c[i-1]){
				l=1;
				while(i-1-l>=0 && i+l<n && c[i-1-l]==c[i+l])l++;
				if(a<2*(l))a=2*l;
				
			}
			if(max<a){
				max=a;
				
				x=q.substring(i-l,a+i-l);
				
			}
		}
		System.out.println(max);
		System.out.println(x);
	}
}
