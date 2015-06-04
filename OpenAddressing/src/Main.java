public class Main {//keys need not be distinct and similar keys stored using double linked list;
	public static void main(String args[]){
		int A[]= new int[11];
		for(int i=0; i<11; i++){
			A[i]=-2;
		}
		table T= new table();
		
		T.insert(A,3);
	
		T.insert(A,4);
		
		T.insert(A,5);
		
		T.insert(A,1);
		
		T.insert(A,3);
		
		T.insert(A,6);
	
		T.insert(A,6);
		
		T.insert(A,7);
		
		T.insert(A,8);
	
		T.delete(A, 8);
		System.out.println(T.search(A, 5));
		for(int i=0;i<11;i++){
			
			if(A[i]>=0)
				System.out.println(A[i]);
			
		}
	}
}
