package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 *uses a given sentence to identify and return all the longest words
 */
public class WordProcessor {
    private String sentence; 

    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    //finds longest words in the sentence
    //website: https://www.geeksforgeeks.org/program-find-smallest-largest-word-string/
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        if (sentence == null || sentence.isEmpty()) {
            return longestWords;
        }

        //splits sentence into words by spaces
        //website: https://www.geeksforgeeks.org/split-string-java-examples/
        String[] words = sentence.trim().split("\\s+");
        int maxLength = 0;

        //finds the maximum word length
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }

        //collects the words that have the maximum length
        for (String word : words) {
            if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }

        return longestWords;
    }
}
    
