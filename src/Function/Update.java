package Function;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.ConnectionSql;
import Tool.DbSearch;
import Tool.Modify;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
/**
 * 
 * 修改客户信息
 *
 */
public class Update extends JFrame {

	private JPanel contentPane;
	static JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
			public static void run() {
				try {
					Update frame = new Update();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public static void main(String[] args) {
				run();
			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Update() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Update.class.getResource("/images/o.jpg")));
		setTitle("修改客户信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入你需要修改的客户的名字：");
		lblNewLabel.setBounds(39, 42, 211, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(135, 107, 131, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("确 认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				File file=new File("d:\\javaDemo\\test.txt");
				OutputStream out=null;
				try {
					out=new FileOutputStream(file);
					//name=textField.getText();
					byte[] data=name.getBytes();
					out.write(data);
				}catch(Exception k) {
					k.printStackTrace();
				}
					String x=null;
					String sql="select xm from cs";
					ConnectionSql cs=new ConnectionSql();
			        Connection conn=cs.getConnection();
			        String sql1=String.format("Select COUNT(*) from cs where xm='%s'",name);
			        try {
						PreparedStatement pstmt=conn.prepareStatement(sql1);
						ResultSet rs=pstmt.executeQuery();
						while(rs.next()) {
							x=rs.getString(1);
						}
						if(!x.equals("0")) {
							Modify mo=new Modify();
							mo.run();
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
		btnNewButton.setBounds(278, 187, 93, 23);
		contentPane.add(btnNewButton);
	}

}
