package Function;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Tool.Page;
import java.awt.Toolkit;
/**
 * 
 * 显示订单信息
 *
 */
public class Detail extends JFrame {

	private JPanel contentPane;// 定义窗体内容面板，放置各组件
	private JTable table;// 定义表格
	private JTextField txtKey;//定义查找关键字文本框
	private DefaultTableModel model;// 定义表格数据模型
	private TableRowSorter sorter;//定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;//设置排序规则
	
	private Vector<String> titles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Detail frame = new Detail();// 实例化窗体
		frame.setLocationRelativeTo(null);// 窗体居中
		frame.setVisible(true);// 窗体可见
	}
	
	public static void run() {
		try {
			Detail frame = new Detail();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Detail() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Detail.class.getResource("/images/o.jpg")));
		setTitle("显示订单信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 设置滚动面板
		JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
		scrollPane.setBounds(10, 10, 414, 282);// 设置大小与位置
		contentPane.add(scrollPane);// 将滚动面板加入到内容面板中

		// 使用动态数组数据（列标题与行数据）
		titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "姓名", "编号","数量","成交额");
		Vector<Vector> stuInfo = new Page().getPData();//获取第一页的数据

//		使用静态数据创建DefaultTableModel数据模型
          model = new DefaultTableModel(stuInfo, titles) ;
		table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格

		scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示
		
		
		JButton btnPre = new JButton("上一页");
		btnPre.addActionListener(new ActionListener() {//上一页单击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new Page().prefPage(),titles);//设置数据模型中的数据为上一页内容
				table.setModel(model);//设置表格的数据模型
				
			}
		});
		btnPre.setBounds(44, 302, 95, 25);
		contentPane.add(btnPre);
		
		JButton btnNext = new JButton("下一页");
		btnNext.addActionListener(new ActionListener() {//下一页单击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new Page().laterPage(),titles);//设置数据模型中的数据为下一页内容
				table.setModel(model);//设置表格的数据模型
			}
		});
		btnNext.setBounds(149, 302, 95, 25);
		contentPane.add(btnNext);
		
		JLabel lblMsg = new JLabel("每页显示：");
		lblMsg.setBounds(254, 307, 87, 15);
		contentPane.add(lblMsg);
		
		JComboBox comboBox = new JComboBox(new Integer[] {3,5,10,15,20,1000});
		comboBox.addItemListener(new ItemListener() {//页数下拉框选择改变事件
			public void itemStateChanged(ItemEvent e) {
				int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//获取下拉框所选的值
				Page pcl=new Page();
				pcl.setCountPer(pageSize);//设置每页显示记录条数
				model=new DefaultTableModel(pcl.getPData(),titles);//设置数据模型
				table.setModel(model);//设置表格数据模型
			}
		});
		comboBox.setSelectedIndex(1);//设置下拉框默认值
		comboBox.setBounds(318, 303, 55, 23);
		contentPane.add(comboBox);
	}
	}

