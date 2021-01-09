package Tool;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DataBase.ConnectionSql;
import DataBase.Customer;
import java.awt.Toolkit;

public class DtSearch extends JFrame {
	
	private JPanel contentPane;
	private Vector<String> titles;
	private JTable table;// ������
	private DefaultTableModel model;// ����������ģ��
	private static Vector<Vector> bigList ; // �󼯺ϣ�������ȡ����
	private static Vector<Vector> bigList1;
	private int recordCount; // �ܼ�¼����
	private Vector<Vector> smallList = new Vector<Vector>(); // С���ϣ����ظ�����������

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DtSearch frame = new DtSearch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
//		});
//	}

	/**
	 * Create the frame.
	 * @return 
	 */
	
	public Vector<Vector> getData() {
		
		File file=new File("d:\\javaDemo\\test.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String datas=br.readLine();
		ConnectionSql cts = new ConnectionSql();
			bigList=Customer.getSelectAll("select * from cs where tele='"+datas+"'");// ���ò�ѯ���ݿ�ķ������������е���
		try {
			Connection conn = cts.getConnection();
			Statement stmt=conn.createStatement();
			
		} catch (Exception l) {
			l.printStackTrace();
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bigList;
	}
	
	public DtSearch() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DtSearch.class.getResource("/images/o.jpg")));
		setTitle("��ѯ���");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// ���ù������
		JScrollPane scrollPane = new JScrollPane();// �����������
		scrollPane.setBounds(27, 21, 382, 271);// ���ô�С��λ��
		contentPane.add(scrollPane);// �����������뵽���������
		
		titles=new Vector<String>();
		Collections.addAll(titles,"����","�Ա�","����","�ֻ���","��ַ");
		
		
		Vector<Vector> stuInfo = getData();//��ȡ����
		model = new DefaultTableModel(stuInfo, titles);
		table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������

		scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
		
		
	}

}
