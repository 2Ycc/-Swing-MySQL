package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import DAO.courseDAO;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deleteCourseDialog extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	String cno = null;

	//删除课程
	public boolean deleteCourse(String cno) throws Exception {
		if(cno.length()<1 ) {
			JOptionPane.showMessageDialog(this,"课程号不能为空！");
			return false;
		}
		courseDAO course = new courseDAO();
		if(course.delete(cno)) {
			JOptionPane.showMessageDialog(this,"课程删除成功！");
			return true;
		}			
		else
			JOptionPane.showMessageDialog(this,"课程删除失败，请检查课程号是否正确！");
		return false;
	}
	
	public deleteCourseDialog() {
		setTitle("\u5220\u9664\u8BFE\u7A0B");
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
		lblNewLabel.setBounds(29, 55, 60, 15);
		
		//删除按钮
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.setBounds(89, 114, 69, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cno = textField.getText();
				try {
					if( deleteCourse(cno) ) {
						dispose();
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
