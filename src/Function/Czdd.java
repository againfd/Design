package Function;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Tool.Bhcz;
import Tool.Xmcz;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.awt.event.ActionEvent;

public class Czdd extends JFrame {

	private JPanel contentPane;
	private JTextField txtXm;
	private JTextField txtBh;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Czdd frame = new Czdd();
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
	public Czdd() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("����������");
		lblNewLabel.setBounds(134, 20, 122, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("������������");
		lblNewLabel_1.setBounds(38, 56, 86, 15);
		contentPane.add(lblNewLabel_1);
		
		txtXm = new JTextField();
		txtXm.setBounds(134, 53, 122, 21);
		contentPane.add(txtXm);
		txtXm.setColumns(10);
		
		JButton btnNewButton = new JButton("�� ��");
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
				Xmcz dbs=new Xmcz();
				dbs.run();
			}
		});
		btnNewButton.setBounds(299, 52, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("����Ʒ��Ų���");
		lblNewLabel_2.setBounds(134, 119, 93, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("�������ţ�");
		lblNewLabel_3.setBounds(41, 165, 83, 15);
		contentPane.add(lblNewLabel_3);
		
		txtBh = new JTextField();
		txtBh.setBounds(135, 164, 119, 21);
		contentPane.add(txtBh);
		txtBh.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("�� ��");
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
				Bhcz dbs=new Bhcz();
				dbs.run();
			}
		});
		btnNewButton_1.setBounds(303, 163, 93, 23);
		contentPane.add(btnNewButton_1);
	}
}
