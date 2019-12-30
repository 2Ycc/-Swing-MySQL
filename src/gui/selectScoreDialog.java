package gui;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.scoreDAO;
import bean.score;

import javax.swing.JTable;
import javax.swing.JScrollPane;


public class selectScoreDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	TableModel tm_score;
	JTable tableCourse; 
	JScrollPane scoreMessage; 
	String[] strScore = {"学号", "姓名","课程号", "课程名", "成绩", "补考成绩"}; 
	String[][] scoreList;
	
	public void gengxin(String[][] scoreList) throws Exception {
		tm_score = new TableModel();  
		tm_score.setColumnNames(strScore);

        contentPane.setLayout(new BorderLayout(0, 0));
        
        tableCourse = new JTable(tm_score);  
        scoreMessage = new JScrollPane(tableCourse);  
        contentPane.add(scoreMessage);
		try {
			tm_score.setMessages(scoreList); //初始化表格数据
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String[][] getscoreList() throws Exception {  //������ѧ����Ϣ���ַ�������ķ�ʽ����
		scoreDAO score = new scoreDAO();
        List<score> list = score.scoreRes();
        String[][] scores = new String[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
        	scores[i][0] = list.get(i).getSno();
        	scores[i][1] = list.get(i).getSname();
        	scores[i][2] = list.get(i).getCno();
        	scores[i][3] = list.get(i).getCname();
        	scores[i][4] = list.get(i).getSscore();
        	scores[i][5] = list.get(i).getRescore();
        }
        return scores;
    }

	public selectScoreDialog() throws Exception {
		setTitle("\u5B66\u751F\u6210\u7EE9");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(800, 350, 480, 320);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//��½ʱ��ʼ����ʾ���
		scoreList = getscoreList();
		gengxin(scoreList);	
			
     }

}
