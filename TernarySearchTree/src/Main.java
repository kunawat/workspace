import java.util.*;
public class Main {
	public static void main(String args[]){
		TST s = new TST();
		s.insert(s.root, "cat");
		s.insert(s.root, "cup");
		s.insert(s.root, "bug");
		s.insert(s.root, "cats");
		char[] buf= new char[5];
		
		s.traverse(s.root, buf, 0);
		if(s.search(s.root, "cup"))System.out.println("Found");
		else System.out.println("Not Found");
	}
	public static class node{
		char c;
		boolean isEnd=false;
		node left, right, equal=null;
		public node(char c) {
			super();
			this.c = c;
			this.isEnd = false;
			this.left = null;
			this.right = null;
			this.equal = null;
		}
		
	}
	public static class TST{
		node root=null;
		public node insert(node n, String word){
			if(n==null){
				n=new node(word.charAt(0));
				if(root==null)root=n;
			}
			
			if(n.c>word.charAt(0)){
				n.left=insert(n.left,word);
			}
			else if(n.c<word.charAt(0)){
				n.right=insert(n.right,word);
			}
			else{
				if(word.length()==1){
					n.isEnd=true;
				}
				else{
					n.equal=insert(n.equal,word.substring(1));
				}
			}
			return n;
		}
		public void traverse(node root, char[] buf, int depth){
			if(root!=null){
				traverse(root.left,buf,depth);
				buf[depth]=root.c;
				if(root.isEnd){
					buf[depth+1]='\0';
					System.out.println(buf);
				}
				traverse(root.equal,buf,depth+1);
				traverse(root.right,buf,depth);
			}
		}
		public boolean search(node root, String word){
			if(root==null)return false;
			if(root.c>word.charAt(0)){
				return search(root.left,word);
			}
			else if(root.c<word.charAt(0)){
				return search(root.right,word);
			}
			else{
				if(word.length()==1 )return root.isEnd;
				else return search(root.equal,word.substring(1));
			}
		}
	}
}
