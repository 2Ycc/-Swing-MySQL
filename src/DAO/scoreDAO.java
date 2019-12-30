package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.score;
import bean.student;

public class scoreDAO {
	Connection conn = null;
	db DataBase = new db();
	
	//成绩信息
	public List<score> scoreRes() throws Exception {
		List<score> scores = new ArrayList<>();
		score score;
		conn = DataBase.getCon();
		Statement stat = null;
		ResultSet rs = null;
		stat = conn.createStatement();
		String sql = "SELECT * FROM score";
		rs = stat.executeQuery(sql);
		while (true) {
            if ( rs.next() ) {
            	score = new score();
            	score.setSno( rs.getString("Sno") );
            	score.setSname( rs.getString("Sname") );
            	score.setCno( rs.getString("Cno") );
            	score.setCname( rs.getString("Cname") );
            	score.setSscore( rs.getString("Sscore") );
            	score.setRescore( rs.getString("Rescore") );
            	scores.add(score);
            }else 
            	break;
        }
		conn.close();
		return scores;
	}
	
	//某个学生的所有成绩
	public List<score> scoreOwnRes(String id) throws Exception {
		List<score> scores = new ArrayList<>();
		score score;
		conn = DataBase.getCon();
		Statement stat = null;
		ResultSet rs = null;
		stat = conn.createStatement();
		String sql = "SELECT * FROM score WHERE sno = '"+id+"'";
		rs = stat.executeQuery(sql);
		while (true) {
            if ( rs.next() ) {
            	score = new score();
            	score.setSno( rs.getString("Sno") );
            	score.setSname( rs.getString("Sname") );
            	score.setCno( rs.getString("Cno") );
            	score.setCname( rs.getString("Cname") );
            	score.setSscore( rs.getString("Sscore") );
            	score.setRescore( rs.getString("Rescore") );
            	scores.add(score);
            }else 
            	break;
        }
		conn.close();
		return scores;
	}
	
	//录入成绩
	public boolean insert(String sno, String cno, String sscore) throws SQLException {
		try {
			conn = DataBase.getCon();
			Statement stat = null;
			stat = conn.createStatement();
			String sql = "SELECT Sname FROM student WHERE sno = '"+sno+"' ";
			String sql_2 = "SELECT cname FROM course WHERE cno = '"+cno+"' ";		
			ResultSet rs = null;
			ResultSet rs_2 = null;
			String sname =null;
			String cname = null;
			rs = stat.executeQuery(sql);
			if(rs.next())
				sname = rs.getString("Sname");
			rs_2 = stat.executeQuery(sql_2);
			if ( rs_2.next() ) 
				cname = rs_2.getString("Cname");	
			else {
				return false;
			}
			String sql_3 = "INSERT INTO score (sno,sname,cno,cname,sscore) VALUES ( '"+sno+"', '"+sname+"','"+cno+"', '"+cname+"','"+sscore+"' )";
			if ( stat.executeUpdate(sql_3)==1 ){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return false;
	}
	
	//删除成绩
	public boolean delete(String sno, String cno) throws SQLException  {
		try {
			conn = DataBase.getCon();
			Statement stat = null;
			stat = conn.createStatement();
			String sql = "DELETE FROM score WHERE sno = '"+sno+"' AND cno = '"+cno+"' ";		
			if ( stat.executeUpdate(sql)==1 ){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return false;
	}
	
	//查询成绩
	public score select(String sno, String cno) throws SQLException  {
		try {
			conn = DataBase.getCon();
			Statement stat = null;
			stat = conn.createStatement();
			ResultSet rs = null;
			score sc = null;
			String sql = "SELECT * FROM score WHERE sno = '"+sno+"' AND cno = '"+cno+"'";		
			rs = stat.executeQuery(sql);
			if ( rs.next() ){			
				sc = new score();
				sc.setSno( rs.getString("Sno") );
				sc.setSname( rs.getString("Sname") );
				sc.setCno( rs.getString("Cno") );
				sc.setCname( rs.getString("Cname") );
				sc.setSscore( rs.getString("Sscore") );
				sc.setRescore(rs.getString("Rescore"));
				return sc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return null;
	}
	
	//删除某门课程的成绩
	public boolean update(String sno, String cno, String sscore, String rescore) throws SQLException  {
		try {
			conn = DataBase.getCon();
			Statement stat = null;
			stat = conn.createStatement();
			String sql = "UPDATE score SET Sscore = '"+sscore+"', Rescore = '"+rescore+"'  WHERE sno = '"+sno+"' AND cno ='"+cno+"' ";		
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
