package demo.domain;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;



public class JDBCConnection {
	
	
//	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://database-new.cciohncgfm5b.eu-west-1.rds.amazonaws.com/games";
    private String username;
    private String password;
    
    static Connection conn = null;
    static Statement stmt = null;
    
    public JDBCConnection(String username, String password) {
        this.username = username;
        this.password = password;
        try {
//        	Class.forName(JDBC_DRIVER);
        	conn = DriverManager.getConnection(DB_URL, username, password);
        	stmt = conn.createStatement();
//        } catch (ClassNotFoundException e) {
//        	e.printStackTrace();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }
    
    public void exUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
        	e.printStackTrace();
            }
        }
    
    static ResultSet exQuery(String query) {
    	ResultSet response = null;
    	try {
    		response = stmt.executeQuery(query);
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return response;
    }
    	
    

}
