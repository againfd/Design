package Function;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.ConnectionSql;
import Tool.Bhcz;
import Tool.DbDelete;
import Tool.Xmcz;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Czdd extends JFrame {

	private JPanel contentPane;
	private JTextField txtXm;
	private JTextField txtBh;

	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					Czdd frame = new Czdd();
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
	public Czdd() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Czdd.class.getResource("/images/o.jpg")));
		setTitle("查找方式");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("按姓名查找");
		lblNewLabel.setBounds(134, 20, 122, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("请输入姓名：");
		lblNewLabel_1.setBounds(38, 56, 86, 15);
		contentPane.add(lblNewLabel_1);
		
		txtXm = new JTextField();
		txtXm.setBounds(134, 53, 122, 21);
		contentPane.add(txtXm);
		txtXm.setColumns(10);
		
		JButton btnNewButton = new JButton("查 找");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String xm=txtXm.getText();
				File file=new File("d:\\javaDemo\\test.txt");
				OutputStream out=null;
				try {
					out=new FileOutputStream(file);
					byte[] data=xm.getBytes();
					out.write(data);
				}catch(Exception k) {
					k.printStackTrace();
				}
				String x=null;
				String sql="select xm from goods";
				ConnectionSql cs=new ConnectionSql();
		        Connection conn=cs.getConnection();
		        String sql1=String.format("Select COUNT(*) from goods where xm='%s'",xm);
		        try {
					PreparedStatement pstmt=conn.prepareStatement(sql1);
					ResultSet rs=pstmt.executeQuery();
					while(rs.next()) {
						x=rs.getString(1);
					}
					if(!x.equals("0")) {
						Xmcz dbs=new Xmcz();
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
		btnNewButton.setBounds(299, 52, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("按商品编号查找");
		lblNewLabel_2.setBounds(134, 119, 93, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("请输入编号：");
		lblNewLabel_3.setBounds(41, 165, 83, 15);
		contentPane.add(lblNewLabel_3);
		
		txtBh = new JTextField();
		txtBh.setBounds(135, 164, 119, 21);
		contentPane.add(txtBh);
		txtBh.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("查 找");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bh=txtBh.getText();
				File file=new File("d:\\javaDemo\\test.txt");
				OutputStream out=null;
				try {
					out=new FileOutputStream(file);
					byte[] data=bh.getBytes();
					out.write(data);
				}catch(Exception k) {
					k.printStackTrace();
				}
				String x=null;
				String sql="select bh from goods";
				ConnectionSql cs=new ConnectionSql();
		        Connection conn=cs.getConnection();
		        String sql1=String.format("Select COUNT(*) from goods where bh='%s'",bh);
		        try {
					PreparedStatement pstmt=conn.prepareStatement(sql1);
					ResultSet rs=pstmt.executeQuery();
					while(rs.next()) {
						x=rs.getString(1);
					}
					if(!x.equals("0")) {
						Bhcz dbs=new Bhcz();
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
		btnNewButton_1.setBounds(303, 163, 93, 23);
		contentPane.add(btnNewButton_1);
	}
}
