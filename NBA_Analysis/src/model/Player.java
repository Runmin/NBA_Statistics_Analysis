package model;

public class Player extends Person{
	private String position;
	private double total_score;
	
	public Player(String id, String lastname, String firstname, String position) {
		super(id, lastname, firstname);
		this.setPosition(position);
		this.setTotalScore(0);
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getTotalScore() {
		return total_score;
	}

	public void setTotalScore(double total_score) {
		this.total_score = total_score;
	}

}
