package Tokens;

public class Punctuators {

    static char punctuators[] = {
            '_', '{', '}', '[', ']', '(', ')', '.', ';'
    };

    public static boolean isPunctuator(char chr) {

        for (char i:punctuators) {
            if (i == chr)
                return true;
        }
        return false;
    }
}
