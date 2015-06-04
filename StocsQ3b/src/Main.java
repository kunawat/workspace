import java.util.Random;
public class Main {
	public static void main(String args[]){
		float n=0;
	
		for(int i=0;i<100;i++){
			Random rand = new Random();
			float u =rand.nextFloat();
			//System.out.println(u);
			n+= (1-u)/u;
		}
		float ans=n/100;
		System.out.println(ans);
	}
}