package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import model.Feature;
import model.Player;

public class DBManager {
	
	private Connection conn;
	
	// Here are all class that deal with all tables needed by each role 
	private DBPlayer db_player;
	private DBTeam db_team;
	private DBCoach db_coach;

	
	// connect to DB in the constructor
	public DBManager() {
		
		try {
			/** !!! DB configuration needs to be changed according to our DB **/
			
			// create our mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/3306";
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myUrl, "root", "");
			
		} catch (Exception e) {
			System.err.println("An exception occur!");
			System.err.println(e.getMessage());
		}
		
		db_player = new DBPlayer(conn);
		db_team = new DBTeam(conn);
		db_coach = new DBCoach(conn);
	}

	public ArrayList<Player> getReadyPlayers(ArrayList<Feature> features) {
		// TODO Auto-generated method stub	
		ArrayList<Player> players = new ArrayList<Player>(db_player.getPlayers(features));
		disconnect();
		return players;
	}

	private void disconnect() {
		try {
			if (!conn.isClosed()) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
