package stocsQ5a;
import java.util.*;

public class Main {
	public static void main(String args[]){
		float n=0;
		
		for(int i=0;i<100;i++){
			float time=0;
			int count=0;
			for(;time<300;time=time+getPoissonRandom(3)){
				Random rand = new Random();
			    float x = rand.nextFloat();
			    if(x<=0.3)
			    count++;
			    
			}
			if(count>=150 && count<=400)n++;
		}
		float ans=n/100;
		System.out.println(ans);
	}
	private static float getPoissonRandom(double mean) {
		Random rand = new Random();
		float x= (float) (-Math.log(1.0 - rand.nextFloat()) / mean);
		//System.out.println(x);
		return x;
	}
}
