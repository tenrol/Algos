import java.util.HashMap;
import java.util.Map;


public class RansomNote {

	public static HashMap<String, Integer> getFreq(String[] words) {
		
		HashMap<String, Integer> frequency = new HashMap<>();
		for (String word : words) {
			if (!frequency.containsKey(word)) {
				frequency.put(word, 0);
			}
			frequency.put(word, frequency.get(word) + 1);
		}
		return frequency;
	}

	public static boolean hasEnoughStrings(HashMap<String, Integer> magazineFreq, HashMap<String, Integer> noteFreq) {
		
		for (Map.Entry<String, Integer> entry : noteFreq.entrySet()) {
			String word = entry.getKey();
			if (!magazineFreq.containsKey(word) || magazineFreq.get(word) < entry.getValue()) {
				return false;
			}
		}
		return true; 
	}

	public static boolean canBuildRansomNote(String[] magazine, String[] note) {
		HashMap<String, Integer> magazineFreq = getFreq(magazine);
		HashMap<String, Integer> noteFreq = getFreq(note);
		return hasEnoughStrings(magazineFreq, noteFreq);
	}

	public static void main(String[] args) {
		String[] magazine = {"hi", "hello", "world"};
		String[] note = {"hi", "hello", "world", "lol"};
		System.out.println(canBuildRansomNote(magazine, note));
	}
}