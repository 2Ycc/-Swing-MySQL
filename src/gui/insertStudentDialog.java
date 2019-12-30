package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.userDAO;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class insertStudentDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton radioButton;
	private JButton button;
	private JButton button_1;
	private JLabel label_5;
	String sno = null;
	String name = null;
	String age = null;
	String gender = "��";
	String major = null;
	String dept = null;
	String clas = null;

	//录入学生信息
	public boolean insertStudent(String sno, String name, String gender, String age, String clas, String major, String dept) throws SQLException {
		if(sno.length()<1 || name.length()<1 || age.length()<1 || gender.length()<1 || clas.length()<1 || major.length()<1 || dept.length()<1 ) {
			JOptionPane.showMessageDialog(null,"信息不能为空！");
			return false;
		}
		userDAO userDAO = new userDAO();
		boolean istrue = userDAO.insert(sno, name, gender, age, clas, major, dept);
		if(istrue) {
			JOptionPane.showMessageDialog(null,"学生信息录入成功！");
			return true;
		}else 
			JOptionPane.showMessageDialog(null,"学生录入失败，此学号已存在！");
		return false;
	}
	
	
	//构造函数
	public insertStudentDialog(mainFrame mainFrame) {
		setTitle("\u589E\u52A0\u5B66\u751F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(800, 250, 431, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(115, 38, 206, 30);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(115, 86, 206, 32);
		textField_1.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(115, 136, 206, 32);
		textField_5.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(115, 236, 206, 32);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(115, 286, 206, 32);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(115, 186, 206, 32);
		textField_4.setColumns(10);
		JLabel label = new JLabel("\u5B66\u53F7\uFF1A");
		label.setBounds(67, 45, 47, 15);
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setBounds(67, 95, 49, 15);
		
		JLabel label_2 = new JLabel("\u5E74\u9F84\uFF1A");
		label_2.setBounds(67, 145, 47, 15);
		
		JLabel label_3 = new JLabel("\u4E13\u4E1A\uFF1A");
		label_3.setBounds(67, 242, 47, 15);
		
		JLabel label_4 = new JLabel("\u7CFB\u522B\uFF1A");
		label_4.setBounds(67, 292, 47, 15);
		
		label_5 = new JLabel("\u73ED\u7EA7\uFF1A");
		label_5.setBounds(67, 196, 43, 15);
		
		rdbtnNewRadioButton = new JRadioButton("\u7537");
		rdbtnNewRadioButton.setBounds(138, 326, 46, 23);
		rdbtnNewRadioButton.setSelected(true);
		
		radioButton = new JRadioButton("\u5973");
		radioButton.setBounds(251, 326, 57, 23);
		
		ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(rdbtnNewRadioButton);
        btnGroup.add(radioButton);
		
		button = new JButton("\u63D2\u5165");
		button.setBounds(127, 367, 73, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sno = textField.getText();
				name = textField_1.getText();
				age = textField_5.getText();
				if(radioButton.isSelected()) {
					gender = "Ů";
				}
				major = textField_2.getText();
				dept = textField_3.getText();
				clas = textField_4.getText();
				try {
					if( insertStudent(sno, name,  gender, age, clas, major, dept) ) {
						dispose();
//						mainFrame.setVisible(false);
						mainFrame.dispose();
						mainFrame mainFrame = new mainFrame();
						mainFrame.setVisible(true);
					}		
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		button_1 = new JButton("\u8FD4\u56DE");
		button_1.setBounds(235, 367, 73, 23);
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
		contentPane.add(textField_4);
		contentPane.add(button);
		contentPane.add(rdbtnNewRadioButton);
		contentPane.add(radioButton);
		contentPane.add(button_1);
		contentPane.add(label_4);
		contentPane.add(textField_3);
		contentPane.add(label_5);
	}

}
