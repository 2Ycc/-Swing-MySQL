package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.courseDAO;
import bean.course;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class updateCourseDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_2;

	private JButton button;
	private JButton button_1;
	String cno = null;
	String cname = null;
	String ccredit = null;
	String ctime = null;
	
	//更新课程
	public boolean updateCourse(String cno, String cname, String ccredit, String ctime) throws SQLException {
		if(cno.length()<1 || cname.length()<1 || ccredit.length()<1 || ctime.length()<1 ) {
			JOptionPane.showMessageDialog(this,"信息不能为空！");
			return false;
		}
		courseDAO courseDAO = new courseDAO();
		boolean istrue = courseDAO.update(cno, cname, ccredit, ctime);
		if(istrue) {
			JOptionPane.showMessageDialog(this,"修改成功！");
			return true;
		}else 
			JOptionPane.showMessageDialog(this,"修改失败，请检查输入信息是否正确！");
		return false;
	}
	
	
	//查询课程
		public boolean selectCourse(String cno) throws Exception {
			if(cno.length()<1 ) {	
				JOptionPane.showMessageDialog(this,"课程号不能为空！");
				return false;
			}
			courseDAO Course = new courseDAO();
			course course = new course();
			course = Course.select(cno);
			if(course!=null) {
				this.cno = String.valueOf( course.getCno() );
				this.cname = course.getCname();
				this.ccredit = course.getCcredit();
				this.ctime = course.getCtime();
				return true;
			}			
			else
				JOptionPane.showMessageDialog(this,"课程表里没有此课程的信息，无法修改！");
			return false;
		}
	
	
	public updateCourseDialog() {
		setTitle("\u8981\u4FEE\u6539\u7684\u8BFE\u7A0B");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(850, 400, 327, 194);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(89, 48, 173, 30);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8BFE\u7A0B\u53F7\uFF1A");
		lblNewLabel.setBounds(29, 55, 59, 15);
		
		//��ѯ
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setBounds(89, 114, 69, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cno = textField.getText();

				try {
					if( selectCourse(cno) ) {
						updateDialog();
					}		
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		//返回按钮
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.setBounds(193, 114, 69, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		contentPane.add(textField);
		
	}
	
	

	public void updateDialog() {
		setTitle("\u4FEE\u6539\u5B66\u751F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setBounds(800, 350, 431, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(115, 38, 206, 30);
		textField.setColumns(10);
		textField.setText(cno);
		
		textField_1 = new JTextField();
		textField_1.setBounds(115, 86, 206, 32);
		textField_1.setColumns(10);
		textField_1.setText(cname);
		
		textField_5 = new JTextField();
		textField_5.setBounds(115, 137, 206, 32);
		textField_5.setColumns(10);
		textField_5.setText(ccredit);
		
		textField_2 = new JTextField();
		textField_2.setBounds(115, 186, 206, 34);
		textField_2.setColumns(10);
		textField_2.setText(ctime);
		
		
		JLabel label = new JLabel("\u8BFE\u7A0B\u53F7\uFF1A");
		label.setBounds(55, 45, 53, 15);
		
		JLabel label_1 = new JLabel("\u8BFE\u7A0B\u540D\uFF1A");
		label_1.setBounds(55, 94, 53, 15);
		
		JLabel label_2 = new JLabel("\u5B66\u5206\uFF1A");
		label_2.setBounds(67, 145, 47, 15);
		
		JLabel label_3 = new JLabel("\u5B66\u65F6\uFF1A");
		label_3.setBounds(67, 195, 47, 15);
		
		button = new JButton("\u4FEE\u6539");
		button.setBounds(127, 249, 73, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cno = textField.getText();
				cname = textField_1.getText();
				ccredit = textField_5.getText();
				ctime = textField_2.getText();
				try {
					if( updateCourse(cno, cname, ccredit, ctime) ) {
						dispose();
					}		
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		button_1 = new JButton("\u8FD4\u56DE");
		button_1.setBounds(236, 249, 73, 23);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	
		contentPane.setLayout(null);
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(label_2);
		contentPane.add(label_3);
		contentPane.add(textField);
		contentPane.add(textField_1);
		contentPane.add(textField_5);
		contentPane.add(textField_2);

		contentPane.add(button);
		contentPane.add(button_1);

	}

}
