import CompilerLayers.LexicalAnalyzer;
import com.sun.jdi.event.ExceptionEvent;

import java.io.IOException;
import java.lang.invoke.StringConcatException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        try {
            LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
