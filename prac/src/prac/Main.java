package prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
public static void main(String[] args) throws IOException {
BufferedReader s = new BufferedReader( new InputStreamReader(System.in));
int r= Integer.parseInt(s.readLine());
int c= Integer.parseInt(s.readLine());
char[][] A = new char[r][c];
for(int j=0;j<(r+1)/2;j++){
for(int k=0;k<j;k++){
	if(k%2==0)A[j][k]='X';
	else A[j][k]='0';

}
for(int k=j;k<c-j;k++){
	if(j%2==0)A[j][k]='X';
	else A[j][k]='0';
}
for(int k=c-j;k<c;k++){
	if(A[j][k-1]=='X')A[j][k]='0';
	else A[j][k]='X';
}
}
for(int j=0; j<(r+1)/2; j++){
	for(int k=0; k<c; k++){
		System.out.print(A[j][k]+" ");
	}
	
	System.out.println();
}
int j=(r+1)/2;
if(r%2==1)j--;
for(j--; j>=0; j--){
	for(int k=0; k<c; k++){
		System.out.print(A[j][k]+" ");
	}
	System.out.println();
}
}
}