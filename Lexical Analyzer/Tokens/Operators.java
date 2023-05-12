package Tokens;

public class Operators {

    static char operators[] = {
            '+', '-', '*', '/', '=', '>', '<'
    };

    static String operatorNames[] = {
            "binary addition", "binary subtraction", "multiplication", "divide", "assignment", "bigger than", "less than"
    };

    public static boolean isOperator(char chr) {
        for (char i:operators) {
            if (i == chr)
                return true;
        }
        return false;
    }
    public static String operatorName(char opr) {
        for (int i = 0; i < operators.length; i++) {
            if (opr == operators[i]) {
                return operatorNames[i];
            }
        }
        return null;
    }
}
