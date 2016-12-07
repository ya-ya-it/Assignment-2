package assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class WordSearch {

    private final char[][] puzzleBoard;
    private final ArrayList<String> wordList;
    boolean wordValidation;

    /**
     * This is a constructor for WordSearch class. It prompt user to enter a
     * grid size, build a grid for puzzle and fill it with empty spaces.
     */
    public WordSearch() {
        int size = promptSize();

        puzzleBoard = new char[size][size];
        for (char[] puzzle : puzzleBoard) {
            Arrays.fill(puzzle, ' ');
        }

        wordList = new ArrayList<>();
    }

    /**
     * This method prompts user to enter a number of words and validates it.
     * Validation: - size must be in range 2-20; - size must be a number;
     *
     * @return size;
     */
    private int promptSize() {
        int size = 0;

        while (size < 5 || size > 20) {

            Scanner keyboard = new Scanner(System.in);
            System.out.print("How many words do you want to store? ");

            try {
                size = keyboard.nextInt();
                if (size < 5 || size > 20) {
                    System.out.print("Valid inputs are 5-20.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Sorry, only integers 5-20 are valid.");
            }
        }
        return size;
    }

    /**
     * This method prompts user to enter a word, changes it to UpperCase,
     * validate it, using validateInput method, and save word to ArrayList,
     * using saveWordToArray method.
     *
     * @return word;
     */
    public String getWords() {
        String word = " ";
        Scanner keyboard = new Scanner(System.in);
        for (char[] wordInList : puzzleBoard) {
            System.out.println("Enter a word you want to store: ");
            wordValidation = true;

            while (wordValidation == true) {
                try {
                    word = keyboard.nextLine().toUpperCase().trim();
                    validateInput(word);
                } catch (IllegalArgumentException ex) {
                    System.out.println("Please, enter another words you want to store: ");
                }
            }
            saveWordToArray(word);
        }
        showList(wordList);
        return word;
    }

    /**
     * This method save and display words in ArrayList.
     *
     * @param word - word which user entered;
     * @return list of words;
     */
    private ArrayList<String> saveWordToArray(String word) {

        wordList.add(word);
        Collections.sort(wordList);
        return wordList;
    }

    /**
     * This method validates the word, which user entered, saves it into
     * ArrayList and sorts it alphabetically. Validation: - word must be the
     * same size as a size of an ArrayList; - word must have more than 1 letter;
     * - word must be unique (it shouldn't repeat); - word mustn't contain
     * spaces;
     *
     * @param word - word which user entered;
     */
    private void validateInput(String word) {

        if (word.length() <= 1) {
            System.out.println("Valid word must have at least 2 characters");
            throw new IllegalArgumentException("valid word must have at least 2 characters");
        }

        if (word.length() > puzzleBoard.length) {
            System.out.println("Valid word is too long. It must have " + puzzleBoard.length
                    + " characters or less");
            throw new IllegalArgumentException("valid word is too long. "
                    + "It must have 20 characters or less");

        }
        for (String wordInList : wordList) {
            if (word.equals(wordInList)) {
                System.out.println("Word is already in the list");
                throw new IllegalArgumentException("word is already in the list");
            }
        }
        if (word.contains(" ")) {
            System.out.println("Word shouldn't contain spaces");
            throw new IllegalArgumentException("word shouldn't contain spaces");
        }

        wordValidation = false;
    }

    /**
     * This method convert list of words to String and display it to the screen.
     *
     * @param wordList - list of words;
     * @return wordString;
     */
    private String showList(ArrayList<String> wordList) {
        String word = " ";
        for (String wordInList : wordList) {
            word += wordInList + ("\n");
        }
        System.out.println(word);
        return word;
    }

    public void fillListWithWords() {
        Random rnd = new Random();
        for (int i = 0; i < puzzleBoard.length; i++) {
            int position = rnd.nextInt(puzzleBoard.length - wordList.get(i).length() + 1);
            for (int a = 0; a < wordList.get(i).length(); a++) {
                puzzleBoard[a + position][i] = wordList.get(i).charAt(a);
            }
        }
    }

    public void fillEmpties() {
        CharRandom charRnd = new CharRandom();
        for (char[] puzzleBoard1 : puzzleBoard) {
            for (int col = 0; col < puzzleBoard.length; col++){
                if (puzzleBoard1[col] == ' '){
                    puzzleBoard1[col] = charRnd.nextChar();
                }
            }
        }
    }
    
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        
        for (char[] table : puzzleBoard) {
            stringBuilder.append("\n");
            for (int i = 0; i < puzzleBoard.length; i++){
                stringBuilder.append(puzzleBoard[i]).append(' ');
            }
        }
        
        stringBuilder.append("\n");
        stringBuilder.append("Here are some words to find: ");
        stringBuilder.append("\n");
        
        for (String word : wordList) {
            stringBuilder.append(word);
            stringBuilder.append("\n");
        }
        
        return stringBuilder.toString();
    }
}
