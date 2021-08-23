import processor.TextProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Please enter the name of the file with the .txt extension");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        if (!file.endsWith(".txt")) {
            file = "test.txt";
        }
        TextProcessor textProcessor = new TextProcessor();
        textProcessor.process(file);
    }
}
