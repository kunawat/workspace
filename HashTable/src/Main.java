import java.util.Scanner;
public class Main {//keys need not be distinct and similar keys stored using double linked list;
	public static void main(String args[]){
		list A[]= new list[3];
		for(int i=0; i<3; i++){
			A[i]=new list();
		}
		table T= new table();
		node x=new node(1);
		T.insert(A,x);
		x.key=3;
		T.insert(A,x);
		x.key=4;
		T.insert(A,x);
		x.key=5;
		T.insert(A,x);
		x.key=3;
		T.insert(A,x);
		x.key=6;
		T.insert(A,x);
		x.key=6;
		T.insert(A,x);
		x.key=7;
		T.insert(A,x);
		x.key=8;
		T.insert(A,x);
	
		T.delete(A, x);
		System.out.println(T.search(A, 5).key);
		for(int i=0;i<3;i++){
			node k=A[i].head;
			while(k!=null){
				System.out.println(k.key);
				k=k.next;
			}
		}
	}
}
