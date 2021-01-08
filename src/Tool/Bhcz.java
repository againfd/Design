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
import DataBase.Goods;
/**
 * 
 * 订单编号查找
 *
 */
public class Bhcz extends JFrame {

	/**
	 * Launch the application.
	 */
	private JPanel contentPane;
	private Vector<String> titles;
	private JTable table;// 定义表格
	private DefaultTableModel model;// 定义表格数据模型
	private static Vector<Vector> bigList ; // 大集合，从外界获取数据
	private static Vector<Vector> bigList1;
	private int recordCount; // 总记录条数
	private Vector<Vector> smallList = new Vector<Vector>(); // 小集合，返回给调用它的类

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bhcz frame = new Bhcz();
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
		if(bigList==null) {
			bigList=Goods.getAll("select * from goods where bh='"+datas+"'");// 调用查询数据库的方法，返回所有的行
		}
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
	
	public Bhcz() {
		setTitle("查询结果");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// 设置滚动面板
		JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
		scrollPane.setBounds(27, 21, 382, 271);// 设置大小与位置
		contentPane.add(scrollPane);// 将滚动面板加入到内容面板中
		
		titles=new Vector<String>();
		Collections.addAll(titles,"姓名","编号","数量","成交额");
		
		
		Vector<Vector> stuInfo = getData();//获取数据
		model = new DefaultTableModel(stuInfo, titles);
		table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格

		scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示
		
		
	}

}
