import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(findDistinguishingChar("apple", "pale"));  // Should print 'p'
        System.out.println(findDistinguishingChar("banana", "ban"));  // Should print 'a'
        System.out.println(findDistinguishingChar("ban", "banner"));  // Should print 'n', 'e', or 'r'
    }

    public static Character findDistinguishingChar(String str1, String str2) {
        HashMap<Character, Integer> frequencyMap1 = new HashMap<>();
        HashMap<Character, Integer> frequencyMap2 = new HashMap<>();

        // Populate frequencyMap1 with the frequencies of each character in str1
        for (char c : str1.toCharArray()) {
            frequencyMap1.put(c, frequencyMap1.getOrDefault(c, 0) + 1);
        }

        // Populate frequencyMap2 with the frequencies of each character in str2
        for (char c : str2.toCharArray()) {
            frequencyMap2.put(c, frequencyMap2.getOrDefault(c, 0) + 1);
        }

        Character result = null;
        int maxDifference = 0;

        // Compare frequencies and find the character with the maximum frequency difference
        for (Character key : frequencyMap1.keySet()) {
            int frequency1 = frequencyMap1.get(key);
            int frequency2 = frequencyMap2.getOrDefault(key, 0);
            int difference = Math.abs(frequency1 - frequency2);

            if (difference > maxDifference) {
                maxDifference = difference;
                result = key;
            }
        }

        for (Character key : frequencyMap2.keySet()) {
            if (frequencyMap1.containsKey(key)) {
                continue; // Skip keys already compared
            }

            int frequency1 = frequencyMap1.getOrDefault(key, 0);
            int frequency2 = frequencyMap2.get(key);
            int difference = Math.abs(frequency1 - frequency2);

            if (difference > maxDifference) {
                maxDifference = difference;
                result = key;
            }
        }

        return result;
    }
}
