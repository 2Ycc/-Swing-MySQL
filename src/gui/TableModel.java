package gui;


import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private String[] columnNames;  //用来显示在表格的第一行的标题
    private String[][] messages;  //用来显示在表格里面的内容

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public void setMessages(String[][] messages) {
        this.messages = messages;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public String[][] getMessages() {
        return messages;
    }

    // 返回表格共有多少行
    public int getRowCount() {
        // TODO Auto-generated method stub
        return messages.length;
    }

    // 返回表格共有多少列
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return columnNames.length;
    }


    // 获取每一列的名称
    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return columnNames[columnIndex];
    }

    // 单元格是否可以修改
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    // 每一个单元格里的内容
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        return messages[rowIndex][columnIndex];
    }

}
