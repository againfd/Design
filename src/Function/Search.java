package Function;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DataBase.ConnectionSql;
import DataBase.Customer;
import Tool.DbSearch;
import Tool.DtSearch;
import Tool.Judge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Vector;
import java.awt.Toolkit;
/**
 * 
 * 查找客户信息
 *
 */
public class Search extends JFrame {

	private JPanel contentPane;
	private JTextField txtKey;//定义查找关键字文本框
	private Vector<String> titles;
	private JTable table;// 定义表格
	private DefaultTableModel model;// 定义表格数据模型
	private static Vector<Vector> bigList ; // 大集合，从外界获取数据
	private int recordCount; // 总记录条数
	private Vector<Vector> smallList = new Vector<Vector>(); // 小集合，返回给调用它的类
	private JTextField textField;

	/**
	 * Launch the application.
	 */
			public static void run() {
				try {
					Search frame = new Search();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public static void main(String[] args) {
				run();
			}

	/**
	 * Create the frame.
	 */
	public Search() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Search.class.getResource("/images/o.jpg")));
		setTitle("查询客户信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("根据名字查询");
		lblNewLabel.setBounds(129, 24, 95, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblKey = new JLabel("输入名 字：");
		lblKey.setBounds(29, 80, 79, 15);
		contentPane.add(lblKey);
		
		txtKey = new JTextField();
		txtKey.setBounds(129, 77, 119, 21);
		contentPane.add(txtKey);
		txtKey.setColumns(10);
		
		//定义查找按钮
				JButton btnFind = new JButton("查找");
				btnFind.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String key=txtKey.getText();
						File file=new File("d:\\javaDemo\\test.txt");
						OutputStream out=null;
						try {
							out=new FileOutputStream(file);
							byte[] data=key.getBytes();
							out.write(data);
						}catch(Exception k) {
							k.printStackTrace();
						}
						String x=null;
						String sql="select xm from cs";
						ConnectionSql cs=new ConnectionSql();
				        Connection conn=cs.getConnection();
				        String sql1=String.format("Select COUNT(*) from cs where xm='%s'",key);
				        try {
							PreparedStatement pstmt=conn.prepareStatement(sql1);
							ResultSet rs=pstmt.executeQuery();
							while(rs.next()) {
								x=rs.getString(1);
							}
							if(!x.equals("0")) {
								DbSearch dbs=new DbSearch();
								dbs.run();
							}
							else {
								JOptionPane.showMessageDialog(null, "该客户不存在！");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnFind.setBounds(313, 75, 95, 25);
				contentPane.add(btnFind);
				
				JLabel lblNewLabel_1 = new JLabel("根据手机号查询");
				lblNewLabel_1.setBounds(129, 133, 95, 15);
				contentPane.add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("输入手机号：");
				lblNewLabel_2.setBounds(29, 184, 93, 15);
				contentPane.add(lblNewLabel_2);
				
				textField = new JTextField();
				textField.setBounds(129, 183, 123, 21);
				contentPane.add(textField);
				textField.setColumns(10);
				
				JButton btnNewButton = new JButton("查 找");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String key=textField.getText();
						File file=new File("d:\\javaDemo\\test.txt");
						OutputStream out=null;
						try {
							out=new FileOutputStream(file);
							byte[] data=key.getBytes();
							out.write(data);
						}catch(Exception k) {
							k.printStackTrace();
						}
						String x=null;
						String sql="select tele from cs";
						ConnectionSql cs=new ConnectionSql();
				        Connection conn=cs.getConnection();
				        String sql1=String.format("Select COUNT(*) from cs where tele='%s'",key);
				        try {
							PreparedStatement pstmt=conn.prepareStatement(sql1);
							ResultSet rs=pstmt.executeQuery();
							while(rs.next()) {
								x=rs.getString(1);
							}
							if(!x.equals("0")) {
								DtSearch dbs=new DtSearch();
								dbs.run();
							}
							else {
								JOptionPane.showMessageDialog(null, "该客户不存在！");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnNewButton.setBounds(312, 181, 93, 23);
				contentPane.add(btnNewButton);
				
				
	}
}
