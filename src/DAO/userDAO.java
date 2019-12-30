package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.student;


public class userDAO {
	Connection conn = null;
	db DataBase = new db();
	//管理员登录
	public boolean LoginCheck(String id, String pwd) throws SQLException {
		try {
			conn = DataBase.getCon();
			Statement stat = null;
			ResultSet rs = null;
			stat = conn.createStatement();
			String sql = "SELECT * FROM adminDAO WHERE Aid ='"+id+"' and Apwd = '"+pwd+"'";
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
	
	//管理员注册
	public boolean Register(String id, String name ,String pwd) throws SQLException {
		try {
			conn = DataBase.getCon();
			Statement stat = null;
			ResultSet rs = null;
			stat = conn.createStatement();
			String sql = "SELECT * FROM adminDAO WHERE Aid ='"+id+"' and Apwd = '"+pwd+"'";
			rs = stat.executeQuery(sql);
			if (rs.next()){
				return false;
			}else{
				sql = "INSERT INTO adminDAO VALUES ('"+id+"','"+name+"','"+pwd+"')";
				stat.executeUpdate(sql);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return true;
	}
	
	//返回学生信息对象列表
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
	
	//返回指定学生的信息
	public List<student> Select(String sno, String name) throws Exception {
		List<student> students = new ArrayList<>();
		student student;
		conn = DataBase.getCon();
		Statement stat = null;
		ResultSet rs = null;
		stat = conn.createStatement();
		String sql = "SELECT * FROM student WHERE Sno ='"+sno+"' OR Sname = '"+name+"'";
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
	
	//录入学生信息
	public boolean insert(String sno, String name, String gender, String age, String clas , String major, String dept) throws SQLException {
		try {
			conn = DataBase.getCon();
			Statement stat = null;
			stat = conn.createStatement();
			String sql = "INSERT INTO student (sno,sname,sgender,sage,sclass,smajor,sdept)"
					+ " VALUES ( '"+sno+"','"+name+"', '"+gender+"' ,'"+age+"' ,'"+clas+"' ,'"+major+"' ,'"+dept+"')";
			if ( stat.executeUpdate(sql)==1 ){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return false;
	}
	
	//删除学生信息
	public boolean delete(String sno) throws SQLException  {
		try {
			conn = DataBase.getCon();
			Statement stat = null;
			stat = conn.createStatement();
			String sql = "DELETE FROM student WHERE sno = '"+sno+"' ";		
			if ( stat.executeUpdate(sql)==1 ){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return false;
	}
	
	//根据学号查询单个学生
	public student select(String sno) throws SQLException  {
		try {
			conn = DataBase.getCon();
			Statement stat = null;
			stat = conn.createStatement();
			ResultSet rs = null;
			student stu = null;
			String sql = "SELECT * FROM student WHERE sno = '"+sno+"' ";		
			rs = stat.executeQuery(sql);
			if ( rs.next() ){			
				stu = new student();
				stu.setSno( rs.getInt("Sno") );
				stu.setName( rs.getString("Sname") );
				stu.setGender( rs.getString("Sgender") );
				stu.setAge( rs.getInt("Sage") );
				stu.setClas( rs.getString("Sclass") );
				stu.setMajor(rs.getString("Smajor"));
				stu.setDept( rs.getString("Sdept") );
				return stu;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return null;
	}
	
	//更新学生信息
	public boolean update(String sno, String name, String gender, String age, String clas , String major, String dept) throws SQLException  {
		try {
			conn = DataBase.getCon();
			Statement stat = null;
			stat = conn.createStatement();
			String sql = "UPDATE student SET sno = '"+sno+"', sname = '"+name+"', sgender = '"+gender+"', sage = '"+age+"',"
					+ "sclass = '"+clas+"', smajor = '"+major+"', sdept = '"+dept+"' WHERE sno = '"+sno+"' ";		
			if ( stat.executeUpdate(sql)==1 ){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return false;
	}
	
}
