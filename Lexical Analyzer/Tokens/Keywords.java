package Tokens;

public class Keywords {
    static String keywords[] = {
            "package",
            "import",
            "public",
            "class",
            "if",
            "else",
            "static",
            "void",
            "main",
    };

    public static boolean isKeyword(String str) {
        str = str.trim();
        for (String i: keywords) {
            if (i.equals(str))
                return true;
        }
        return false;
    }

    public static boolean isType(String str) {
        if (str.equals("int") || str.equals("float") ||
            str.equals("double") || str.equals("String") ||
            str.equals("char"))
            return true;
        return false;
    }


}
