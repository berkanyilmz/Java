package FileHelper;

import java.io.*;

public class FileHelper {
    public static File createFile(String fileName) {
        File file = new File(fileName);
        try {
            file.createNewFile();
            System.out.println("File is created");
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File is not created");
            return null;
        }
    }
}
