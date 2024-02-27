TASK Requirements:
I. Requirements: Find all 9 letter words in the English language for which, for each word in the solution, the following is true:

it is possible to drop one letter from the word and get a valid 8 letter word;
from the 8-letter word one letter can be subtracted and a valid 7-letter word is obtained;
from the 7-letter word one letter can be subtracted and a valid 6-letter word is obtained, etc., until a one-letter valid word is obtained;
valid one letter words are "I" and "A" You can see an example of the word "STARTLING" from here: https://www.republicworld.com/whatsapp�quizzes-and-puzzles/riddles/what-9-letter-word -is-still-a-word-after-removing-one-letter-each-time.html Summary: to find all valid 9 letter words that can be reduced to one letter by removing one letter each time, like the following each removal we will get a new valid word. II. The task must be optimized for speed. If a word is valid under one combination of letter removal, there is no need to check whether it is valid if we reduce the other letters. The list of all English words can be used from here: https://raw.githubusercontent.com/nikiiv/JavaCodingTestOne/master/scrabble-words.txt

The Java Program inside contains:
1.Main Method:

The main method serves as the entry point of the program.
It creates an ExecutorService with a single thread for concurrent execution.
Then, it submits a WordDownloader task to download words from a specified URL.
After retrieving the words, it prints the total count of words obtained from the URL.
It finds valid 9-letter words among the downloaded words and prints their count.
Finally, it sorts and prints the valid 9-letter words in ascending order.

2.findValidWords Method:

This method takes a set of words as input.
It iterates through the words and identifies valid 9-letter words based on certain criteria.
Valid words are added to a set and returned.

3.isValidWord Method:

This method checks whether a given word is valid according to specific criteria.
It recursively checks if the word can be reduced to a one-letter valid word through successive letter removals.

4.WordDownloader Class:

This class implements the Callable interface to download words from a URL.
It reads each line from the URL and adds the trimmed words to a set.
The set of downloaded words is returned upon completion of the task.

5.countTotalWords Method:

This method calculates the total count of words from a given set.
It simply returns the size of the input set, representing the total count of words.
Overall, the code downloads words from a URL, finds valid 9-letter words, prints their count, sorts and prints them in ascending order, and provides a method to count the total words obtained from the URL. It effectively demonstrates concurrent execution using ExecutorService, recursive word validation, and basic file reading from a URL.




