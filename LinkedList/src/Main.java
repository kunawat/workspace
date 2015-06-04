import java.util.Scanner;
public class Main {
	public static void main(String [] args){
		Scanner s = new Scanner (System.in); 
	
	
		list x= new list();
		x.insert(1);
		x.insert(2);
		x.insert(3);
		x.insert(4);
		x.delete(x.search(4));
		System.out.println(x.search(3).key);
		
		x.reverse();
		node k=x.head;
		while(k!=null){
			System.out.println(k.key);
			k=k.next;
		}
	}
}