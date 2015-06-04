import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n= s.nextInt();
		int A[] = new int[n];
		for(int i=0;i<n;i++){
			A[i]=s.nextInt();
		}
		int[] t = new int[2*n-1];
		constructTree(A,0,n-1,t,0);
		System.out.println(t[0]);
		System.out.println(getSum(t,0,n-1,1,2,0));
		
		//update i- index v- new value
		int i =s.nextInt();
		int value=s.nextInt();
		int diff =value-A[i];
		A[i]=value;
		update(t,0,n-1,i,diff,0);
		System.out.println(t[0]);
		System.out.println(getSum(t,0,n-1,1,2,0));
	}
	public static int getMid(int s, int e){
		return (s+(e-s)/2);
	}
	public static int constructTree(int[] A, int ss, int se, int[] t, int index){
		if(ss==se){
			t[index]=A[ss];
			return t[index];
		}
		else{
			int mid =getMid(ss,se);
			t[index]=constructTree(A,ss,mid,t,2*index+1)+ constructTree(A,mid+1,se,t,2*index+2);
			return t[index];
		}
	}
	public static int getSum(int t[], int ss, int se, int qs, int qe,int index){
		if(qs<=ss && qe>=se){
			return t[index];
		}
		if(qs>se || qe<ss){
			return 0;
		}
		else{
			int mid=getMid(ss,se);
			return getSum(t,ss,mid,qs,qe,2*index+1)+getSum(t,mid+1,se,qs,qe,2*index+2);
		}
	}
	public static void update(int t[], int ss, int se,int i, int diff, int index){
		if(i<ss || i>se)return;
		t[index]= t[index]+diff;
		if(ss!=se){
			int mid=getMid(ss,se);
			update(t,ss, mid,i, diff, 2*index+1);
			update(t, mid+1, se,i, diff, 2*index+2);
		}
	}
}
