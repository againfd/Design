package Function;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import java.sql.Statement;
import java.util.Collections;
import java.util.Vector;
/**
 * 
 * ���ҿͻ���Ϣ
 *
 */
public class Search extends JFrame {

	private JPanel contentPane;
	private JTextField txtKey;//������ҹؼ����ı���
	private Vector<String> titles;
	private JTable table;// ������
	private DefaultTableModel model;// ����������ģ��
	private static Vector<Vector> bigList ; // �󼯺ϣ�������ȡ����
	private int recordCount; // �ܼ�¼����
	private Vector<Vector> smallList = new Vector<Vector>(); // С���ϣ����ظ�����������
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
	public Search() {
		setTitle("��ѯ�ͻ���Ϣ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�������ֲ�ѯ");
		lblNewLabel.setBounds(129, 24, 95, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblKey = new JLabel("������ �֣�");
		lblKey.setBounds(29, 80, 79, 15);
		contentPane.add(lblKey);
		
		txtKey = new JTextField();
		txtKey.setBounds(129, 77, 119, 21);
		contentPane.add(txtKey);
		txtKey.setColumns(10);
		
		//������Ұ�ť
				JButton btnFind = new JButton("����");
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
						DbSearch dbs=new DbSearch();
						dbs.run();
							
					}
				});
				btnFind.setBounds(313, 75, 95, 25);
				contentPane.add(btnFind);
				
				JLabel lblNewLabel_1 = new JLabel("�����ֻ��Ų�ѯ");
				lblNewLabel_1.setBounds(129, 133, 95, 15);
				contentPane.add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("�����ֻ��ţ�");
				lblNewLabel_2.setBounds(29, 184, 93, 15);
				contentPane.add(lblNewLabel_2);
				
				textField = new JTextField();
				textField.setBounds(129, 183, 123, 21);
				contentPane.add(textField);
				textField.setColumns(10);
				
				JButton btnNewButton = new JButton("�� ��");
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
						DtSearch dts=new DtSearch();
						dts.run();
					}
				});
				btnNewButton.setBounds(312, 181, 93, 23);
				contentPane.add(btnNewButton);
				
				
	}
}
