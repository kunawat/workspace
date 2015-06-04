import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner s =new Scanner(System.in);
		int t = s.nextInt();
		while(t>0){
			String l = s.nextLine();
			ArrayList<Character> a=new ArrayList<Character>(); 
			ArrayList<Character> b=new ArrayList<Character>(); 
			for(int i=0;i<l.length();i=i+2){
				a.add(l.charAt(i));
			}
			int c=0;
			if(a.get(0)!='{' && a.get(a.size()-1)!='}'){
				
				System.out.println("Compilation Errors");
				c=1;
			}
			
			else if(!a.isEmpty() && a.get(0)=='<'){
				a.remove(0);
				a.remove(a.size()-1);
					int i=0;
					while(i<=a.size()-1 && a.get(i)!='>'){
						if(a.get(i)=='(' || a.get(i)==')' || a.get(i)=='<'){
							System.out.println("Compilation Errors");
							c=1;
						}
						else if(a.get(i)=='P'){
							a.remove(i);
							i--;
						}
						else b.add(a.get(i));
						i++;
					}
					if(i<=a.size()-1 && a.get(i)=='>'){
						if(!check(b)){
							System.out.println("Compilation Errors");
							c=1;
						}
						else{
							for(int j=0;j<=i;j++){
								a.remove(0);
							}
						}
					}
					else{
						System.out.println("Compilation Errors");
						c=1;
					}
				}
			
		
			else{
				a.remove(0);
				a.remove(a.size()-1);
				while(!a.isEmpty()){
					
					if(a.get(0)=='P')a.remove(0);
					
					if(!a.isEmpty() && a.get(0)=='('){
						int i=0;
						while(i<=a.size()-1 && a.get(i)!=')'){
							if(a.get(i)=='<' || a.get(i)=='>' || a.get(i)=='('){
								System.out.println("Compilation Errors");
								c=1;
							}
							else if(a.get(i)=='P'){
								a.remove(i);
								i--;
							}
							else b.add(a.get(i));
							i++;
						}
						if(i<=a.size()-1 && a.get(i)==')'){
							if(!check(b)){
								System.out.println("Compilation Errors");
								c=1;
							}
							else{
								for(int j=0;j<=i;j++){
									a.remove(0);
								}
							}
						}
						else{
							System.out.println("Compilation Errors");
							c=1;
						}
					}
					
				}
			}
			if(c==0){
				System.out.println("No Compilation Errors");
			}
			
			t--;
		}
	}
	public static boolean check(ArrayList<Character> b){
		for(int i=0;i<b.size()-1;i++){
			while(b.get(i)=='{' && b.get(i+1)=='}'){
				b.remove(i);
				b.remove(i);
				i--;
			}
		}
		
		while(!b.isEmpty() && b.get(0)=='{' && b.get(b.size()-1)=='}'){
			b.remove(0);
			b.remove(b.size()-1);
		}
		if(!b.isEmpty())
		return true;
		
		else return false;
	}
}
