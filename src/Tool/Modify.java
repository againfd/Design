package Tool;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.ConnectionSql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
/**
 * 
 * 修改客户信息
 *
 */
public class Modify extends JFrame {

	private JPanel contentPane;
	private JTextField txtAge;
	private JTextField txtCje;
	private JTextField txtTel;
	private JTextField txtAddress;
	private JTextField txtBh;
	private JTextField txtNum;

	/**
	 * Launch the application.
	 */
//	 public static void main(String[] args) {
//	 EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			Modify frame = new Modify();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	 });
//	 }

	/**
	 * Create the frame.
	 */
	public Modify() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Modify.class.getResource("/images/o.jpg")));
		setTitle("修改客户信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("请输入需要修改的客户的信息：");
		lblNewLabel.setBounds(30, 10, 208, 15);
		contentPane.add(lblNewLabel);

		JLabel lblAge = new JLabel("年 龄：");
		lblAge.setBounds(86, 40, 70, 15);
		contentPane.add(lblAge);

		txtAge = new JTextField();
		txtAge.setBounds(150, 40, 104, 21);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("商品编号：");
		lblNewLabel_1.setBounds(86, 79, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		txtBh = new JTextField();
		txtBh.setBounds(150, 76, 104, 21);
		contentPane.add(txtBh);
		txtBh.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("商品数量：");
		lblNewLabel_2.setBounds(86, 118, 70, 15);
		contentPane.add(lblNewLabel_2);
		
		txtNum = new JTextField();
		txtNum.setBounds(150, 115, 104, 21);
		contentPane.add(txtNum);
		txtNum.setColumns(10);

		JLabel lblCje = new JLabel("成交额：");
		lblCje.setBounds(86, 158, 54, 15);
		contentPane.add(lblCje);

		txtCje = new JTextField();
		txtCje.setBounds(150, 155, 104, 21);
		contentPane.add(txtCje);
		txtCje.setColumns(10);

		JLabel lblTel = new JLabel("手机号：");
		lblTel.setBounds(86, 189, 54, 15);
		contentPane.add(lblTel);

		txtTel = new JTextField();
		txtTel.setBounds(149, 186, 105, 21);
		contentPane.add(txtTel);
		txtTel.setColumns(10);

		JLabel lblAddress = new JLabel("地 址：");
		lblAddress.setBounds(86, 225, 54, 15);
		contentPane.add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setBounds(150, 222, 106, 21);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);

		JButton btnNewButton = new JButton("修 改");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String age = txtAge.getText();
				String cje = txtCje.getText();
				String tel = txtTel.getText();
				String address = txtAddress.getText();
				String bh=txtBh.getText();
				String num=txtNum.getText();
				File file=new File("d:\\javaDemo\\test.txt");
				InputStream in=null;
				byte[] data=new byte[1024];
				try {
					in=new FileInputStream(file);
					in.read(data);
				}catch(Exception k) {
					k.printStackTrace();
				}
				
				ConnectionSql cts = new ConnectionSql();
				String sql = String.format("update cs set age=%s,tele='%s',address='%s' where xm='%s'",txtAge.getText(),txtTel.getText(),txtAddress.getText(),new String(data));
				String sql1=String.format("update goods set bh=%s,num=%s,cje=%s where xm='%s'",txtBh.getText(),txtNum.getText(),txtCje.getText(),new String(data));
				try {
					Connection conn = cts.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
					PreparedStatement pstmt1 = conn.prepareStatement(sql1);
					pstmt.executeUpdate();
					pstmt1.executeUpdate();
				} catch (Exception l) {
					l.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "修改客户成功！");
				}
		});
		btnNewButton.setBounds(312, 221, 93, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
