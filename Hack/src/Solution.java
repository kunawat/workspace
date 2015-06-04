import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long ans=1;
        if (n>1){
        	ans=0;
        	int prev=s.nextInt();
        	int x=s.nextInt();
        	int i=2;
        	long prev_count=0;
        	if(x==prev)ans++;
        	while(i<n && prev==x){
        		prev=x;
        		x=s.nextInt();
        		i++;
        		ans++;
        		
        	}
        	if(i==n && prev==x){
        		ans++;
        		
        	}
        	if(x!=prev && ans>1)ans--;
        	int inc=1;
        	if(x<prev){
        		inc=0;
        	
        	}
        	long count=2;
        	if(i!=n)
        	prev=x;
        	
        	while(i<n){
        		x=s.nextInt();
        		i++;
        		if((x>prev && inc==1) || (x<prev && inc==0)){
        			count++;
        			
        			if(i!=n){
        				prev=x;
        			}
        		}
        		else if(x==prev){
        			if(count>prev_count){
                		ans=ans-prev_count+func(count);
                		//System.out.println(ans);
                	}
                	else ans=ans+func(count-1);
        			prev_count=0;
        			while(i<n && prev==x){
        				xprev=x;
                		x=s.nextInt();
                		i++;
                		ans++;	
                		
                	}
        			
        			if(i==n && prev==x){
        				ans++;
        			}
        			if(x!=prev && ans>1)ans--;
        			inc=1;
                	if(x<prev)inc=0;
                	count=2;
                	if(i!=n){
        				prev=x;
        			}
        		}
        		else{
        			if(count>prev_count){
                		ans=ans-prev_count+func(count);
                		prev_count=count;
                	}
                	else{
                		ans=ans+func(count-1);
                		prev_count=count-1;
                	}
        			inc=Math.abs(1-inc);
        			count=2;
        			if(i!=n){
        				prev=x;
        			}
        			//System.out.println(ans +"  "+ i);
        		}
        	}
        	if(x!=prev){
	        	if(count>prev_count){
	        		ans=ans-prev_count+func(count);
	        		
	        	}
	        	else ans=ans+func(count-1);
	        	
        	}
        } 
        
       System.out.println(ans);
    }
    public static long func(long x){
        
        if(x%2==0) x=(x/2)*(x+1);
        else x=((x+1)/2)*x;
        return x;
    }
}