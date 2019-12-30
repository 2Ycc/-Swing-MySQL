package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.studentDAO;
import DAO.userDAO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class registerGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private String id = null;
	private String name = null;
	private String pwd = null;
	private String re_pwd = null;

	
	//检查输入的信息是否为空
	public boolean checkNull(String id, String name, String pwd, String re_pwd) {
		if(id.length()<1 || name.isEmpty() || pwd.length()<1 || re_pwd.length()<1) {
			JOptionPane.showMessageDialog(this,"输入信息不能为空！");
			return false;
		}
		if(pwd.equals(re_pwd)) {
			return true;
		}else {
			JOptionPane.showMessageDialog(this,"两次密码不相同！");
		}
		return false;
	}
	
	//注册（管理员）
	public void register( String id, String name, String pwd, String re_pwd) {
		userDAO register = new userDAO();
		if( checkNull(id, name, pwd, re_pwd) )
			try {
				if( !register.Register(id, name, pwd) )
					JOptionPane.showMessageDialog(this,"注册失败！");
				else {
					JOptionPane.showMessageDialog(this,"注册成功！");
					dispose();
				}	
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	}
	
	//学生注册（暂时不用）
	public void stuRegister( String id, String name, String pwd, String re_pwd) {
		studentDAO register = new studentDAO();
		if( checkNull(id, name, pwd, re_pwd) )
			try {
				if( !register.Register(id, pwd) )
					JOptionPane.showMessageDialog(this,"注册失败！");
				else {
					JOptionPane.showMessageDialog(this,"注册成功！");
					dispose();
				}				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	}
	

	public registerGUI() {
		setTitle("\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(720, 350, 428, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(121, 51, 191, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//注册按钮
		JButton button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = textField.getText();
				name = textField_3.getText();
				pwd = String.copyValueOf(passwordField.getPassword());
				re_pwd = String.copyValueOf(passwordField_1.getPassword());
//				if(identity==1)
					register( id, name, pwd, re_pwd );	
//				else 
//					stuRegister( id, name, pwd, re_pwd );
			}
		});
		button.setBounds(121, 241, 93, 30);
		contentPane.add(button);
		
		//返回按钮
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(222, 241, 93, 30);
		contentPane.add(button_1);
		
		JLabel lblId = new JLabel("ID\uFF1A");
		lblId.setBounds(86, 58, 34, 15);
		contentPane.add(lblId);
		
		JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setBounds(72, 153, 49, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_1.setBounds(48, 197, 71, 15);
		contentPane.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(121, 97, 191, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_2 = new JLabel("\u59D3\u540D\uFF1A");
		label_2.setBounds(72, 104, 49, 15);
		contentPane.add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("����", Font.PLAIN, 10));
		passwordField.setBounds(121, 147, 191, 30);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("����", Font.PLAIN, 10));
		passwordField_1.setBounds(121, 191, 191, 30);
		contentPane.add(passwordField_1);
	}
}
