package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.scoreDAO;
import bean.score;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class updateScoreDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	
	private JButton button;
	private JButton button_1;
	String sno = null;
	String sname = null;
	String cno = null;
	String cname = null;
	String sscore = null;
	String rescore = null;

	private JTextField textField_4;
	private JTextField textField;
	private JLabel label_4;
	private JLabel lblNewLabel;
	private JLabel label_5;
	private JLabel label_6;
	
	//更新成绩
	public boolean updateScore(String sno, String cno, String sscore, String rescore) throws SQLException {
		if(sscore.length()<1 || rescore.length()<1 ) {
			JOptionPane.showMessageDialog(this,"信息不能为空");
			return false;
		}
		scoreDAO scoreDAO = new scoreDAO();
		boolean istrue = scoreDAO.update(sno,cno,sscore,rescore);
		if(istrue) {
			JOptionPane.showMessageDialog(this,"更新成绩成功！");
			return true;
		}else 
			JOptionPane.showMessageDialog(this,"更新成绩失败！");
		return false;
	}
	
	
	//查询课程
	public boolean selectScore( String sno ,String cno) throws Exception {
		if(cno.length()<1 || sno.length()<1) {	
			JOptionPane.showMessageDialog(this,"学号与课程号不能为空！");
			return false;
		}
		scoreDAO scoreDAO = new scoreDAO();
		score score = new score();
		score = scoreDAO.select(sno,cno);
		if(score!=null) {
			this.sno = score.getSno();
			this.sname = score.getSname();
			this.cno = score.getCno();
			this.cname = score.getCname();
			this.sscore = score.getSscore();
			this.rescore = score.getRescore();
			return true;
		}			
		else
			JOptionPane.showMessageDialog(this,"查无此课程成绩信息！");
		return false;
	}
	
	
	public updateScoreDialog() {
		setTitle("\u4FEE\u6539\u6210\u7EE9");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(850, 400, 327, 256);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(89, 48, 173, 30);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setBounds(40, 55, 48, 15);
		
		//��ѯ
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setBounds(89, 172, 69, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sno = textField.getText();
				cno = textField_3.getText();
				try {
					if( selectScore(sno,cno) ) {
						updateDialog();
					}		
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		//����
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.setBounds(193, 172, 69, 23);
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
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(89, 109, 173, 30);
		contentPane.add(textField_3);
		
		JLabel label = new JLabel("\u8BFE\u7A0B\u53F7\uFF1A");
		label.setBounds(29, 116, 59, 15);
		contentPane.add(label);		
		
		
		
}
	

	public void updateDialog() {
		setTitle("\u4FEE\u6539\u6210\u7EE9");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setBounds(800, 350, 431, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField_2 = new JTextField();
		textField_2.setBounds(115, 186, 206, 34);
		textField_2.setColumns(10);
		textField_2.setText(sscore);
		
		textField_4 = new JTextField();
		textField_4.setText((String) null);
		textField_4.setColumns(10);
		textField_4.setBounds(115, 240, 206, 34);
		textField_4.setText(rescore);	
		
		JLabel label = new JLabel("\u5B66\u53F7\uFF1A");
		label.setBounds(67, 35, 47, 15);
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setBounds(67, 84, 47, 15);
		
		JLabel label_2 = new JLabel("\u8BFE\u7A0B\u540D\uFF1A");
		label_2.setBounds(54, 139, 59, 15);
		
		JLabel label_3 = new JLabel("\u6210\u7EE9\uFF1A");
		label_3.setBounds(67, 195, 47, 15);
		
		button = new JButton("\u4FEE\u6539");
		button.setBounds(115, 294, 73, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sno = lblNewLabel.getText();
				sname = label_5.getText();
				cname = label_6.getText();
				sscore = textField_2.getText();
				rescore = textField_4.getText();
				try {
					if( updateScore(sno,cno,sscore,rescore) ) {
						dispose();
					}		
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		button_1 = new JButton("\u8FD4\u56DE");
		button_1.setBounds(236, 294, 73, 23);
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
		contentPane.add(textField_2);
		contentPane.add(textField_4);
		contentPane.add(button);
		contentPane.add(button_1);
			
		label_4 = new JLabel("\u8865\u8003\u6210\u7EE9\uFF1A");
		label_4.setBounds(42, 249, 67, 15);
		contentPane.add(label_4);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(115, 25, 206, 34);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText(sno);
		
		label_5 = new JLabel("");
		label_5.setBounds(115, 74, 206, 34);
		contentPane.add(label_5);
		label_5.setText(sname);
		
		label_6 = new JLabel("");
		label_6.setBounds(115, 128, 206, 34);
		contentPane.add(label_6);
		label_6.setText(cname);
	}
}
