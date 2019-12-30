package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import DAO.userDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deleteStudentDialog extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	String sno = null;


	//删除学生
	public boolean deleteStudent(String sno) throws Exception {
		if(sno.length()<1 ) {
			JOptionPane.showMessageDialog(this,"学号不能为空！");
			return false;
		}
		userDAO user = new userDAO();
		if(user.delete(sno)) {
			JOptionPane.showMessageDialog(this,"删除学生成功！");
			return true;
		}			
		else
			JOptionPane.showMessageDialog(this,"删除学生失败，请检查该学号是否正确！");
		return false;
	}
	
	//构造函数
	public deleteStudentDialog(mainFrame mainFrame) {
		setTitle("\u5220\u9664\u5B66\u751F");
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
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setBounds(29, 55, 50, 15);
		
		//删除按钮
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.setBounds(89, 114, 69, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sno = textField.getText();
				try {
					if( deleteStudent(sno) ) {
						dispose();
						mainFrame.setVisible(false);
						new mainFrame().setVisible(true);
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
}
