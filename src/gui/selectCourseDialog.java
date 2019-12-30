package gui;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.courseDAO;
import bean.course;

import javax.swing.JTable;
import javax.swing.JScrollPane;


public class selectCourseDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	TableModel tm_course;
	JTable tableCourse; //创建表格
	JScrollPane courseMessage; //创建滑动轴
	String[] strCourse = {"序号", "课程号", "课程名", "学分", "学时"};  //表格标题
	String[][] courseList;
	
	public void gengxin(String[][] courseList) throws Exception {
		tm_course = new TableModel();  //新建表格模型
		tm_course.setColumnNames(strCourse);//设置表格标题
		
        contentPane.setLayout(new BorderLayout(0, 0));
        tableCourse = new JTable(tm_course);  
        courseMessage = new JScrollPane(tableCourse);
        contentPane.add(courseMessage);
		try {
			tm_course.setMessages(courseList); //将查询出来的数据显示在表格中
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//返回装有课程对象的列表
	public static String[][] getCourseList() throws Exception {  
		courseDAO user = new courseDAO();
        List<course> list = user.courseRes();
        String[][] courses = new String[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
        	courses[i][0] = list.get(i).getCnum();
        	courses[i][1] = list.get(i).getCno();
        	courses[i][2] = list.get(i).getCname();
        	courses[i][3] = list.get(i).getCcredit();
        	courses[i][4] = list.get(i).getCtime();
        }
        return courses;
    }

	public selectCourseDialog() throws Exception {
		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(800, 350, 480, 320);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//初始化表格内容
		courseList = getCourseList();
		gengxin(courseList);	
			
     }

}
