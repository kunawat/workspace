import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n =s.nextInt();
		int[] items = new int[n];
		int k =s.nextInt();
		int[] top= new int[k];
		int[] next = new int[n];
		for(int i=0;i<k;i++){
			top[i]=-1;
		}
		for(int i=0; i<n-1;i++){
			next[i]=i+1;
		}
		next[n-1]=-1;
		int[] free=new int[1];
		stack ks =new stack();
		 ks.push(items ,15, 2, top,next,free);
		    ks.push(items ,45, 2, top,next,free);
//		    System.out.println(ks.pop(items,2,top,next,free));
		    // Let us put some items in stack number 1
		    ks.push(items ,17, 1 , top,next,free);
		    ks.push(items ,49, 1, top,next,free);
		    ks.push(items ,39, 1 , top,next,free);
//		    System.out.println(ks.pop(items,1,top,next,free));
//		    System.out.println(ks.pop(items,2,top,next,free));
		    // Let us put some items in stack number 0
		    ks.push(items ,11, 0, top,next,free);
		    ks.push(items ,9, 0, top,next,free);
		    ks.push(items ,7, 0, top,next,free);
	    System.out.println(items[top[2]]);
		    System.out.println(ks.pop(items,1,top,next,free));
	    System.out.println(ks.pop(items,0,top,next,free));
	}
	public static class stack{
		
		public void push(int[] item,  int x, int k, int[] top, int[] next, int[] free){
			
			if(free[0]==-1){
				System.out.println("Overflow");
				return;
			}
			int i=free[0];
			free[0]=next[i];
			System.out.println(i+"  "+free[0]);
			next[i]=top[k];
			top[k]=i;
			item[i]=x;
		}
		
		public int pop(int[] item, int k, int[] top, int[] next, int[] free){
			if(top[k]==-1){
				System.out.println("Underflow");
				return Integer.MIN_VALUE;
			}
			int i=top[k];
			top[k]=next[i];
			next[i]=free[0];
			free[0]=i;
			return item[i];
		}
	}
}
