import java.io.*;

public class WordCounter {
    public static void main(String[] args) {
        String inputFile = "sample.txt";
        String outputFile = "wordcount.txt";

        try {
            // Create the input file with sample text.
            BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
            writer.write("Java is simple to learn.");
            writer.newLine();
            writer.write("Practice makes programming better.");
            writer.close();

            // Read the file and count words.
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            int count = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (!line.isEmpty()) {
                    String[] words = line.split("\\s+");
                    count += words.length;
                }
            }
            reader.close();

            // Write the result to another file.
            BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
            out.write("Total words = " + count);
            out.close();

            System.out.println("Word count written to " + outputFile);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
