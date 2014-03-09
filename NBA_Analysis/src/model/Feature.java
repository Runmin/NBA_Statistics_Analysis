package model;

public class Feature {
	private int id;
	private String name;
	private double score;
	private double weight;
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	/*public int getIfUse() {
		return ifUse;
	}
	public void setIfUse(int ifUse) {
		this.ifUse = ifUse;
	}*/
}
