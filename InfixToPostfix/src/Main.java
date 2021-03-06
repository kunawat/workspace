import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		String a =s.next();
		int n=a.length();
		char[] x= new char[n];
		char[] A= new char[n];
		int k=-1;
		stack st = new stack();
		for(int i=0;i<n;i++){
			char c =a.charAt(i);
			if(isOperand(c)){
				x[++k]=c;
			}
			else if(c=='('){
				st.push(A, c);
			}
			else if(c==')'){
				
				while(st.peek(A)!='('){
					x[++k]=st.pop(A);
				}
				st.pop(A);
			}
			else{
				while(st.top>=0 && prc(c)<=prc(st.peek(A))){
					x[++k]=st.pop(A);
				}
				st.push(A, c);
			}
		}
		while(st.top>=0){
			x[++k]=st.pop(A);
		}
		
		System.out.println(x);
		
	}
	public static int prc(char c){
		switch(c){
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return 0;
		}
	}
	public static boolean isOperand(char c){
		if((c>='a' && c<='z') || (c>='A' && c<+'Z'))return true;
		return false;
	}
	public static class stack{
		int top=-1;
		public void push(char[] A, char c){
			if(top<A.length-1){
				A[++top]=c;
			}
		}
		public char pop(char[] A){
			if(top>=0){
				return A[top--];
			}
			System.out.println("underflow");
			return '0';
		}
		public char peek(char[] A){
			if(top>=0)return A[top];
		
		System.out.println("underflow");
		return '0';
		}
	}
}
