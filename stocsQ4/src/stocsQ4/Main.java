package stocsQ4;
import java.util.*;
public class Main {
	public static void main(String args[]){
		int n=0;
	
		for(int i=0;i<1000;i++){
			int c=1;
			int[] a = new int[13];
			int count=0;
			while(c==1){
				Random rand = new Random();
	
			    // nextInt is normally exclusive of the top value,
			    // so add 1 to make it inclusive
			    int x = rand.nextInt(6) +1;
			   
			   
			    int y = rand.nextInt(6) + 1;
			    //System.out.println(x+y);
			    a[x+y]=1;
			    c=0;
			    count++;
			    for(int j=2;j<13;j++){
			    	if(a[j]==0){
			    		c=1;
			    		break;
			    	}
			    }
			    
			}
			n=n+count;
		}
		float ans=n/1000;
		System.out.println(ans);
	}
}
