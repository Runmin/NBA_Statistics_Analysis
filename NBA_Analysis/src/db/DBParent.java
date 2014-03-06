package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DBParent {
	protected Statement st;
	protected Connection conn;
	
	public DBParent(Connection conn){
		this.conn = conn;
	}
	
	public void createStatement(){
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeStatement(){
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** 
	 * @param: combined feature name
	 * @return: Map with two fileds: 1.table 2.feature_name 
	 */
	public Map<String, String> parser(String name){
		Map<String, String> pair = new HashMap<String, String>();
		int underline = name.indexOf('_');
		String table = name.substring(0, underline);
		String feature_name = name.substring(underline+1);
		
		pair.put("table", table);
		pair.put("feature_name", feature_name);
		return pair;
	}
}
