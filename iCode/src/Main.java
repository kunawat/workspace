import java.util.*;
public class Main {
public static void main(String args[])
{
    Scanner s=new Scanner(System.in);
    int n=s.nextInt();
    int m=s.nextInt();
    int k=1;
    int j=1;
    int count=0;
    for(int i=1;i<=n;i++)
    {
       
        if(i%m==1)
        {
            System.out.println(((m+1)/2));
            k=1;
            j=1;
            count++;
        }
        else if(count%2!=0)
        {
            if(i%2==0)
            {
                if((((m+1)/2)-k)==0)
                {
                    System.out.println(((m+1)/2)+j);
                }
                else
                {
                    System.out.println(((m+1)/2)-k);
                    //System.out.println("k is"+k);
                    k++;
                }
            }
            else
            {
                if((((m+1)/2)+j)==n+1)
                {
                    System.out.println(((m+1)/2)-k);
                }
                else
                {
                    System.out.println(((m+1)/2)+j);
                //    System.out.println("j is "+j);
                    j++;
                }
            }
        }
        else
        {
            if(i%2!=0)
            {
                if((((m+1)/2)-k)==0)
                {
                    System.out.println(((m+1)/2)+j);
                }
                else
                {
                    System.out.println(((m+1)/2)-k);
                    //System.out.println("k is"+k);
                    k++;
                }
            }
            else
            {
                if((((m+1)/2)+j)==n+1)
                {
                    System.out.println(((m+1)/2)-k);
                }
                else
                {
                    System.out.println(((m+1)/2)+j);
                //    System.out.println("j is "+j);
                    j++;
                }   
            }
        }
        }
       
   
   
}
}
