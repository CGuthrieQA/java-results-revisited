package com.qa.main;

public class Results {
	
	// methods
	
	public String displayResults(int bio, int chem, int phys) {
		String results = "SCORES\r\n";
		results += "Biology: " + bio + "/150\r\n";
		results += "Chemistry: " + chem + "/150\r\n";
		results += "Physics: " + phys + "/150\r\n";
		results += "Total: " + (bio+chem+phys) + "/450\r\n";
		return results;
	}
	
	public double percentageCheck(int subject) {
		return ( 100 * subject ) / 150;
	}
	
	public String percentageResults(int bio, int chem, int phys) {
		double percentage = ( 100 * ( bio + chem + phys ) ) / 450;
		double bioPercent = percentageCheck(bio);
		double chemPercent = percentageCheck(chem);
		double physPercent = percentageCheck(phys);
		
		String results = "PERCENTAGE\r\n";
		results += "Biology: " + bioPercent + "%\r\n";
		results += "Chemistry: " + chemPercent + "%\r\n";
		results += "Physics: " + chemPercent + "%\r\n";
		results += "Total: " + percentage + "%\r\n\n";
		
		
		if (bioPercent < 60 || chemPercent < 60 || physPercent  < 60) {
			
			if (bioPercent > 60 ){
				results += "PASSED BIOLOGY\r\n";
			} else {
				results += "FAILED BIOLOGY\r\n";
			}

			if (chemPercent > 60){
				results += "PASSED CHEMISTRY\r\n";
			} else {
				results += "FAILED CHEMISTRY\r\n";
			}

			if (physPercent > 60){
				results += "PASSED PHYSICS\r\n";
			} else {
				results += "FAILED PHYSICS\r\n";
			}

		} else if ( percentage < 60.0 ) {
			results += "FAILED TO REACH TOTAL PERCENTAGE REQUIRED";
		} else {
			results += "PASSED EVERYTHING";
		}
		
		return results;
	}
	

}