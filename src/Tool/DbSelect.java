package Tool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import DataBase.ConnectionSql;
/**
 * 
 * ∏˘æ›’À∫≈’“≥ˆ√‹¬Î
 *
 */
public class DbSelect {

	static Connection conn;
	static PreparedStatement st;
	public static String select(String id) {
		String sql = "select mm from manage where zh=?";
		try {
			ConnectionSql Dbcn = new ConnectionSql();
			conn = Dbcn.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1,id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				return rs.getString(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}