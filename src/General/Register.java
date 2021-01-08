package General;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.ConnectionSql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
/**
 * 
 * 注册管理员
 *
 */
public class Register extends JFrame {

	private JPanel contentPane;
	private JLabel lblZh;
	private JLabel lblMm;
	private static JTextField txtZh;
	private static JTextField txtMm;
	private JLabel lblMm1;
	private static JTextField txtMm1;
	private JButton btnRegister;
	private JButton btnCancel;
	private JLabel lblMsgZh;
	private JLabel lblMsgMm;
	private JLabel lblMsgMm1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblZh = new JLabel("请输入账 号：");
		lblZh.setBounds(74, 53, 109, 15);
		contentPane.add(lblZh);

		txtZh = new JTextField();
		txtZh.setBounds(162, 49, 93, 21);
		contentPane.add(txtZh);
		txtZh.setColumns(10);

		lblMm = new JLabel("请输入密 码：");
		lblMm.setBounds(74, 90, 90, 15);
		contentPane.add(lblMm);

		txtMm = new JTextField();
		txtMm.setBounds(162, 86, 93, 21);
		contentPane.add(txtMm);
		txtMm.setColumns(10);

		lblMm1 = new JLabel("请确认密 码：");
		lblMm1.setBounds(74, 124, 86, 15);
		contentPane.add(lblMm1);

		txtMm1 = new JTextField();
		txtMm1.setBounds(162, 122, 93, 21);
		contentPane.add(txtMm1);
		txtMm1.setColumns(10);

		btnRegister = new JButton("注 册");
		btnRegister.setBounds(76, 177, 93, 23);
		contentPane.add(btnRegister);

		btnCancel = new JButton("取 消");
		btnCancel.setBounds(235, 177, 93, 23);
		contentPane.add(btnCancel);

		lblMsgZh = new JLabel("");
		lblMsgZh.setBounds(274, 53, 86, 15);
		contentPane.add(lblMsgZh);

		lblMsgMm = new JLabel("");
		lblMsgMm.setBounds(274, 90, 86, 15);
		contentPane.add(lblMsgMm);

		lblMsgMm1 = new JLabel("");
		lblMsgMm1.setBounds(274, 124, 86, 15);
		contentPane.add(lblMsgMm1);

		btnRegister.addActionListener(new ActionListener() {// 窗体类中按钮单击事件
			public void actionPerformed(ActionEvent e) {
					if (e.getSource()==btnRegister) {
						String zh=txtZh.getText();
						String mm=txtMm.getText();
						String mm1=txtMm1.getText();
						ConnectionSql dbcs = new ConnectionSql();// 使用1中定义的连接数据库的类
						String sql = "insert into manage(zh,mm) values(?,?)";// 使用占位符定义插入语句
						try{Connection conn = dbcs.getConnection();// 获取数据库接
						    PreparedStatement pstmt=conn.prepareStatement(sql);
							pstmt.setString(1, txtZh.getText());
							pstmt.setString(2, txtMm.getText());
							// pstmt.addBatch();
							pstmt.executeUpdate();
						} catch (SQLException k) {
							// TODO Auto-generated catch block
							k.printStackTrace();
						} // 实例化PreparedStatement
						JOptionPane.showMessageDialog(null, "注册成功!");
					} 
//					else {
//						JOptionPane.showMessageDialog(null, "注册失败!");
//					}
				}
		});
	}


	public boolean CheckInputZh() {
		String zh = txtZh.getText();
		if (zh.length() == 0) {
			lblMsgZh.setText("账号不能为空");
			return false;
		}
		return true;
	}

	public boolean CheckInputMm() {
		String mm = txtMm.getText();
		if (mm.length() == 0) {
			lblMsgMm.setText("密码不能为空");
			return false;
		}
		return true;
	}

	public boolean CheckInputMm1() {
		String mm1 = txtMm.getText();
		if (mm1.length() == 0) {
			lblMsgMm1.setText("确认密码不能为空");
			return false;
		}
		return true;
	}
}
