import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		String text=s.nextLine();
		String pat = s.nextLine();
		int m=pat.length();
		int[] lps = new int[m];
		computeLPS(lps,pat);
		int n =text.length();
		int j=0;
		int i=0;
		while(i<n){
			if(pat.charAt(j)==text.charAt(i)){
				i++;
				j++;
			}
			if(j==m){
				System.out.println("index: "+(i-m));
				j=lps[j-1];
			}
			else if(i<n && pat.charAt(j)!=text.charAt(i)){
					
				if(j>0)j=lps[j-1];
				else i++;	
				
			}
			
		}
	}
	public static void computeLPS(int[] lps, String pat){
		int m =lps.length;
		lps[0]=0;
		int i=1;
		int len=0;
		while(i<m){
			if(pat.charAt(i)==pat.charAt(len)){
				len++;
				lps[i]=len;
				i++;
			}
			else{
				if(len>0){
					len=lps[len-1];
				}
				else{
					lps[i]=0;
					i++;
				}
			}
		}
	}
}
