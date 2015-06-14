import java.util.*;
public class Main {
	public static void main(String args[]){
		int[] A ={10, 18, 17, 15, 6, 2, 30};
		int n=A.length;
		int min1=Integer.MAX_VALUE;
		int min2=Integer.MAX_VALUE;
		int max2=Integer.MAX_VALUE;
		boolean c=false;
		for(int i=0;i<n;i++){
			if(A[i]>max2){
				System.out.println(min2+" "+max2+" "+A[i]);
				c=!c;
				break;
			}
			else if(A[i]>min2){
				max2=A[i];
			}
			else{
				if(A[i]>min1){
					min2=min1;
					max2=A[i];
					min1=Integer.MAX_VALUE;
				}
				else min1=A[i];
			}
		}
		if(!c)System.out.println(-1);
	}
}
