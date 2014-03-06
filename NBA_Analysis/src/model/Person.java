package model;

import java.util.ArrayList;

public class Person {
	private String id;
	private String lastname;
	private String firstname;
	private ArrayList<Feature> features;
	
	public Person(String id, String lastname, String firstname){
		this.setId(id);
		this.setLastname(lastname);
		this.setFirstname(firstname);
		features = new ArrayList<Feature>();
	}


	public void addFeature(Feature one_feature){
		features.add(one_feature);
	}
	
	public ArrayList<Feature> getFeatures(){
		return features;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
}
