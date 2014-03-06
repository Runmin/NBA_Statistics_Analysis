package view;

import java.util.ArrayList;

import controller.OutlierController;
import model.Feature;
import model.Player;

public class Test {
	
	public static void main(String args[]){
		Test test = new Test();
		OutlierController outlier = new OutlierController();
		ArrayList<Feature> features = new ArrayList<Feature>();
		// ** add features here to test
		// pc_ means playoff career
		// p_means playoff
		// rsc_ means regular season career
		// rs_ means regular season
		features.add(new Feature("pc_gp", 3));
		features.add(new Feature("pc_minutes", 1));
		
		outlier.setFeatures(features);
		
		ArrayList<Player> outliers = new ArrayList<Player>(outlier.getOurliers());
		
		for(int i = 0; i < outliers.size(); i++){
			Player out_player = outliers.get(i);
			String name = out_player.getFirstname() + " " + out_player.getLastname();
			int total_score = outliers.get(i).getTotalScore();
			
			System.out.println("====================");
			System.out.println("Name: "+name);
			System.out.println("Total Score: "+total_score);
			System.out.println("--------------------");
			ArrayList<Feature> out_features = new ArrayList<Feature>(out_player.getFeatures());
			for(int j = 0; j < out_features.size(); j++){
				Feature feature = out_features.get(j);
				System.out.println("feature: "+feature.getName()+", "
						+"score: "+feature.getScore()+", "
						+"weight: "+feature.getWeight());
			}
			System.out.println("====================");
		}
	}
}


