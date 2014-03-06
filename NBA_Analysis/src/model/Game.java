package model;

public class Game {
	//private String id;
	private Team my_team;
	private Team other_team;
	private int my_score;
	private int gap;
	
	public Game(Team my_team, Team other_team, int my_score, int other_score){
		this.my_team = my_team;
		this.other_team = other_team;
		this.my_score = my_score;
		this.gap = my_score - other_score;
	}
	
	public Team getMyTeam(){
		return this.my_team;
	}
	
	public Team getOtherTeam(){
		return this.other_team;
	}
	
	public int getMyScore(){
		return this.my_score;
	}
	
	public int getGap(){
		return this.gap;
	}
	
	
}
