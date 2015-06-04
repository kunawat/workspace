import java.util.*;


public class Main {
	public static void main(String[] args){
		  
			
		Scanner s =new Scanner (System.in);
		int n= s.nextInt();
		activity[] A = new activity[n];
		for(int i=0;i<n;i++){
			A[i]=new activity();
			A[i].start=s.nextInt();
			A[i].finish=s.nextInt();
		}
		Arrays.sort(A,activity.byfinish);
		int c=1;
		int k=0;
		for(int i=1;i<n;i++){//save the values of i for getting which activities selected
			if(A[i].start>=A[k].finish){
				c++;
				k=i;
				
			}
		}
		System.out.println(c);
	}
	

	
}
