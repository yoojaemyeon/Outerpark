package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;

public class JDBCUtil {
	private static JDBCUtil instance = new JDBCUtil();
	public static JDBCUtil getInstance() {
		return instance;
	}

	private JDBCUtil() {}
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	ResultSetMetaData metaData;
	
	public Connection getConnection()
	{
		Connection conn = null;
		try {
			String user = "YYJ95"; 
			String pw = "java";
			String url = "jdbc:oracle:thin:@192.168.46.30:1521:xe";
			Class.forName("oracle.jdbc.driver.OracleDriver");        
			conn = DriverManager.getConnection(url, user, pw);          
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;     
	}
	
	public void DBclose(Connection conn, PreparedStatement pstm, ResultSet rs){
		try {
			if ( rs != null )  rs.close();   
			if ( pstm != null )pstm.close();  
			if ( conn != null )conn.close(); 			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public void DBclose(Connection conn, PreparedStatement pstm){
		try {  
			if ( pstm != null )pstm.close();  
			if ( conn != null )conn.close(); 			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
<<<<<<< HEAD
	public int update(String query) {
=======
	public int Update(String query) {
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
		try {
			conn = this.getConnection();
			pstm = conn.prepareStatement(query);
			int excute = pstm.executeUpdate();
			this.DBclose(conn, pstm);
			return excute;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
<<<<<<< HEAD
	public boolean selectBoolean(String query) {
=======
	public boolean SelectBoolean(String query) {
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
		try {
			conn = this.getConnection();
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
<<<<<<< HEAD
			boolean flag = rs.next();
			DBclose(conn, pstm, rs);
			return flag;
=======
			return rs.next();
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
<<<<<<< HEAD
	public String selectString(String query,String col) {
=======
	public String SelectString(String query,String col) {
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
		try {
			conn = this.getConnection();
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			rs.next();
<<<<<<< HEAD
			String str = rs.getString(col);
			DBclose(conn, pstm, rs);
			return str;
=======
			return rs.getString(col);
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
		}catch(Exception e) {
			return null;
		}
	}
	
<<<<<<< HEAD
	public int selectint(String query,String col) {
=======
	public int Selectint(String query,String col) {
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
		try {
			conn = this.getConnection();
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			rs.next();
<<<<<<< HEAD
			int i = rs.getInt(col);
			DBclose(conn, pstm, rs);
			return i;
=======
			return rs.getInt(col);
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
		}catch(Exception e) {
			return 0;
		}
	}
	
	public ArrayList<HashMap<String, Object>> selectList(String query) {
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		try {
			conn = this.getConnection();
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			metaData = rs.getMetaData();
			int sizeColumn = metaData.getColumnCount();
			
			while(rs.next()) {
				HashMap<String, Object> hash = new HashMap<String,Object>(sizeColumn);
				for(int i=1;i<=sizeColumn;++i) {
					hash.put(metaData.getColumnName(i),rs.getObject(i));
				}
				list.add(hash);
			}
		}catch(Exception e) {
			return null;
		}
		this.DBclose(conn, pstm, rs);
		return list;
	}
	
}