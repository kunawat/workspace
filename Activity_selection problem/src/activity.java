import java.util.*;

	public class activity{
		int start;
		 int finish;
		
		
		public static Comparator<activity> byfinish = new Comparator<activity>() {
			 
	        public int compare(activity e1, activity e2) {
	            return (int) (e1.finish - e2.finish);
	        }
	    };
	}