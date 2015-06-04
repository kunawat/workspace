import java.util.*;
public class Main {
public static void main (String[] args){
	Scanner s = new Scanner(System.in);
	int t= s.nextInt();
	if(t<=10){
		int r=0;
		while (r<t){
		int m =s.nextInt();
		int n =s.nextInt();
		if (1 <= m && n/10000 <= 100000 && n-m<=100000){
			int i=m;
			while(i!= n+1){
				int j;
				int x = (int) Math.sqrt(i);
				for(j=2; j<=x ;j++){
					if(i%j == 0) break;
					
				}
			 if(j== x+1 && i!=x ) 
					System.out.println(i);
				i++;
			}
		}
		r++;
		System.out.println();
		}
	}
}
}



