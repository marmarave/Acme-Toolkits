package acme.features.spam;

import java.util.List;

public class SpamDetector {
	
public boolean validateNoSpam(String text, List<String> strongSpam,
		List<String> weakSpam, double strongThreshold, double weakThreshold) {
	
	//Parte del strong Spam
		
		final String cutText = text.replace(" ", "").replace("\n", "n").toLowerCase().trim();
		final Integer numberOfLetters = cutText.length();
		Integer counter = 0; 
		Integer counter2 = 0; 
		for(int i = 0; i<strongSpam.size();i++) {
			final String word = strongSpam.get(i).replace(" ", "").toLowerCase().trim();
			boolean check = cutText.contains(word);
			while(check) {
				counter+=word.length();
				check = cutText.substring(cutText.indexOf(word)+word.length()).contains(word);
			}
		}
		
	//Parte del weak Spam
		
		for(int i = 0; i<weakSpam.size();i++) {
			final String word = weakSpam.get(i).replace(" ", "").toLowerCase().trim();
			boolean check = cutText.contains(word);
			while(check) {
				counter2+=word.length();
				check = cutText.substring(cutText.indexOf(word)+word.length()).contains(word);
			}
		}
		
		return ((counter*100.0/numberOfLetters)<=strongThreshold) && ((counter2*100.0/numberOfLetters)<=weakThreshold);	
	}

}
