import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner (System.in);
		int n = s.nextInt();
		long[] A = new long[n];
		for(int i=0;i<n;i++){
			A[i]=s.nextLong();
		}
		long[] B = new long[n];
		int min=0;
		int max=0;
		B[0]=max-min;
		long ans=B[0];
		for(int i=1;i<n;i++){
			if(A[i]>=A[max]){
			       
					max=i;
					if(min>0)
						ans=B[min-1]+A[max]-A[min];
					else{
						ans=A[max]-A[min];
					}
					B[i]=ans;
				    
					
			}
			else if(A[i]<=A[min]){
				min=i;
				if(max>0)ans=B[max-1]+A[max]-A[min];
				else ans=A[max]-A[min];
				B[i]=ans;
				
			}
			else{
			
					if(i>1 && B[i-2]+Math.abs(A[i-1]-A[i])>=ans){
						if(max==i-1){
							min=i;
							
						}
						else{
							max=i;
						}
						ans=B[i-2]+Math.abs(A[i-1]-A[i]);
						B[i]=ans;
						
					}
			
				else{
					max=i;
					min=i;
					B[i]=ans;
					
				}
			}
		}
		System.out.println(ans);
	}
}
