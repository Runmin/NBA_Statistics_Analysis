package controller;

import java.util.ArrayList;

import db.DBManager;
import model.Feature;
import model.Player;

public class OutlierController {
	private static final int K = 3;
	private ArrayList<Player> players;
	private Player[] outliers;
	private int N;
	
	public OutlierController(int top_n){
		this.players = new ArrayList<Player>();
		outliers = new Player[top_n];
		this.N = top_n;
	}
	
	public void setFeatures(ArrayList<Feature> features) {
		// TODO Auto-generated method stub
		DBManager db = new DBManager();
		players = new ArrayList<Player>(db.getReadyPlayers(features));
	}
	
	private double findKthDistance(int player_num){
		Player one_player = players.get(player_num);
		double[] k_distance = new double[K];
		for(int i = 0; i < K; i++){
			k_distance[i] = -1;
		}
		// calculate the distances between it and other neighbors
		int max_location = -1;
		double max_value = -1;
		int number = 0;
		for(int i = 0; i < players.size(); i++){
			if(i!=player_num){
				
				double d = calculateDistance(one_player.getFeatures(), players.get(i).getFeatures());
				
				if(number < K){
					// less than K: just add into the array, but keep the max
					k_distance[number] = d;
					if(d > max_value){
						max_value = d;
						max_location = number;
					}
					number++;
				}else{
					// more than K: replace the max with the current, and find the max again.
					if(d < max_value){
						k_distance[max_location] = d;
						max_value = d;
						for(int j = 0; j < K; j++){
							if(k_distance[j] > max_value){
								max_value = k_distance[j];
								max_location = j;
							}
						}
					}
					number++;
				}
				
			}	
		}
		
		return max_value;
	}

	private double calculateDistance(ArrayList<Feature> features1, ArrayList<Feature> features2) {
		int size = features1.size();
		double distance = 0.0;
		
		// distance = sqrt((x1-y1)^2 + (x2-y2)^2 + ... + (xn-yn)^2)
		for(int i = 0; i < size; i++){
			double gap = features1.get(i).getScore()*features1.get(i).getWeight()
					- features2.get(i).getScore()*features2.get(i).getWeight();
			distance += Math.pow(gap, 2);
		}
		distance = Math.sqrt(distance);
		return distance;	
	}

	public Player[] getOurliers() {
		// calculations
		int min_location = -1;
		double min_value = -1;
		int number = 0;
		double[] outliers_d = new double[N];
		for(int i = 0; i < players.size(); i++){
			double d = findKthDistance(i);
			if(number < N){
				// less than K: just add into the array, but keep the max
				outliers[number] = players.get(i);
				outliers_d[number] = d;
				if(d < min_value){
					min_value = d;
					min_location = number;
				}
				number++;
			}else{
				// more than K: replace the max with the current, and find the max again.
				if(d > min_value){
					outliers[min_location] = players.get(i);
					outliers_d[min_location] = d;
					min_value = d;
					for(int j = 0; j < N; j++){
						if(outliers_d[j] < min_value){
							min_value = outliers_d[j];
							min_location = j;
						}
					}
				}
				number++;
				
			}
		}
		
		
		// setTotalScore
		
		return outliers;
	}
	

}
