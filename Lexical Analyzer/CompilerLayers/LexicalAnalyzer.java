package CompilerLayers;

import DataStructure.LinkedList;
import DataStructure.Node;
import FileHelper.*;
import FileHelper.IReader;
import FileHelper.IWriter;
import Tokens.*;
import java.io.*;
import java.util.StringTokenizer;

public class LexicalAnalyzer implements IWriter, IReader {
    File file;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    StringTokenizer stringTokenizer;
    SymbolTable symbolTable;
    LinkedList tokenizerTable;
    int tokenCounter;

    public LexicalAnalyzer() throws IOException {
        tokenCounter = 0;
        symbolTable = new SymbolTable();
        tokenizerTable = new LinkedList();
        delComments();
        delSpaces();
        addSymbolTable();
        tokenizer();
    }

    public void delComments() throws IOException {
        file = FileHelper.createFile("delete comments.txt");
        bufferedWriter = new BufferedWriter(new FileWriter(file));
        reader("SourceCode.txt");
        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            if (!line.contains("//") && !line.contains("/*")) {
                writer(line, true);
            }
            if (line.contains("/*")) {
                while (!line.contains("*/")) {
                    line = bufferedReader.readLine();
                }
                writer(line.substring(line.indexOf("*/") + 2), true);
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    public void delSpaces() throws IOException {
        file = FileHelper.createFile("delete spaces.txt");
        bufferedWriter = new BufferedWriter(new FileWriter(file));
        reader("delete comments.txt");
        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            stringTokenizer = new StringTokenizer(line);
            while (stringTokenizer.hasMoreTokens()) {
                String word = stringTokenizer.nextToken();
                if (Keywords.isKeyword(word)) {
                    if (word.equals("if") || word.equals("else"))
                        writer(word, false);
                    else
                        writer(word + " ", false);
                }
                else if (Keywords.isType(word)) {
                    writer(word + " ", false);
                }
                else if (word.contains(";")) {
                    writer(word, true);
                } else if (Punctuators.isPunctuator(word.charAt(0))) {
                    boolean flag = false;
                    if (word.contains(";") || word.contains("{") || word.contains("}")) {
                        flag = true;
                    }
                    writer(word, flag);
                } else if (Operators.isOperator(word.charAt(0))) {
                    writer(word, false);
                } else {
                    writer(word, false);
                }
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    public void addSymbolTable() throws IOException {
        String varName, type, word, line;
        reader("delete spaces.txt");

        while ((line = bufferedReader.readLine()) != null) {
            word = varName = type = "";
            for (int i = 0; i < line.length(); i++) {
                char chr = line.charAt(i);

                if (Operators.isOperator(chr) || Punctuators.isPunctuator(chr) || chr == ' ') {
                    if (!word.equals("") && Keywords.isType(word)) {
                        type = word;
                    } else if (!word.equals("") && !Keywords.isKeyword(word)) {
                        varName = word;
                        break;
                    }
                    word = "";
                }
                else if (!Punctuators.isPunctuator(chr) && !Operators.isOperator(chr) && chr != ' ') {
                    word += chr;
                }
            }
            if (!type.equals("") && !varName.equals(""))
                symbolTable.insert(varName, type);
        }
        bufferedReader.close();
        System.out.println("sembol tablosu gösteriliyor.");
        symbolTable.showTable();
    }

    public void tokenizer() throws IOException {
        String varName, type, word = "", line = null;
        reader("delete spaces.txt");

        while ((line = bufferedReader.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                char chr = line.charAt(i);

                if (Operators.isOperator(chr) || Punctuators.isPunctuator(chr) || chr == ' ') {

                    if (Keywords.isType(word)) {
                        tokenizerTable.addTail(new Node(0, word,"type"));
                    }

                    if(Keywords.isKeyword(word)) {
                        tokenizerTable.addTail(new Node(0, word, "keyword"));
                    }

                    if (!word.equals("") && !Keywords.isKeyword(word)) {
                        Node temp = symbolTable.lookup(word);
                        if (temp != null) {
                            tokenizerTable.addTail(new Node(temp.no, temp.varName, temp.type));
                        }
                        else {
                            try {
                                int val = Integer.valueOf(word);
                                tokenizerTable.addTail(new Node(0, word, "constant"));
                            } catch (NumberFormatException e) {}
                        }
                        word = "";
                    }

                    if (Operators.isOperator(chr)) {
                        String operatorName = Operators.operatorName(chr);
                        tokenizerTable.addTail(new Node(0, "operator", operatorName));
                        chr = ' ';
                    }

                    if (Punctuators.isPunctuator(chr)) {
                        tokenizerTable.addTail(new Node(0, String.valueOf(chr), "punctuator"));
                    }
                    tokenCounter++;
                    word = "";

                }
                else
                    word += chr;
            }

        }
        bufferedReader.close();
        tokenizerTable.show();
    }




    @Override
    public void writer (String data,boolean downLine){
            try {
                bufferedWriter.write(data, 0, data.length());
                if (downLine) {
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    @Override
    public void reader (String fileName){
            try {
                file = new File(fileName);
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


