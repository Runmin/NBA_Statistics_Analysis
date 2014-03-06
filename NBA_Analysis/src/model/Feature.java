package model;

public class Feature {
	private int id;
	private String name;
	private int score;
	private int weight;
	//private int ifUse;
	public Feature(String name, int weight){
		this.setName(name);
		this.setWeight(weight);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/*public int getIfUse() {
		return ifUse;
	}
	public void setIfUse(int ifUse) {
		this.ifUse = ifUse;
	}*/
}
