package processor;

import utils.TextUtil;

import java.util.*;

public class TextProcessor {

    /**
     * Takes a file and process it as well as printing
     * @param file
     */
    public void process(String file) {
        String text = TextUtil.readText(file);

        // Split words by spaces in order to count and have for later
        List<String> words = Arrays.asList(text.trim().split("\\s+")); //Using List because it's ordered and easy to manipulate
        System.out.println("Word count is = " + words.size());

        // Getting a map from all the words of how many have the same number of characters and how many characters
        Map<Integer, Integer> wordMap = processWords(words);

        // Getting average
        // This would be quicker if it was in the same loop
        double average = getAverage(wordMap);
        System.out.println("Average word length = " + average);

        // Printing word length and highest length
        Integer highest = 0;
        List<Integer> highestValues = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : wordMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Number of words of length " + key + " is " + value);

            // Finds highest and keeps track of the key
            if (value > highest) {
                highestValues = new ArrayList<>();
                highest = value;
                highestValues.add(key);
            } else if (value == highest) {
                highestValues.add(key);
            }
        }
        System.out.print("The most frequently occurring word length is " + highest + " for word lengths of ");
        for (int i = 0; i < highestValues.size(); i++) {
            Integer value = highestValues.get(i);
            System.out.print(value + " ");
            if (i != highestValues.size()-1) {
                System.out.print("& ");
            }
        }
    }

    /**
     * Calculates average of keys from a map's values
     * @param wordMap
     * @return
     */
    protected double getAverage(Map<Integer, Integer> wordMap) {
        if (wordMap.isEmpty()) {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for(Map.Entry<Integer,Integer> entry : wordMap.entrySet()) {
            sum += entry.getValue();
        }
        return sum/wordMap.size();
    }

    /**
     * Process words whilst ignoring punctuation
     * @param words
     * @return
     */
    protected Map<Integer, Integer> processWords(List<String> words) {
        // Using TreeMap because it is a SortedMap
        Map<Integer, Integer> countMap = new TreeMap<>();
        words.stream().forEach(currentWord -> {
            int charCount = 0;
            for (char c : currentWord.toCharArray()) {
                // I would like to also expand so it only filters out if there are letters around ;
                // Because formatted time would be written an as 12:43
                if (c != ',' && c != '.' && c != '"' && c != '\'' && c != ':' && c != ';') {
                    charCount++;
                }
            }

            // Add to map if character count is > 0
            if (charCount > 0) {
                Integer wordCount = 1;
                if (countMap.containsKey(charCount)) {
                    wordCount = countMap.get(charCount) + wordCount;
                }
                countMap.put(charCount, wordCount);
            }
        });
        return countMap;
    }
}
