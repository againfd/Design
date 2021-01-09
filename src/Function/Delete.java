package Function;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.ConnectionSql;
import Tool.DbDelete;
import Tool.Modify;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					Delete frame = new Delete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public static void main(String[] args) {
				run();
			}


	/**
	 * ɾ���ͻ���Ϣ
	 */
	public Delete() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Delete.class.getResource("/images/o.jpg")));
		setTitle("ɾ���ͻ���Ϣ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("��������Ҫɾ���Ŀͻ������֣�");
		lblNewLabel.setBounds(39, 48, 220, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(127, 103, 129, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("ɾ ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
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
						DbDelete dele=new DbDelete();
						dele.delete(name);
						JOptionPane.showMessageDialog(null, "�ͻ�ɾ���ɹ���");
					}
					else {
						JOptionPane.showMessageDialog(null, "�ÿͻ������ڣ�");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
		});
		btnNewButton.setBounds(271, 186, 93, 23);
		contentPane.add(btnNewButton);
	}
}
