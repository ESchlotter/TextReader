# TextReader

## Local Setup
Simply build and run the program in console or your IDE. You will then be asked to enter the filename.

## Explanation
The program takes the file name and looks for it in the resources folder. 

The TextProcessor takes the inputted string from the file and breaks it down into words which are then counted 
and broken down even more into characters which are counted and printed.

## Extra features and Scalability
I time boxed myself for this task, only giving myself a couple of hours. 
I would have liked to extend the filtering and the different words and what would count as a character and what wouldn't. 
I assumed that the only characters that wouldn't count would be punctuation at the end of words, also I assume that hyphenated words count as a single word.

I only used Guava for the file resource management and junit for the testing.
