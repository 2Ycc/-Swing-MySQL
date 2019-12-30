package gui;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.studentDAO;
import DAO.userDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class loginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private String id = null;
	private String password = null;
	JComboBox<Object> comboBox = new JComboBox<Object>();
	String identify = "管理员";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginGUI frame = new loginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//检查输入信息是否为空
	public boolean checkNull( String id, String pwd ) {
		if(id.length()<1 || pwd.length()<1 ) {
			JOptionPane.showMessageDialog(null,"ID与密码不能为空！");
			return false;
		}
		return true;
	}
	
	//登录
	public void login( String id, String password ) throws Exception {
		boolean istrue = false;
		userDAO log = new userDAO();
		try {
			istrue = log.LoginCheck(id, password);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if(istrue) {
			mainFrame mainFrame = new mainFrame();
			mainFrame.setVisible(true);
			dispose();
		}else{
			JOptionPane.showMessageDialog(null,"用户名或密码错误！","登陆失败",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//学生登录（暂时不用）
	public void studentlogin( String id, String password ) throws Exception {
		boolean istrue = false;
		studentDAO log = new studentDAO();
		try {
			istrue = log.LoginCheck(id, password);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if(istrue) {
			studentFrame studentFrame = new studentFrame(id);
			studentFrame.setVisible(true);
			dispose();
		}else{
			JOptionPane.showMessageDialog(null,"�û������������","��Ϣ",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	/**
	 * Create the frame.
	 */
	public loginGUI() {
		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 350, 576, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//登录按钮
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				identify = (String) comboBox.getSelectedItem();
				id = textField.getText();
				password = String.valueOf(passwordField.getPassword());
				switch (identify) {
				case "管理员":
					if( checkNull(id, password) )
					try {
						login(id, password);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					break;
					
				case "学生":
					if( checkNull(id, password) )
					try {
						studentlogin(id, password);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					break;
				}		
			}
		});
		btnNewButton.setBounds(176, 247, 93, 35);
		contentPane.add(btnNewButton);
		
		//注册按钮
		JButton button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int iden = 0;
//				if (identify.equals("����Ա")) {
//					iden = 1;
//				}
				registerGUI register = new registerGUI();
				register.setVisible(true);
			}
		});
		button.setBounds(306, 247, 93, 35);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setFont(new Font("����", Font.PLAIN, 16));
		textField.setBounds(176, 129, 223, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		comboBox.setMaximumRowCount(4);
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"\u7BA1\u7406\u5458", "\u5B66\u751F"}));
		comboBox.setSelectedIndex(0);
		comboBox.setToolTipText("");
		comboBox.setBounds(176, 91, 223, 28);
		contentPane.add(comboBox);		
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("����", Font.PLAIN, 16));
		passwordField.setBounds(176, 182, 223, 35);
		contentPane.add(passwordField);
		
		JLabel lblQeqew = new JLabel("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblQeqew.setHorizontalAlignment(SwingConstants.CENTER);
		lblQeqew.setFont(new Font("����", Font.PLAIN, 36));
		lblQeqew.setBounds(101, 27, 373, 46);
		contentPane.add(lblQeqew);
		
		JLabel lblNewLabel = new JLabel("\u7528 \u6237 \u540D\uFF1A");
		lblNewLabel.setBounds(110, 140, 60, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6    \u7801\uFF1A");
		lblNewLabel_1.setBounds(110, 190, 60, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8EAB    \u4EFD\uFF1A");
		lblNewLabel_2.setBounds(110, 98, 60, 15);
		contentPane.add(lblNewLabel_2);
	}
}
