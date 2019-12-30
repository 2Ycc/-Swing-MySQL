package gui;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.userDAO;
import bean.student;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;

public class studentFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	TableModel tm_student;
	JTable tablestudent; 
	JScrollPane stuentmessage; 
	String[] strstudent = {"学号", "姓名", "性别", "年龄", "班级", "专业", "系别"};  
	String[][] studentList;
	String id = null;
	
	public void gengxin(String[][] studentList) throws Exception {
		tm_student = new TableModel();
	    tm_student.setColumnNames(strstudent);

        contentPane.setLayout(new BorderLayout(0, 0));
        
        tablestudent = new JTable(tm_student);  
        stuentmessage = new JScrollPane(tablestudent);  
        contentPane.add(stuentmessage);
		try {
			tm_student.setMessages(studentList); //初始化表格内容
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String[][] getStudentList() throws Exception {  //������ѧ����Ϣ���ַ�������ķ�ʽ����
		userDAO user = new userDAO();
        List<student> list = user.res();
        String[][] strings = new String[list.size()][7];
        for (int i = 0; i < list.size(); i++) {
            strings[i][0] = Integer.toString(list.get(i).getSno());
            strings[i][1] = list.get(i).getName();
            strings[i][2] = list.get(i).getGender();
            strings[i][3] = Integer.toString(list.get(i).getAge());
            strings[i][4] = list.get(i).getClas();
            strings[i][5] = list.get(i).getMajor();
            strings[i][6] = list.get(i).getDept();
        }
        return strings;
    }
	
	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public studentFrame(String id) throws Exception {
		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 250, 659, 513);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u67E5\u8BE2");
		menuBar.add(mnNewMenu);
		
		//查询成绩
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2\u6210\u7EE9");
		mnNewMenu.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectOwnScoreDialog selectScore;
				try {
					selectScore = new selectOwnScoreDialog(id);
					selectScore.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
			
		//查询课程
		JButton button_2 = new JButton("\u67E5\u8BE2\u8BFE\u7A0B");
		mnNewMenu.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectCourseDialog selectCourse = null;
				try {
					selectCourse = new selectCourseDialog();
					selectCourse.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
			
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//初始化表格信息
		studentList = getStudentList();
		gengxin(studentList);	
			
        }
		



}
