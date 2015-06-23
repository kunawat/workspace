import java.util.*;
public class Main {
	public static void main(String args[]){
		
		System.out.println(day(1,1,1995));
	}
	public static int day(int d, int m, int y){
		int[] t={0,3,2,5,0,3,5,1,4,6,2,4};
		return (y + y/4 -y/100 + y/400 +t[m-1]+d)%7;
	}
}
