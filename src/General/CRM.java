package General;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Tool.DbSelect;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class CRM extends JFrame {

	private JPanel contentPane;
	private JLabel lblZh;
	private JLabel lblMm;
	private JPasswordField pwdMm;
	private JTextField txtZh;
	private JButton btnLog;
	private JButton btnRegister;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRM frame = new CRM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public CRM() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CRM.class.getResource("/images/o.jpg")));
		setTitle("�ͻ���ϵ����ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblZh = new JLabel("�� �ţ�");
		lblZh.setBounds(70, 52, 54, 15);
		contentPane.add(lblZh);
		
		txtZh = new JTextField();
		txtZh.setBounds(121, 49, 89, 21);
		contentPane.add(txtZh);
		txtZh.setColumns(10);
		
		lblMm = new JLabel("�� �룺");
		lblMm.setBounds(70, 101, 54, 15);
		contentPane.add(lblMm);
		
		pwdMm = new JPasswordField();
		pwdMm.setBounds(121, 98, 89, 21);
		contentPane.add(pwdMm);
		
		btnLog = new JButton("�� ¼");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String count=txtZh.getText();
				String password=pwdMm.getText();
				
				if(password.equals(DbSelect.select(count).trim())) {
					Demo log=new Demo();
					log.run();
				}else {
				JOptionPane.showMessageDialog(null, "������˺Ż����벻�ԣ�");
			}
			}
		});
		btnLog.setBounds(44, 163, 93, 23);
		contentPane.add(btnLog);
		
		btnRegister = new JButton("ע ��");
		btnRegister.setBounds(186, 163, 93, 23);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CRM.class.getResource("/images/bjt.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);
		
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Register res = new Register();
				res.run();
			}
			
		});
	}
}
