package Function;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField txtXm;
	private JTextField txtXb;
	private JTextField txtAge;
	private JTextField txtAddress;
	private JTextField txtTel;
	private JTextField txtCje;
	private JLabel lblNewLabel;
	private JTextField txtBh;
	private JTextField txtNum;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
//		});
//	}

	/**
	 *���ɿ����ӿͻ���Ϣ��ͼ�ν���
	 */
	public Add() {
		setTitle("���ӿͻ���Ϣ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblXm = new JLabel("������ͻ�������");
		lblXm.setBounds(87, 10, 125, 15);
		contentPane.add(lblXm);
		
		txtXm = new JTextField();
		txtXm.setBounds(198, 7, 101, 21);
		contentPane.add(txtXm);
		txtXm.setColumns(10);
		
		JLabel lblXb = new JLabel("������ͻ��Ա�");
		lblXb.setBounds(87, 35, 142, 15);
		contentPane.add(lblXb);
		
		txtXb = new JTextField();
		txtXb.setBounds(198, 35, 101, 21);
		contentPane.add(txtXb);
		txtXb.setColumns(10);
		
		JLabel lblAge = new JLabel("������ͻ����䣺");
		lblAge.setBounds(84, 70, 142, 15);
		contentPane.add(lblAge);
		
		txtAge = new JTextField();
		txtAge.setBounds(198, 67, 101, 21);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		JLabel lblAddress = new JLabel("������ͻ���ַ��");
		lblAddress.setBounds(87, 191, 142, 15);
		contentPane.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(197, 191, 102, 21);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblTel = new JLabel("������ͻ��ֻ��ţ�");
		lblTel.setBounds(75, 225, 154, 15);
		contentPane.add(lblTel);
		
		txtTel = new JTextField();
		txtTel.setBounds(198, 222, 101, 21);
		contentPane.add(txtTel);
		txtTel.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("��������Ʒ������");
		lblNewLabel_1.setBounds(87, 148, 99, 15);
		contentPane.add(lblNewLabel_1);
		
		txtNum = new JTextField();
		txtNum.setBounds(198, 145, 101, 21);
		contentPane.add(txtNum);
		txtNum.setColumns(10);
		
		JLabel lblCje = new JLabel("��������ͻ��ĳɽ��");
		lblCje.setBounds(52, 267, 177, 15);
		contentPane.add(lblCje);
		
		txtCje = new JTextField();
		txtCje.setBounds(198, 264, 101, 21);
		contentPane.add(txtCje);
		txtCje.setColumns(10);
		
		lblNewLabel = new JLabel("��������Ʒ��ţ�");
		lblNewLabel.setBounds(85, 106, 101, 15);
		contentPane.add(lblNewLabel);
		
		txtBh = new JTextField();
		txtBh.setBounds(197, 100, 101, 21);
		contentPane.add(txtBh);
		txtBh.setColumns(10);
		
		JButton btnAdd = new JButton("�� ��");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==btnAdd) {
					String xm=txtXm.getText();
					String xb=txtXb.getText();
					String age=txtAge.getText();
					String bh=txtBh.getText();
					String num=txtNum.getText();
					String cje=txtCje.getText();
					String tele=txtTel.getText();
					String address=txtAddress.getText();
					ConnectionSql dbcs = new ConnectionSql();// ʹ��1�ж�����������ݿ����
					String sql = "insert into cs(xm,xb,age,tele,address) values(?,?,?,?,?)";// ʹ��ռλ������������
					String sqls="insert into goods(xm,bh,num,cje) values(?,?,?,?)";
					try{Connection conn = dbcs.getConnection();// ��ȡ���ݿ��
					    PreparedStatement pstmt=conn.prepareStatement(sql);
					    PreparedStatement pstmt1=conn.prepareStatement(sqls);
						pstmt.setString(1, txtXm.getText());
						pstmt.setString(2, txtXb.getText());
						pstmt.setString(3, txtAge.getText());
						pstmt.setString(4, txtTel.getText());
						pstmt.setString(5, txtAddress.getText());
						
						pstmt1.setString(1, txtXm.getText());
						pstmt1.setString(2,txtBh.getText());
						pstmt1.setString(3,txtNum.getText());
						pstmt1.setString(4, txtCje.getText());
						pstmt.executeUpdate();
						pstmt1.executeUpdate();
					} catch (SQLException k) {
						// TODO Auto-generated catch block
						k.printStackTrace();
					} // ʵ����PreparedStatement
					JOptionPane.showMessageDialog(null, "�ͻ����ӳɹ�!");
				}
			}
		});
		btnAdd.setBounds(341, 283, 93, 23);
		contentPane.add(btnAdd);
		
	}
}
