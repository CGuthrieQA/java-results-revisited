package com.qa.main;

public class Runner {


	public static void main(String[] args) {
		
		Results res = new Results();
		
		int biologyScore = 18;
		int chemistryScore = 150;
		int physicsScore = 150;
		
		System.out.println(res.displayResults(biologyScore, chemistryScore, physicsScore));

		System.out.println(res.percentageResults(biologyScore, chemistryScore, physicsScore));
		
	}

}
