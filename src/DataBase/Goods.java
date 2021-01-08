package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
/**
 * 
 * 生成商品信息
 *
 */

public class Goods {
	static Connection conn;
	
	public static int getNum(int start,int end) {//随机返回返回指定范围间的整数
    	//Math.random()随机返回0.0至1.0之间的数
        return (int)(Math.random()*(end-start+1)+start);
    }
	
	public static void addGoods() {
		ConnectionSql db=new ConnectionSql();
		String sqls="insert into goods(xm,bh,num,cje) values(?,?,?,?)";
		conn=db.getConnection();
		try {
			PreparedStatement pstmt=conn.prepareStatement(sqls);
			ArrayList<String> list=new ArrayList<String>();
			String sql="select xm from cs";
			String name=null;
			ConnectionSql cs=new ConnectionSql();
			conn=cs.getConnection();
			try {
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next()) {
					name=rs.getString(1);
					int num=getNum(1,1000);
					int bh=getNum(1000,9999);
					int cje=getNum(1,10000);
					pstmt.setString(1, name);
		            pstmt.setInt(2, bh);
					pstmt.setInt(3, num);
					pstmt.setInt(4,cje);
					pstmt.addBatch();
				}
				pstmt.executeBatch();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Vector<Vector> getAll(String sqls){
		Vector<Vector> rows=new Vector<Vector>();
		ConnectionSql ds=new ConnectionSql();
		conn=ds.getConnection();
		try {
			PreparedStatement pstmt=conn.prepareStatement(sqls);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Vector row=new Vector();
				row.add(rs.getString(1));
				row.add(rs.getInt(2));
				row.add(rs.getInt(3));
				row.add(rs.getInt(4));
				rows.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addGoods();

	}

}
