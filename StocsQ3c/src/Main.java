import java.util.Random;
public class Main {
	public static void main(String args[]){
		float n=0;
	
		for(int i=0;i<10000;i++){
			Random rand = new Random();
			float x =rand.nextFloat();
			float y =rand.nextFloat();
			n+= Math.pow(2.71828, Math.pow(x+y,2));
		}
		float ans=n/10000;
		System.out.println(ans);
	}
}