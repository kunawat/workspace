import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		String text =s.nextLine();
		String pat = s.nextLine();
		int n=text.length();
		int  m= pat.length();
		int[][] t = new int[m+1][26];
		computeTab(t,pat);
		int state=0;
		for(int i=0;i<n;i++){
			state=t[state][text.charAt(i)-'A'];
			if(state==m){
				System.out.println("index: "+(i-m+1));
			}
		}
	}
	public static void computeTab(int[][] t, String pat){
		int lps=0;
		int m =pat.length();
		t[0][pat.charAt(0)-'A']=1;
		for(int i=1;i<=m;i++){
			for(int j=0;j<26;j++){
				t[i][j]=t[lps][j];
			}
			if(i<m){
			t[i][pat.charAt(i)-'A']=i+1;
			lps=t[lps][pat.charAt(i-1)-'A'];
			}
		}
	}
}
