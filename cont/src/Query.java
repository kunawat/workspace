import java.util.*;
public class Query {
	String id;
	String query;
	List attr;
	int freq;
	public Query(String id, String query, List attr, int freq) {
		super();
		this.id = id;
		this.query = query;
		this.attr = attr;
		this.freq = freq;
	}
}
