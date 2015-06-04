import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main{


    	 public static void main(String[] args) throws FileNotFoundException {
    		 try{
    	        Scanner s = new Scanner(new File("C:/Users/Mayank/Desktop/DBMS/Query.csv"));
    	        s.nextLine();
    	        List<Query> q = new ArrayList<Query>();
    	        int c=0;
    	        while(s.hasNext()){
    	        	String[] str = s.nextLine().split(",");
    	        	int n= str.length;
    	        	List<String> l = new LinkedList<String>();
    	        	for(int i=2;i<n-1;i++){
    	        		if(!str[i].isEmpty())l.add(str[i]);
    	        	}
    	        	
    	        	//System.out.println(str[n-1]);
    	        	q.add(new Query(str[0],str[1],l,Integer.parseInt(str[n-1])));
    	        	c++;
    	        }
    	        Map<String,Integer> m = new HashMap<String,Integer>();
    	        int count=0;
    	        for(int i=0;i<c;i++){
    	        	Query temp=q.get(i);
    	        	List l =temp.attr;
    	        	int n=l.size();
    	        	for(int j=0;j<n;j++){
    	        		String x = (String) l.get(j);
    	        		if(m.containsKey(x)){
    	        			m.put(x,m.get(x)+temp.freq);
    	        		}
    	        		else{
    	        			m.put(x, temp.freq);
    	        			count++;
    	        		}
    	        	}	
    	        }
    	        int[] d = new int[count];
    	        int k=0;
    	        for (Map.Entry<String, Integer> entry : m.entrySet())
    	        {
    	           d[k++]=entry.getValue();
    	        }
    	        Arrays.sort(d);
    	        float support=0;
    	        if(k%2==0){
    	        	support=(d[k/2]+d[k/2+1])/2;
    	        
    	       
    	        }
    	        else{
    	        	support=d[(k+1)/2];
    	        }
    	    	support=(float) (support*(0.8));
    	    	List<String> rem= new LinkedList<String>();
    	    	
    	    	 for (Iterator<String> entry = m.keySet().iterator(); entry.hasNext();)
     	        {
    	    		 String key=entry.next();
    	    		 if(m.get(key)<support){
    	    			 rem.add(key);
    	    			 m.remove(m.get(key));
    	    		 }
     	        }
    	    	for(String x:rem){
    	    		for(int i=0;i<c;i++){
    	    			List temp=q.get(i).attr;
    	    			if(temp.contains(x))
    	    			temp.remove(x);
    	    		}
    	    	}
    	    	m.clear();
    	    	count=0;
    	    	for(int i=0;i<c;i++){
    	    		List<String> temp=q.get(i).attr;
    	    		List<String> list = new LinkedList<String>();
    	    		while(!temp.isEmpty()){
	    	    		String r =temp.remove(0);
	    	    		for(String x:temp){
	    	    			String u=r.concat("___________").concat(x);
	    	    			list.add(u);
	    	    			if(m.containsKey(u)){
	    	        			m.put(u,m.get(u)+q.get(i).freq);
	    	        		}
	    	        		else{
	    	        			m.put(u,q.get(i).freq);
	    	        			count++;
	    	        		}
	    	    		}
    	    		}
    	    		 
    	    		temp=list;
    	    	}
    	    	int[] g = new int[count];
   	         k=0;
   	        for (Map.Entry<String, Integer> entry : m.entrySet())
   	        {
   	           g[k++]=entry.getValue();
   	        }
   	        Arrays.sort(g);
   	         support=0;
   	        if(k%2==0){
   	        	support=(g[k/2]+g[k/2+1])/2;
   	        
   	       
   	        }
   	        else{
   	        	support=g[(k+1)/2];
   	        }
   	    	support=(float) (support*(0.8));
   	    	rem.clear();
   	    	
   	     for (Iterator<String> keys = m.keySet().iterator(); keys.hasNext();) {
   	        String key = keys.next();
   	     if(m.get(key)<support){
			 rem.add(key);
			 m.remove(m.get(key));
		 }
     }
   	    	

   	    	 for (Map.Entry<String, Integer> entry : m.entrySet())
    	        {
   	    		 System.out.println(entry.getKey());
    	        }
    	        s.close();
    	    }


        catch (FileNotFoundException e){
        	
            e.printStackTrace();
        }

    }
}