# Results Revisited

1. Expand the Results class so that there is now a pass mark of 60%; if the person receives under 60% they get a fail message.

```java
public String percentageResults(int bio, int chem, int phys) {
	double percentage = ( 100 * ( bio + chem + phys ) ) / 450;
	String results = "PERCENTAGE\r\n" + percentage + "%\r\n\n";
	if ( percentage < 60.0 ) {
		results += "FAIL";
	} else {
		results += "PASS";
	}
	return results;
}
```

2. Expand the previous example so that even if the person gets higher than 60% overall, if they fail 1 or more of the exams (pass grade of 60% for each exam) they still fail overall.

eg. if a student's scores were: Biology: 150, Chemistry: 150, Physics: 84

they would have an overall grade of 85.3% (Pass)

but in this case the student would fail because their physics grade is 54% (Fail)

```java
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
	results += "Physics: " + physPercent + "%\r\n";
	results += "Total: " + percentage + "%\r\n\n";
	
	
	if (bioPercent < 60 || chemPercent < 60 || physPercent  < 60) {
		results += "FAIL";
	} else if ( percentage < 60.0 ) {
		results += "FAIL";
	} else {
		results += "PASS";
	}
	
	return results;
}
```

3.Expand the above so that the message that is displayed varies depending on the number of subjects that they have failed.

```java
public String percentageResults(int bio, int chem, int phys) {
	double percentage = ( 100 * ( bio + chem + phys ) ) / 450;
	double bioPercent = percentageCheck(bio);
	double chemPercent = percentageCheck(chem);
	double physPercent = percentageCheck(phys);
	
	double[] percentArray = {bioPercent, chemPercent, physPercent};
	
	String results = "PERCENTAGE\r\n";
	results += "Biology: " + bioPercent + "%\r\n";
	results += "Chemistry: " + chemPercent + "%\r\n";
	results += "Physics: " + physPercent + "%\r\n";
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
		
		int i;
		int count = 0;
		
		for (i=0; i < percentArray.length; i++) {
			if (percentArray[i] < 60) {
				count++;
			}
		}
		
		results += "TOTAL FAILS: " + count;

	} else if ( percentage < 60.0 ) {
		results += "FAILED TO REACH TOTAL PERCENTAGE REQUIRED";
	} else {
		results += "PASSED EVERYTHING";
	}
	
	return results;
}
```