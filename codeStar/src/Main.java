import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String args[]){
	
		Scanner s = new Scanner(System.in);
		String x =s.next();
		BigInteger n = new BigInteger(x);
		BigInteger m = new BigInteger(s.next());
		BigInteger MOD = new BigInteger("1000000007");
		int k=s.nextInt();
		BigInteger result = BigInteger.ZERO;
		result = m.modPow(n,MOD);
		String a;
		for(int i=0;i<k;i++){
			a=s.next();
			BigInteger c = new BigInteger("1");
			if(!a.equals("0")){
				c = new BigInteger(a);
				c=c.subtract(new BigInteger("1"));
				
				c = m.modPow(c,MOD);
				
			}
			s.nextInt();
			
			a=s.next();
			s.nextInt();
			BigInteger q= n.add(new BigInteger("1"));
			BigInteger d = new BigInteger(a);
			
			if(!q.equals(d)){
				
				d=n.subtract(d);
				d = m.modPow(d,MOD);
				
			}
			else{
				d = new BigInteger("1");
			}
			
			c=c.multiply(d);
			c=c.mod(MOD);
			
			result=result.add(c);
			result=result.mod(MOD);
		}
		System.out.println(result);
	
	}
	
}  