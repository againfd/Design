package Tool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import DataBase.ConnectionSql;
/**
 * 
 * É¾³ýÐÅÏ¢
 *
 */
public class DbDelete {

	static Connection conn;
	public static String delete(String name) {
		String sql="delete from cs where xm=?";
		String sql1="delete from goods where xm=?";
		try {
			ConnectionSql stp=new ConnectionSql();
			conn=stp.getConnection();
			PreparedStatement pstmt1=conn.prepareStatement(sql1);
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.executeUpdate();
			pstmt1.setString(1,name);
			pstmt1.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}
