package Function;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Tool.DbDelete;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
//		});
//	}

	/**
	 * ɾ���ͻ���Ϣ
	 */
	public Delete() {
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
					DbDelete dele=new DbDelete();
					dele.delete(name);
					JOptionPane.showMessageDialog(null, "�ͻ�ɾ���ɹ���");
			}
		});
		btnNewButton.setBounds(271, 186, 93, 23);
		contentPane.add(btnNewButton);
	}
}
