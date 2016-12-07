package assignment2;

import java.security.SecureRandom;

public class CharRandom {

    private final SecureRandom rnd;

    public CharRandom() {
        this.rnd = new SecureRandom();
    }

    private final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
        'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y', 'Z'};

    public char nextChar() {
        int charNum = rnd.nextInt(26);

        return alphabet[charNum];
    }
}
