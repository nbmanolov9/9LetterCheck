import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        // Create ExecutorService with a single thread
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            // Download words from URL
            Future<Set<String>> futureWords = executor.submit(new WordDownloader("https://raw.githubusercontent.com/nikiiv/JavaCodingTestOne/master/scrabble-words.txt"));
            Set<String> words = futureWords.get();

            // Print count of total words
            System.out.println("Total words from URL: " + countTotalWords(words));

            // Find valid 9-letter words
            Set<String> validWords = findValidWords(words);

            // Print count of valid 9-letter words
            System.out.println("Total valid 9-letter words: " + validWords.size());

            // Sort valid 9-letter words
            List<String> sortedValidWords = new ArrayList<>(validWords);
            Collections.sort(sortedValidWords);

            // Print sorted valid 9-letter words
            System.out.println("\nValid 9-letter words sorted by starting word (ascending):");
            for (String word : sortedValidWords) {
                System.out.println(word);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shutdown executor service
            executor.shutdown();
        }
    }

    // Method to find valid 9-letter words
    private static Set<String> findValidWords(Set<String> words) {
        Set<String> validWords = new HashSet<>();
        for (String word : words) {
            if (word.length() == 9 && isValidWord(word, words)) {
                validWords.add(word);
            }
        }
        return validWords;
    }

    // Method to check if a word is valid according to the criteria
    private static boolean isValidWord(String word, Set<String> words) {
        if (word.length() == 1 && (word.equals("I") || word.equals("A"))) {
            return true;
        }
        if (!words.contains(word)) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            String reducedWord = word.substring(0, i) + word.substring(i + 1);
            if (isValidWord(reducedWord, words)) {
                return true;
            }
        }
        return false;
    }

    // Callable task to download words from URL
    private static class WordDownloader implements Callable<Set<String>> {
        private final String url;

        public WordDownloader(String url) {
            this.url = url;
        }

        @Override
        public Set<String> call() {
            Set<String> words = new HashSet<>();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    words.add(line.trim());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return words;
        }
    }

    // Method to count total words
    private static int countTotalWords(Set<String> words) {
        return words.size();
    }
}