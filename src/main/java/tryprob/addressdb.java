package tryprob;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class addressdb {
	String jdbcurl="jdbc:mysql://localhost:3306/address";
    String username="root";
    String password="root";
    Connection connections;
    
    public Connection getcon()
    {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	} 
    	 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
    try {

    	connections = DriverManager.getConnection(jdbcurl, username, password);
    }catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
    }catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
    }
    System.out.println("dbgoodbye!");
    
    
return connections;
}

}
