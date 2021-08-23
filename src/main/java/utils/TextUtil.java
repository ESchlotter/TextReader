package utils;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public final class TextUtil {

    /**
     * Gets file from file path provided and returns as String
     * @param filePath
     * @return
     */
    public static String readText(String filePath) {
        String content = null;

        URL url = Resources.getResource(filePath);
        try {
            content = Resources.toString(url, StandardCharsets.UTF_8);
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("ERROR: Invalid file");
        }
        return content;
    }

}
