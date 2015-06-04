import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner s= new Scanner(System.in);
		int n=s.nextInt();
		int price[]= new int[n+1];
		price[0]=0;
		int i=1;
		while(i<n+1){
			price[i++]=s.nextInt();
		}
		Print_Cut_Rod_Solution(price,n);
	}
	public static int[] Bottom_Up_Cut_Rod(int[] p,int n){
		int[] r= new int[n+1];
		int[] s=new int[n+1];
		r[0]=0;
		for(int j=1;j<n+1;j++){
			int q=Integer.MIN_VALUE;
			for(int i=1;i<=j;i++){
				if(q<p[i]+r[j-i]){
					q=p[i]+r[j-i];
					s[j]=i;
				}
			}
			r[j]=q;
		}
		System.out.println(r[n]);
		return s;
	}
	public static void Print_Cut_Rod_Solution(int[] p, int n){
		int[] s =new int[n+1];
		s=Bottom_Up_Cut_Rod(p,n);
		while(n>0){
			System.out.print(s[n]+" ");
			n=n-s[n];
		}
	}
}
