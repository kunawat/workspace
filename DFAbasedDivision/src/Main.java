import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		int k= s.nextInt();
		int[][] preprocess = new int[k][2];
		
		for(int state =0;state<k;state++){
			int trans0=state<<1;
			preprocess[state][0]= (trans0<k)?trans0:trans0-k;
			int trans1=(state<<1) + 1;
			preprocess[state][1]=(trans1<k)? trans1:trans1-k;
		}
		int remainder =isDiv(preprocess,0,n);
		if(remainder==0)System.out.println("divisible");
		else System.out.println("Reaminder = "+remainder);
	}
	
	public static int isDiv(int[][] p, int state, int num){
		if(num!=0){
			state=isDiv(p,state,num>>1);
			state=p[state][num&1];
		}
		return state;
	}
	
}
