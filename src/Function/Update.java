package Function;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Tool.Modify;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.awt.event.ActionEvent;
/**
 * 
 * 修改客户信息
 *
 */
public class Update extends JFrame {

	private JPanel contentPane;
	static JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	public Update() {
		setTitle("修改客户信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入你需要修改的客户的名字：");
		lblNewLabel.setBounds(39, 42, 211, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(135, 107, 131, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("确 认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				File file=new File("d:\\javaDemo\\test.txt");
				OutputStream out=null;
				try {
					out=new FileOutputStream(file);
					//name=textField.getText();
					byte[] data=name.getBytes();
					out.write(data);
				}catch(Exception k) {
					k.printStackTrace();
				}
				//if(DbUpdate.update(name)) {
					Modify mo=new Modify();
					mo.run();
				//}
//				else {
//					JOptionPane.showMessageDialog(null, "不存在该客户！");
//				}
				
			}
		});
		btnNewButton.setBounds(278, 187, 93, 23);
		contentPane.add(btnNewButton);
	}

}
