package acme.features.spam;

import java.util.List;


public class SpamDetector {
	
	public static boolean validateNoSpam(String text, List<String> spamWords, double threshold) {
		
		//boolean res = false;
		final String cutText = text.replace(" ", "").replace("\n", "n").toLowerCase().trim();
		final Integer numberOfLetters = cutText.length();
		//String[] words = text.split("\\s+");
		Integer counter = 0; 
		for(int i = 0; i<spamWords.size();i++) {
			final String word = spamWords.get(i).replace(" ", "").toLowerCase().trim();
			boolean check = cutText.contains(word);
			while(check) {
				counter+=word.length();
				check = cutText.substring(cutText.indexOf(word)+word.length()).contains(word);
			}
		}
		
		return  (counter*1.00/numberOfLetters)<=threshold;	
	}
	
	

	

}
