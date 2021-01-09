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
import java.awt.Toolkit;
/**
 * 
 * ע�����Ա
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/images/o.jpg")));
		setTitle("ע���˺�");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblZh = new JLabel("�������� �ţ�");
		lblZh.setBounds(74, 53, 109, 15);
		contentPane.add(lblZh);

		txtZh = new JTextField();
		txtZh.setBounds(162, 49, 93, 21);
		contentPane.add(txtZh);
		txtZh.setColumns(10);

		lblMm = new JLabel("�������� �룺");
		lblMm.setBounds(74, 90, 90, 15);
		contentPane.add(lblMm);

		txtMm = new JTextField();
		txtMm.setBounds(162, 86, 93, 21);
		contentPane.add(txtMm);
		txtMm.setColumns(10);

		lblMm1 = new JLabel("��ȷ���� �룺");
		lblMm1.setBounds(74, 124, 86, 15);
		contentPane.add(lblMm1);

		txtMm1 = new JTextField();
		txtMm1.setBounds(162, 122, 93, 21);
		contentPane.add(txtMm1);
		txtMm1.setColumns(10);

		btnRegister = new JButton("ע ��");
		btnRegister.setBounds(76, 177, 93, 23);
		contentPane.add(btnRegister);

		btnCancel = new JButton("ȡ ��");
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

		btnRegister.addActionListener(new ActionListener() {// �������а�ť�����¼�
			public void actionPerformed(ActionEvent e) {
					if (e.getSource()==btnRegister) {
						String zh=txtZh.getText();
						String mm=txtMm.getText();
						String mm1=txtMm1.getText();
						ConnectionSql dbcs = new ConnectionSql();// ʹ��1�ж�����������ݿ����
						String sql = "insert into manage(zh,mm) values(?,?)";// ʹ��ռλ������������
						try{Connection conn = dbcs.getConnection();// ��ȡ���ݿ��
						    PreparedStatement pstmt=conn.prepareStatement(sql);
							pstmt.setString(1, txtZh.getText());
							pstmt.setString(2, txtMm.getText());
							// pstmt.addBatch();
							pstmt.executeUpdate();
						} catch (SQLException k) {
							// TODO Auto-generated catch block
							k.printStackTrace();
						} // ʵ����PreparedStatement
						JOptionPane.showMessageDialog(null, "ע��ɹ�!");
					} 
//					else {
//						JOptionPane.showMessageDialog(null, "ע��ʧ��!");
//					}
				}
		});
	}


	public boolean CheckInputZh() {
		String zh = txtZh.getText();
		if (zh.length() == 0) {
			lblMsgZh.setText("�˺Ų���Ϊ��");
			return false;
		}
		return true;
	}

	public boolean CheckInputMm() {
		String mm = txtMm.getText();
		if (mm.length() == 0) {
			lblMsgMm.setText("���벻��Ϊ��");
			return false;
		}
		return true;
	}

	public boolean CheckInputMm1() {
		String mm1 = txtMm.getText();
		if (mm1.length() == 0) {
			lblMsgMm1.setText("ȷ�����벻��Ϊ��");
			return false;
		}
		return true;
	}
}
