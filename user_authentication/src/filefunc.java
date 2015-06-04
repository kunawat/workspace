

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class filefunc {
	
	public static void insert(Statement stmt){
		String name1="hell";
        String path1="Desktop/shells.txt";
        int owner1=1;
        int read1=1;
        int write1=1;
        int execute1=1;
       String sql = "INSERT INTO FILES (PATH, NAME, OWNER, READ, WRITE, EXECUTE) " + "VALUES ('"+ path1 +"','"+ name1 +"','"+ owner1 +"','" +read1 +"','"+ write1 +"','"+ execute1 +"')";
     
        int rowsAffected;
		try {
			rowsAffected = stmt.executeUpdate(sql);
		
         if(rowsAffected>0){

           System.out.println( "File entered");

             }else{

                 System.out.println( "file name exists!");
             }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void delete(Statement stmt){
		
        String path1="Desktop/shells.txt";
        int user=1;
       
       String sql = "DELETE FROM FILES  " + "WHERE path='"+path1+"' AND owner="+user;
     
        int rowsAffected;
		try {
			rowsAffected = stmt.executeUpdate(sql);
		
         if(rowsAffected>0){

           System.out.println( "File Deleted");

             }else{

                 System.out.println( "User does not have permission or path is invalid!");
             }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void readlist(Statement stmt) throws SQLException{
		int user =1;
		String sql="";
		ResultSet rs = stmt.executeQuery("SELECT * FROM FILES WHERE OWNER="+user);	
        while(rs.next()){
        String name=rs.getString("name");
        System.out.print(name+"---------------");
        String path=rs.getString("path");
        System.out.print(path);	
        System.out.println();
       
        }
	}
}
