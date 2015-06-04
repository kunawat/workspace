import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		String x =s.next();
		int k=x.length();
		stack sk = new stack();
		int[] ch = new int[k];
		
		for(int i=0;i<k;i++){
		
			if(isOperand(x.charAt(i))){
				sk.push(ch,x.charAt(i)-48);
			}
			else{
				int q =sk.pop(ch);
				int w = sk.pop(ch);
				if(x.charAt(i)=='+'){
					sk.push(ch, q+w);
				}
				else if(x.charAt(i)=='-'){
					sk.push(ch,w-q);
				}
				else if(x.charAt(i)=='*'){
					sk.push(ch, w*q);
				}
				else if(x.charAt(i)=='/'){
					sk.push(ch,w/q);
				}
				else if(x.charAt(i)=='^'){
					sk.push(ch, (int)Math.pow(w,q));
				}
			}
		}
		System.out.println(sk.pop(ch));
	}
	public static boolean isOperand(char c){
		if((c>='1' && c<='9'))return true;
		return false;
	}
	public static class stack{
		int top=-1;
		public void push(int[] A, int c){
			if(top<A.length-1){
				A[++top]=c;
			}
		}
		public int pop(int[] A){
			if(top>=0){
				return A[top--];
			}
			System.out.println("underflow");
			return 0;
		}
		public int peek(int[] A){
			if(top>=0)return A[top];
		
		System.out.println("underflow");
		return 0;
		}
	}
}
