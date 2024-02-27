TASK Requirements:
I. Да се намерят всички 9 буквени думи в английския език, за които за всяка една дума от 
решението, е вярно следното:
- възможно е да се премахне една буква от думата и да се получи валидна 8 буквена дума;
- от 8 буквената дума може да се премахне една буква и да се получи валидна 7 буквена дума;
- от 7 буквената дума може да се премахне една буква и да се получи валидна 6 буквена дума и
т.н., докато се получи еднобуквена валидна дума;
- валидните еднобуквени думи са „I“ и „A“
Може да видите пример за думата „STARTLING“ от тук: https://www.republicworld.com/whatsappquizzes-and-puzzles/riddles/what-9-letter-word-is-still-a-word-after-removing-one-letter-each-time.html
Обобщение: да се намерят всички валидни 9 буквени думи, които могат да бъдат доведени до 
еднобуквени, чрез поетапно премахване на една буква, като след всяко премахване ще получим 
наново валидна дума.
II. Задачата трябва да е оптимизирана за скорост. Ако една дума е валидна при една комбинация 
от премахване на букви, не е нужно да се проверява дали би била валидна, ако премахнем 
други букви. 
Списък с всички думи в английския език може да сe ползва от тук:
https://raw.githubusercontent.com/nikiiv/JavaCodingTestOne/master/scrabble-words.txt

Program inside has:
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




