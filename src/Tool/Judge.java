package Tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataBase.ConnectionSql;

public class Judge {
//	public static boolean judge(String data) {
//		File file =new File("d:\\JavaDemo\\test.txt");
//		InputStream in=null;
//		byte[] a=new byte[1024];
//		try {
//			in=new FileInputStream(file);
//			try {
//				in.read(a);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		data=new String(a);
//		String sql="select xm from cs where xm=?";
//		ConnectionSql sc=new ConnectionSql();
//		Connection conn=sc.getConnection();
//		try {
//			PreparedStatement pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, data);
//			ResultSet rs=pstmt.executeQuery();
//			if(rs.next()) {
//					return true;
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//		
//	}
	
//	static Connection conn;
//	static PreparedStatement st;
//	public static String judge(String id) {
//		String sql = "select xm from cs where xm=?";
//		try {
//			ConnectionSql Dbcn = new ConnectionSql();
//			conn = Dbcn.getConnection();
//			st = conn.prepareStatement(sql);
//			st.setString(1,id);
//			ResultSet rs = st.executeQuery();
//			while(rs.next()) {
//				return rs.getString(1);
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

}
