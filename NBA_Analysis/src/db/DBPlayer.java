package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.Feature;
import model.Player;

public class DBPlayer extends DBParent{
	
	public DBPlayer(Connection conn){
		super(conn);
	}
	
	
	public ArrayList<Player> getPlayers(ArrayList<Feature> features) {
		// TODO Auto-generated method stub
		ArrayList<Player> players = new ArrayList<Player>();
		// right now in each feature, there are only "name" and signed "weight"
		// the return is all players with all selected features with "name" "score" "weight"
	    
		try {
			createStatement();
			
			// need to parse the feature name
			// e.g. if the feature is pc_gp, select from"playoff_career" table
			// * may gather all fields from the same table, and do sql select
			
			// PARSER IS READY IN PARENT CLASS, CALL IT
			
			String query = " ";
		    ResultSet rs = st.executeQuery(query);
		    
		    
		    closeStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return players;
	}
}
