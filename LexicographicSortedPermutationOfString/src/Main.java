import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		String a =s.next();
		
		int n =a.length();
		
		for(int i=n-1;i>=0;i--){
			int q=0;
			for(int j=i;j>=0;j--){
				
				if(a.charAt(j)<a.charAt(i)){
					q=1;
					if(i==n-1)
					if(j>0){
						char x=a.charAt(j);
						
						a=a.substring(0,j)+a.charAt(i)+a.substring(j,i);
						System.out.println(a);
						i++;
						break;
					}	
					else{
						char x=a.charAt(j);
						a=a.charAt(i)+a.substring(j,i-j);
						System.out.println(a);
						i++;
						break;
					}
					else
						if(j>0){
							char x=a.charAt(j);
							
							a=a.substring(0,j)+a.substring(i)+a.substring(j,i
									);
							System.out.println(a);
							i=n;
							break;
						}	
						else{
							char x=a.charAt(j);
							a=a.substring(i)+a.substring(j,i-j);
							System.out.println(a);
							i=n;
							break;
						}	
				}
			}
		
			//if(q==0 && i<n-1)i=n-1;
		}
	}
}
