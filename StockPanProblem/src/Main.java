import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] price = new int[n];
		for(int i=0;i<n;i++){
			price[i]=s.nextInt();
		}
		Stack<Integer> st = new Stack<Integer>();
		for(int i=0;i<n;i++){
			while(!st.isEmpty() && price[st.peek()]<=price[i]){
				st.pop();
			}
			if(st.isEmpty()){
				System.out.println(i+1);
			}
			else{
				System.out.println(i-st.peek());
			}
			st.push(i);
		}
		
	}
	
}
