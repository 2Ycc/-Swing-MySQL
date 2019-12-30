package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.student;

public class studentDAO {
	Connection conn = null;
	db DataBase = new db();
	//学生登录
	public boolean LoginCheck(String Sno, String Spwd) throws SQLException {
		try {
			conn = DataBase.getCon();
			Statement stat = null;
			ResultSet rs = null;
			stat = conn.createStatement();
			String sql = "SELECT * FROM student WHERE Sno ='"+Sno+"' and Spwd = '"+Spwd+"'";
			rs = stat.executeQuery(sql);
			if (rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return false;
	}
	
	//注册
	public boolean Register(String Sno ,String Spwd) throws SQLException {
		try {
			conn = DataBase.getCon();
			Statement stat = null;
			ResultSet rs = null;
			stat = conn.createStatement();
			String sql = "SELECT * FROM studentdao WHERE Sno ='"+Sno+"' ";
			rs = stat.executeQuery(sql);
			if (rs.next()){
				return false;
			}else{
				sql = "INSERT INTO studentdao VALUES ('"+Sno+"', '"+Spwd+"')";
				stat.executeUpdate(sql);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return true;
	}
	
	//返回学生信息对象
	public List<student> res() throws Exception {
		List<student> students = new ArrayList<>();
		student student;
		conn = DataBase.getCon();
		Statement stat = null;
		ResultSet rs = null;
		stat = conn.createStatement();
		String sql = "SELECT * FROM student";
		rs = stat.executeQuery(sql);
		while (true) {
            if ( rs.next() ) {
                student = new student();
                student.setSno( rs.getInt("Sno") );
                student.setName( rs.getString("Sname") );
                student.setGender( rs.getString("Sgender") );
                student.setAge( rs.getInt("Sage") );
                student.setClas( rs.getString("Sclass") );
                student.setMajor(rs.getString("Smajor"));
                student.setDept( rs.getString("Sdept") );
                students.add(student);
            }else 
            	break;
        }
		conn.close();
		return students;
	}

	
}
