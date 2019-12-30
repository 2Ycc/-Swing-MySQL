package DAO;
import java.sql.Connection;
import java.sql.DriverManager;

public class db {
	 
	private String dbUrl="jdbc:mysql://localhost:3306/tssystem?characterEncoding=utf-8";
	private String dbUserName="root";
	private String dbPassword="";
	private String jdbcName="com.mysql.jdbc.Driver";
	
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}

}