package Function;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import General.CRM;
import Tool.ExcelExporter;
import Tool.PageController;
import java.awt.Toolkit;
/**
 * 
 * 显示客户信息
 *
 */
public class Display extends JFrame {
	
		private JPanel contentPane;// 定义窗体内容面板，放置各组件
		private JTable table;// 定义表格
		private JTextField txtKey;//定义查找关键字文本框
		private DefaultTableModel model;// 定义表格数据模型
		private TableRowSorter sorter;//定义排序器
		private ArrayList<RowSorter.SortKey> sortKeys;//设置排序规则
		
		private Vector<String> titles;

		public static void main(String[] args) {
			Display frame = new Display();// 实例化窗体
			frame.setLocationRelativeTo(null);// 窗体居中
			frame.setVisible(true);// 窗体可见
		}
		
		public static void run() {
			try {
				Display frame = new Display();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * 定义构造方法创建窗体及组件.
		 */
		public Display() {
			setIconImage(Toolkit.getDefaultToolkit().getImage(Display.class.getResource("/images/o.jpg")));
			setTitle("显示结果");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置窗体关闭按钮
			setBounds(100, 100, 450, 403);// 设置窗体位置与大小
			contentPane = new JPanel();// 实例化内容面板
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置面板边框
			contentPane.setLayout(null);// 设置面板布局为绝对布局
			setContentPane(contentPane);// 将窗体默认面板

			// 设置滚动面板
			JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
			scrollPane.setBounds(10, 10, 414, 282);// 设置大小与位置
			contentPane.add(scrollPane);// 将滚动面板加入到内容面板中

			// 使用动态数组数据（列标题与行数据）
			titles = new Vector<String>();// 定义动态数组表示表格标题
			Collections.addAll(titles, "姓名", "性别", "年龄","手机号","地址");
			Vector<Vector> stuInfo = new PageController().getPaegData();//获取第一页的数据

//			使用静态数据创建DefaultTableModel数据模型
              model = new DefaultTableModel(stuInfo, titles);
			table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格

			scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示
			
			
			JButton btnPre = new JButton("上一页");
			btnPre.addActionListener(new ActionListener() {//上一页单击事件
				@Override
				public void actionPerformed(ActionEvent e) {
					model=new DefaultTableModel(new PageController().prePage(),titles);//设置数据模型中的数据为上一页内容
					table.setModel(model);//设置表格的数据模型
					
				}
			});
			btnPre.setBounds(44, 302, 95, 25);
			contentPane.add(btnPre);
			
			JButton btnNext = new JButton("下一页");
			btnNext.addActionListener(new ActionListener() {//下一页单击事件
				@Override
				public void actionPerformed(ActionEvent e) {
					model=new DefaultTableModel(new PageController().nextPage(),titles);//设置数据模型中的数据为下一页内容
					table.setModel(model);//设置表格的数据模型
				}
			});
			btnNext.setBounds(149, 302, 95, 25);
			contentPane.add(btnNext);
			
			JLabel lblMsg = new JLabel("每页显示：");
			lblMsg.setBounds(254, 307, 87, 15);
			contentPane.add(lblMsg);
			
			JComboBox comboBox = new JComboBox(new Integer[] {3,5,10,15,20,1000,10000});
			comboBox.addItemListener(new ItemListener() {//页数下拉框选择改变事件
				public void itemStateChanged(ItemEvent e) {
					int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//获取下拉框所选的值
					PageController pcl=new PageController();
					pcl.setCountPerpage(pageSize);//设置每页显示记录条数
					model=new DefaultTableModel(pcl.getPaegData(),titles);//设置数据模型
					table.setModel(model);//设置表格数据模型
				}
			});
			comboBox.setSelectedIndex(1);//设置下拉框默认值
			comboBox.setBounds(318, 303, 55, 23);
			contentPane.add(comboBox);
			
			JButton btnNewButton = new JButton("导出");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ExcelExporter ex=new ExcelExporter();
					File file=new File("d:/客户信息.xls");
					if(!file.exists()) {
						try {
							file.createNewFile();
						}catch(IOException k) {
							k.printStackTrace();
						}
					}
					try {
						ex.exportTable(table, file);
					}catch(IOException l) {
						l.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "导出成功！");
				}
			});
			btnNewButton.setBounds(341, 331, 93, 23);
			contentPane.add(btnNewButton);
		}
}
