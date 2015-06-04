import java.nio.file.Files;
import java.nio.file.OpenOption;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.io.*;

public class Main {
	
	public static String workingdir = System.getProperty("user.dir");
	 static Connection c = null;
     static Statement stmt=null;
    
    
	public static void main(String[] args) throws ClassNotFoundException{
		
        try {
        	Class.forName("org.postgresql.Driver");
			c = DriverManager
			   .getConnection("jdbc:postgresql://localhost:5432/postgres",
			   "postgres", "postgres");
	
        
        stmt = c.createStatement(
       		 ResultSet.TYPE_SCROLL_INSENSITIVE, 0
       		 );
        
			usertype();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void usertype() throws SQLException {
		Scanner s = new Scanner(System.in);
		System.out.println("\nUSER AUTHENTICATION");
		System.out.println("1 - SIGN IN");
		System.out.println("2 - SIGN UP");
		int user_choice = s.nextInt();
		if(user_choice == 1){
			signin();
		}
		else if(user_choice == 2){
			signup();
		}
	}
	public static void signin() throws SQLException {
		Scanner s = new Scanner(System.in);
		System.out.println("Type Username.");
		String username = s.nextLine();
		System.out.println("Type Password.");
		String password = s.nextLine();
		if(checkuser(username, password) == 1 ){
			/*
			List all files of the Directory.

			String userfolder = workingdir + "/" + username;
			File folder = new File(userfolder);
			File[] listOfFiles = folder.listFiles();

			    for (int i = 0; i < listOfFiles.length; i++) {
			      if (listOfFiles[i].isFile()) {
			        System.out.println("File " + listOfFiles[i].getName());
			      } else if (listOfFiles[i].isDirectory()) {
			        System.out.println("Directory " + listOfFiles[i].getName());
			      }
			 	}
			 	*/
			 signedin(username);

		}
		else{
			System.out.println("Wrong username or password.\n");
		}
		usertype();
	}
	public static void signup() throws SQLException{
		Scanner s = new Scanner(System.in);
		System.out.println("Type username");
		String username = s.nextLine();
		System.out.println("Type Password");
		String password = s.nextLine();
		if(newaccount(username, password) == 1){
			String filename = username;
			File theDir = new File(filename);  // Defining Directory/Folder Name  
			try{
			    if (!theDir.exists()){  // Checks that Directory/Folder Doesn't Exists!  
			     boolean result = theDir.mkdir();    
			     if(result){
			     System.out.println("New User Created\n");
			     }  
			    } 
			    else{
			    	System.out.println("Directory with this name already exists\n");
			    } 
			}catch(Exception e){
				System.out.println("Some error Creating the Directory.\n");  
			}
			System.out.println("Success");
		}
		else if(newaccount(username, password) == 2){
			System.out.println("User with this username already exists.\n");
		}
		else if(newaccount(username, password) == -1){
			System.out.println("There was some error in signing up. Try Again.\n");
		}
		usertype();
	}
	public static int newaccount(String username, String password){
		
	      try {
	       
	         String sql = "INSERT INTO USERS (USERNAME,PASSWORD) " + "Select '"+username+"','"+password+"'" + "WHERE NOT EXISTS (SELECT 1 FROM USERS WHERE USERNAME='"+username+"');";
	       int rowsAffected= stmt.executeUpdate(sql); 
	         
	        
	        
		       if(rowsAffected>0){

			          return 1;

			        }else{
			          return 2;
			                
			    }
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      
		return 0;
	}
	public static int checkuser(String username, String password){
	     
	      try {
	        
	        Scanner s = new Scanner(System.in);
	        ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME='"+username+"'");	
	        if(rs.first()){
	        String pass=rs.getString("password");	
	        if(password.equals(pass)){
	        	  workingdir= workingdir+"/"+username;
	        		return 1;
	        	}
	        	return 0;
	        }
	         
	        
	        
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      
	      return 0;
	}
	public static void signedin(String username) throws SQLException{
		//String username = username;
		Scanner s = new Scanner(System.in);
		System.out.println("\n\nls - list all files");
		System.out.println("mkdir - Fliename (create new Directory)");
		System.out.println("cd - Filename (change directory)");
		System.out.println("logout- Signout");
		System.out.println("delete- Filename (Delete this file)");
		System.out.println("createandwrite- (Create and Write in a file)");
		System.out.println("read - Filename (To read a file)");
		
		String selected = s.next();
		if(selected.equals("ls")){
			listfiles(username);
		}
		else if(selected.equals("mkdir")){
			String filename = s.next();
			File theDir = new File(username+"/"+filename);  // Defining Directory/Folder Name  
			try{
			    if (!theDir.exists()){  // Checks that Directory/Folder Doesn't Exists!  
			     boolean result = theDir.mkdir();    
			     if(result){
			     System.out.println("New Directory Created\n");
			     mkdir(filename, username);
			     }  
			    } 
			    else{
			    	System.out.println("Directory with this name already exists\n");
			    } 
			}catch(Exception e){
				System.out.println("Some error Creating the Directory.\n");  
			}  
		}
		else if(selected.equals("cd")){
			
			String folder =s.next();
			changeDirectory(folder,username);
		}
		else if(selected.equals("read")){
			
			String filename = s.next();
			read(filename,username);
		}
		else if(selected.equals("logout")){
			usertype();
		}
		else if(selected.equals("delete")){
			String filename = s.next();
			File curfile = new File(workingdir+"/"+username+"/"+filename);
			curfile.delete();
			delete(filename, username);
		}
		else if(selected.equals("createandwrite")){
			System.out.println("Type the file name:");
			String filename = s.next();
			createandwrite(filename,username);
		}
		else{
			System.out.println("wrong command");
		}
		signedin(username);
	}
	public static void mkdir(String filename, String username) throws SQLException{
		
        String path1= workingdir+"/"+filename;
        ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME='"+username+"'");	
        int user=1;
        if(rs.first()){
        	user=rs.getInt("id");
        	
        }
      
       String sql = "INSERT INTO FILES (PATH, NAME, OWNER, READ, WRITE, EXECUTE) " + "VALUES ('"+ path1 +"','"+ filename +"','"+ user +"','" +user +"','"+ user +"','"+ user +"')";
     
     
		try {
			stmt.executeUpdate(sql);
		
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void delete(String filename, String username) throws SQLException{
		String filepath = workingdir+"/"+filename;
		  ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME='"+username+"'");	
        int user=1;
        if(rs.first()){
        	user=rs.getInt("id");
        	
        }
       String sql = "DELETE FROM FILES  " + "WHERE path='"+filepath+"' AND owner="+user;
     
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
	public static void listfiles(String username) throws SQLException{
		ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME='"+username+"'");	
        int user=1;
        if(rs.first()){
        	user=rs.getInt("id");
        	
        }
         rs = stmt.executeQuery("SELECT * FROM FILES WHERE OWNER="+user);	
        while(rs.next()){
        String name=rs.getString("name");
        String path=rs.getString("path");
        if(path.contains(workingdir)){
        	System.out.print(name+"---------------");
            
            System.out.print(path);	
            System.out.println();
        }
        
       
        }
	}
	public static void createandwrite(String filename, String username) throws SQLException{
		System.out.println("Type the content below:");
		Scanner s = new Scanner(System.in);
		String q = s.nextLine();
	    byte data[] = q.getBytes();
	   String path1= workingdir+"/"+filename+".txt";
	    filename=filename+".txt";
	    ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME='"+username+"'");	
        int user=1;
        if(rs.first()){
        	user=rs.getInt("id");
        	
        }
      
       String sql = "INSERT INTO FILES (PATH, NAME, OWNER, READ, WRITE, EXECUTE) " + "SELECT '"+ path1 +"','"+ filename +"','"+ user +"','" +user +"','"+ user +"','"+ user +"'"+ "WHERE NOT EXISTS (SELECT 1 FROM files WHERE path='"+path1+"');";
     
     
		try {
			stmt.executeUpdate(sql);
		
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    Path p = Paths.get(path1);
	   
	    try (OutputStream out = new BufferedOutputStream(
	      Files.newOutputStream(p, CREATE, APPEND))) {
	      out.write(data, 0, data.length);
	    } catch (IOException x) {
	      System.err.println(x);
	    }
	}
	public static void read(String filename, String username){
		 String path1= workingdir+"/"+filename+".txt";
		
		   Path file = Paths.get(path1);
		try (InputStream in = Files.newInputStream(file);
		    BufferedReader reader =
		      new BufferedReader(new InputStreamReader(in))) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		    }
		} catch (IOException x) {
		    System.err.println(x);
		}
	}
	public static void changeDirectory(String folder, String Username){
		if(folder.equals("..")){
			//System.out.println(workingdir);
			String[] x=workingdir.split("/");
			int n=x.length-1;
			//System.out.println(x[n]);
			if(x[n].equals(Username)){
				System.out.println("sorry you can not access outside this");
			}
			else{
				for(int i=0;i<n;i++){
					workingdir=x[i];
				}
			}
		}else{
		workingdir=workingdir+"/"+folder;
		}
	}
}