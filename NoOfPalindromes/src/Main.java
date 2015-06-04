import java.util.*;

public class Main {

	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String str = s.next();
		Map<String,Integer> m = new HashMap<String,Integer>();
		int ans=0;
		//System.out.println(str.substring(1,6));
		
		for(int i=0;i<str.length();i++){
			if(!m.containsKey(Character.toString(str.charAt(i)))){
				ans++;
				m.put(Character.toString(str.charAt(i)), 1);
				System.out.println(Character.toString(str.charAt(i)));
			}
			int b=i-1;
			int e =i;
			while(b>=0  && e<str.length()){
				if( str.charAt(b)==str.charAt(e) ){
					if(!m.containsKey(str.substring(b,e+1))){
						ans++;
						m.put(str.substring(b,e+1), 1);
						System.out.println(str.substring(b,e+1));
					}
					b--;
					e++;
				}
				else break;
			}
			
			for(int j=0;j<i && 2*i-j<str.length();j++){
				if(str.charAt(j)==str.charAt(2*i-j)){
					if(!m.containsKey(str.substring(j,2*i-j+1)) ){
						ans++;
						m.put((str.substring(j,2*i-2*j+1)), 1);
						System.out.println(str.substring(j,2*i-j+1));
					}
				}
			}
			
		}
		System.out.println(ans);
	}
}
