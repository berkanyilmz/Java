package mp3player;

import java.io.File;
import java.io.IOException;

public class FileHelper {

    File file;
    String path;

    public static File getFile(String path) {
        return new File(path);
    }
}
