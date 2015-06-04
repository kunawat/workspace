import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n= s.nextInt();
		long ans=1;
	
		for(long i=0;i<n*n;i++){
				long x = s.nextInt();
				ans=(ans*(x%1000000007))%1000000007;
		}
		long M=s.nextInt();
		ans=pow(ans,M)%1000000007;
			System.out.println(ans);
	}
	 static long pow(long x, long M){
		 if(M==1)return(x%1000000007);
		 else if(M==2)return((x*x)%1000000007);
		 else{
			 if(M%2==0){
				 return (pow((pow(x,M/2)%1000000007),2))%1000000007;
			 }
			 else{
				 return ((pow((pow(x,M/2)%1000000007),2)%1000000007)*x)%1000000007;
			 }
		 }
	 }
}
