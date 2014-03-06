package model;

import java.util.ArrayList;

public class Team {
	private String id;
	private ArrayList<Player> players;
	private ArrayList<Coach> coaches;
	private ArrayList<Feature> features;
	
	public Team(String id){
		this.id = id;
		players = new ArrayList<Player>();
		coaches = new ArrayList<Coach>();
		features = new ArrayList<Feature>();
	}
	
	public void addPlayer(Player one_player){
		players.add(one_player);
	}
	
	public void addCoach(Coach one_coach){
		coaches.add(one_coach);
	}
	
	public void addFeature(Feature one_feature){
		features.add(one_feature);
	}
	
	public String getId(){
		return id;
	}
	
	public ArrayList<Player> getAllPlayers(){
		return players;
	}
	
	public ArrayList<Coach> getAllCoaches(){
		return coaches;
	}
	
	public ArrayList<Feature> getAllFeatures(){
		return features;
	}
	
}
