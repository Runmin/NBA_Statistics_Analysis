package controller;

import java.util.ArrayList;

import db.DBManager;
import model.Feature;
import model.Player;

public class OutlierController {
	ArrayList<Player> players;
	
	public OutlierController(){
		players = new ArrayList<Player>();
	}
	
	public void setFeatures(ArrayList<Feature> features) {
		// TODO Auto-generated method stub
		DBManager db = new DBManager();
		players = new ArrayList<Player>(db.getReadyPlayers(features));
	}
	

	public ArrayList<Player> getOurliers() {
		// TODO Auto-generated method stub
		ArrayList<Player> outliers = new ArrayList<Player>();
		
		// calculations
		// setTotalScore
		
		return outliers;
	}
	

}
