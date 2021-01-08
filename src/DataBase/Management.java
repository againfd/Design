package DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

/**
 * 
 * ������ɹ���Ա���˺ź�����
 *
 */

public class Management {
	
	public static int getNum(int start,int end) {//������ط���ָ����Χ�������
    	//Math.random()�������0.0��1.0֮�����
        return (int)(Math.random()*(end-start+1)+start);
    }
	public static StringBuilder getZh() {//��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
    	StringBuilder zh=new StringBuilder("2019401");//ѧ��ǰ7λ��ͬ
    	StringBuilder zh1=new StringBuilder(String.valueOf(getNum(1,999)));//���ȡ��3λ
    	if(zh1.length()==1) {
    		zh1=zh1.insert(0, "00");//�����1λ����ǰ������2��0
    		zh=zh.append(zh1);//ǰ6λ���3λƴ�ӳ�ѧ��
    	}else if(zh1.length()==2) {
    		zh1=zh1.insert(0, "0");//�����2λ����ǰ������1��0
    		zh=zh.append(zh1);
    	}else {
    		zh=zh.append(zh1);
    	}
    	return zh;
    }
	
	public static String getPassword(int length) {
		char[] index=new char[length];
		int i=0;
		while(i<length) {
			int s=(int)(Math.random()*3);
			if(s==0)
				index[i]=(char)('A'+Math.random()*26);
			else if(s==1)
				index[i]=(char)('a'+Math.random()*26);
			else
				index[i]=(char)('0'+Math.random()*10);
			i++;
		}
		String str=new String(index);
		return str;
	}
	
	public static void main(String[] args) {
    	addZH();
    }
	/**
	 * ������Ա�����ݼ��뵽���ݿ���
	 */
    public static void addZH() {
    	ConnectionSql dbcs=new ConnectionSql();//ʹ��1�ж�����������ݿ����
    	String sql="insert into manage(zh,mm) values(?,?)";//ʹ��ռλ������������
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
        	ArrayList<String> alist=new ArrayList<String>();//���弯��
    		for(int i=1;i<=10;) {
    			String zh=getZh().toString();//�����ȡ�˺�
    			if(!alist.contains(zh)) {//�ж��˺��Ƿ�Ψһ
    				alist.add(zh);//���˺ż��뼯��
    				String mm=getPassword(8);
    				pstmt.setString(1, zh);//�����1��ռλ��������
    	    		pstmt.setString(2, mm);//�����2��ռλ������
    	    		pstmt.addBatch();//����������ȴ�ִ��
    				i++;//ѧ��Ψһ��ѭ����������ִ��
    			}
    		}
    		pstmt.executeBatch();//����ִ�в������
    		JOptionPane.showMessageDialog(null, "success");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public static Vector<Vector> getSelectAll(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	ConnectionSql dbcs=new ConnectionSql();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getString(1));//��ȡ��һ���ֶ�ѧ��
    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�����
    			rows.add(row);//����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//��������������
    }

}
