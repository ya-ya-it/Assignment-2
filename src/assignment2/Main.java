package assignment2;

public class Main {

    public static void main(String[] args) {

        WordSearch myPuzzle = new WordSearch();
        myPuzzle.getWords();
        myPuzzle.fillListWithWords();
        myPuzzle.fillEmpties();
        System.out.print(myPuzzle.toString());
        myPuzzle.printToFile();
    }

}