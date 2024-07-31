import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReadMarkdownFileToString {
    public static String escapeString(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder escaped = new StringBuilder();
        for (char c : str.toCharArray()) {
            if(c == '\"')
                escaped.append("\\\"");
            else
                escaped.append(c);
        }
        return escaped.toString();
    }

    public static void main(String[] args) {
        String name = "thirdUnit";
        String filePath = name + ".md";
        try {
            String result = Files.readString(Path.of(filePath));
            createTextFile(name + ".txt", escapeString(result));
        } catch (IOException e) {
            System.out.println(e);
        }

        // Now you can store `markdownContent` in your database
        // Example database storage code goes here
    }

    public static void createTextFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("File created successfully: " + fileName);
        } catch (IOException e) {
            System.err.println("An error occurred while creating the file: " + e.getMessage());
        }
    }
}
