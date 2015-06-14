import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.nextLine();
		Map<String,String> data = new HashMap<String, String>();
		for(int i=0;i<n;i++){
			String[] x = s.nextLine().split(" ");
			data.put(x[0],x[1]);
		}
		
		
		//reverse map employees under every manager
		Map<String,List<String>> mngEmp = new HashMap<String,List<String>>();
		for(Map.Entry<String,String> entry: data.entrySet()){
			String emp=entry.getKey();
			String mng=entry.getValue();
			if(!emp.equals(mng)){
				List<String> reportList=mngEmp.get(mng);
				if(reportList==null) reportList= new ArrayList<String>();
				reportList.add(emp);
				mngEmp.put(mng,reportList);
			}
			
		}
		Map<String , Integer> result= new HashMap<String, Integer>();
		for(Map.Entry<String,List<String>> entry: mngEmp.entrySet()){
			populateResult(mngEmp,result,entry.getKey());
		}
		System.out.println("Result= "+result);
	}
	public static int populateResult(Map<String,List<String>> mngEmp, Map<String , Integer> result, String mng){
		if(!mngEmp.containsKey(mng)){
			result.put(mng,0);
			return 0;
		}
		if(result.containsKey(mng))return result.get(mng);
		List<String> reportList=mngEmp.get(mng);
		int count=reportList.size();
		for(String emp:reportList){
			count += populateResult(mngEmp,result,emp);
		}
		result.put(mng,count);
		return count;
	}
}
