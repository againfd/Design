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
 * 随机生成管理员的账号和密码
 *
 */

public class Management {
	
	public static int getNum(int start,int end) {//随机返回返回指定范围间的整数
    	//Math.random()随机返回0.0至1.0之间的数
        return (int)(Math.random()*(end-start+1)+start);
    }
	public static StringBuilder getZh() {//不使用String，因为需要大量拼接字符串
    	StringBuilder zh=new StringBuilder("2019401");//学号前7位相同
    	StringBuilder zh1=new StringBuilder(String.valueOf(getNum(1,999)));//随机取后3位
    	if(zh1.length()==1) {
    		zh1=zh1.insert(0, "00");//如果是1位数，前面增加2个0
    		zh=zh.append(zh1);//前6位与后3位拼接成学号
    	}else if(zh1.length()==2) {
    		zh1=zh1.insert(0, "0");//如果是2位数，前面增加1个0
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
	 * 将管理员的数据加入到数据库中
	 */
    public static void addZH() {
    	ConnectionSql dbcs=new ConnectionSql();//使用1中定义的连接数据库的类
    	String sql="insert into manage(zh,mm) values(?,?)";//使用占位符定义插入语句
    	try(Connection conn=dbcs.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
        	ArrayList<String> alist=new ArrayList<String>();//定义集合
    		for(int i=1;i<=10;) {
    			String zh=getZh().toString();//随机获取账号
    			if(!alist.contains(zh)) {//判断账号是否唯一
    				alist.add(zh);//将账号加入集合
    				String mm=getPassword(8);
    				pstmt.setString(1, zh);//定义第1个占位符的内容
    	    		pstmt.setString(2, mm);//定义第2个占位符的内
    	    		pstmt.addBatch();//加入批处理等待执行
    				i++;//学号唯一，循环继续往下执行
    			}
    		}
    		pstmt.executeBatch();//批量执行插入操作
    		JOptionPane.showMessageDialog(null, "success");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public static Vector<Vector> getSelectAll(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
    	ConnectionSql dbcs=new ConnectionSql();//使用1中定义的连接数据库的类
    	try(Connection conn=dbcs.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
    		while(rs.next()) {//遍历数据集
    			Vector row=new Vector();//定义行数据
    			row.add(rs.getString(1));//获取第一个字段学号
    			row.add(rs.getString(2));//获取第二个字段姓名
    			rows.add(row);//将行数据添加到记录集合中
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//返回所有行数据
    }

}
