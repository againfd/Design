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
 * ��ʾ�ͻ���Ϣ
 *
 */
public class Display extends JFrame {
	
		private JPanel contentPane;// ���崰��������壬���ø����
		private JTable table;// ������
		private JTextField txtKey;//������ҹؼ����ı���
		private DefaultTableModel model;// ����������ģ��
		private TableRowSorter sorter;//����������
		private ArrayList<RowSorter.SortKey> sortKeys;//�����������
		
		private Vector<String> titles;

		public static void main(String[] args) {
			Display frame = new Display();// ʵ��������
			frame.setLocationRelativeTo(null);// �������
			frame.setVisible(true);// ����ɼ�
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
		 * ���幹�췽���������弰���.
		 */
		public Display() {
			setIconImage(Toolkit.getDefaultToolkit().getImage(Display.class.getResource("/images/o.jpg")));
			setTitle("��ʾ���");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// ���ô���رհ�ť
			setBounds(100, 100, 450, 403);// ���ô���λ�����С
			contentPane = new JPanel();// ʵ�����������
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �������߿�
			contentPane.setLayout(null);// ������岼��Ϊ���Բ���
			setContentPane(contentPane);// ������Ĭ�����

			// ���ù������
			JScrollPane scrollPane = new JScrollPane();// �����������
			scrollPane.setBounds(10, 10, 414, 282);// ���ô�С��λ��
			contentPane.add(scrollPane);// �����������뵽���������

			// ʹ�ö�̬�������ݣ��б����������ݣ�
			titles = new Vector<String>();// ���嶯̬�����ʾ������
			Collections.addAll(titles, "����", "�Ա�", "����","�ֻ���","��ַ");
			Vector<Vector> stuInfo = new PageController().getPaegData();//��ȡ��һҳ������

//			ʹ�þ�̬���ݴ���DefaultTableModel����ģ��
              model = new DefaultTableModel(stuInfo, titles);
			table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������

			scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
			
			
			JButton btnPre = new JButton("��һҳ");
			btnPre.addActionListener(new ActionListener() {//��һҳ�����¼�
				@Override
				public void actionPerformed(ActionEvent e) {
					model=new DefaultTableModel(new PageController().prePage(),titles);//��������ģ���е�����Ϊ��һҳ����
					table.setModel(model);//���ñ�������ģ��
					
				}
			});
			btnPre.setBounds(44, 302, 95, 25);
			contentPane.add(btnPre);
			
			JButton btnNext = new JButton("��һҳ");
			btnNext.addActionListener(new ActionListener() {//��һҳ�����¼�
				@Override
				public void actionPerformed(ActionEvent e) {
					model=new DefaultTableModel(new PageController().nextPage(),titles);//��������ģ���е�����Ϊ��һҳ����
					table.setModel(model);//���ñ�������ģ��
				}
			});
			btnNext.setBounds(149, 302, 95, 25);
			contentPane.add(btnNext);
			
			JLabel lblMsg = new JLabel("ÿҳ��ʾ��");
			lblMsg.setBounds(254, 307, 87, 15);
			contentPane.add(lblMsg);
			
			JComboBox comboBox = new JComboBox(new Integer[] {3,5,10,15,20,1000,10000});
			comboBox.addItemListener(new ItemListener() {//ҳ��������ѡ��ı��¼�
				public void itemStateChanged(ItemEvent e) {
					int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//��ȡ��������ѡ��ֵ
					PageController pcl=new PageController();
					pcl.setCountPerpage(pageSize);//����ÿҳ��ʾ��¼����
					model=new DefaultTableModel(pcl.getPaegData(),titles);//��������ģ��
					table.setModel(model);//���ñ������ģ��
				}
			});
			comboBox.setSelectedIndex(1);//����������Ĭ��ֵ
			comboBox.setBounds(318, 303, 55, 23);
			contentPane.add(comboBox);
			
			JButton btnNewButton = new JButton("����");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ExcelExporter ex=new ExcelExporter();
					File file=new File("d:/�ͻ���Ϣ.xls");
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
					JOptionPane.showMessageDialog(null, "�����ɹ���");
				}
			});
			btnNewButton.setBounds(341, 331, 93, 23);
			contentPane.add(btnNewButton);
		}
}
