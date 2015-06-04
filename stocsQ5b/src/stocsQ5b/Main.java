package stocsQ5b;
import java.util.*;

public class Main {
	public static void main(String args[]){
	float n=0;
		
		for(int i=0;i<100;i++){
			float time=0;
			float lastTime=0;
			float req=0;
			float count=0;
			for(;time<500;time=time+getPoissonRandom(3)){
				req++;
				Random rand = new Random();
			    float x = rand.nextFloat();
			    if(x>0.3){
			    	float diff = time-lastTime;
			    	lastTime=time;
			    	if(diff>=0.3 && diff<=0.5)
			    count++;
			    }
			}
			//System.out.println(count);
			n+= count/req;
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
