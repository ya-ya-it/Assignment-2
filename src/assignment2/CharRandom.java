package assignment2;

import java.security.SecureRandom;

public class CharRandom {

    private final SecureRandom rnd;
    private final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
        'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * This is a constructor.
     */
    public CharRandom() {
        this.rnd = new SecureRandom();
    }

    /**
     * This method randomly picks up a letter from the English alphabet in Upper
     * Case.
     *
     * @return letter as a char in Upper Case
     */
    public char nextChar() {
        int charNum = rnd.nextInt(26);

        return alphabet[charNum];
    }
}
