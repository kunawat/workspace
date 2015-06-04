import java.util.*;
public class Mian {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int t =s.nextInt();
		while(t>0){
			int n1 =s.nextInt();
			int n2= s.nextInt();
			int k =s.nextInt();
			int ans=1;
			int x =n1/k;
			if(x>0 && n1!=k){
			
				if(n1%k==0){
					x--;
					
					int a= (n1+1)%10000007;
					
					if(n2-x>0)
					ans=(((n2-x)*a)%10000007*ans)%10000007;
					x++;
					int q=k-1;
					a= (n1+1)%10000007;
					
					if(n2-x>0)
					ans=(ans+(((n2-x)*a)%10000007*q)%10000007)%10000007;
					else ans=(ans+q)%10000007;
						
					
					
				}
				
				else{
					
					ans=x+1;
					int a= (n1+1)%10000007;
					
					if(n2-x>0)
					ans=(((n2-x)*a)%10000007*ans)%10000007;
					
				}
				
				
			
			}
			else{
				ans =(n1+1)*n2;
			}
			
			
			System.out.println(ans);
			t--;
		}
	}
}
