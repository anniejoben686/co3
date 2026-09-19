import java.io.*;

public class StudentReport {
    public static void main(String[] args) {
        String inputFile = "students.txt";
        String outputFile = "report.txt";

        try {
            // Sample input file:
            // Anu,80,70,90
            // Binu,75,85,80
            // Chitra,90,88,92
            BufferedWriter sample = new BufferedWriter(new FileWriter(inputFile));
            sample.write("Anu,80,70,90");
            sample.newLine();
            sample.write("Binu,75,85,80");
            sample.newLine();
            sample.write("Chitra,90,88,92");
            sample.close();

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter report = new BufferedWriter(new FileWriter(outputFile));

            String line;
            double totalMarks = 0;
            int totalSubjects = 0;

            report.write("STUDENT REPORT");
            report.newLine();
            report.write("-----------------------------");
            report.newLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                String name = parts[0];
                double sum = 0;

                for (int i = 1; i < parts.length; i++) {
                    double mark = Double.parseDouble(parts[i]);
                    sum += mark;
                    totalMarks += mark;
                    totalSubjects++;
                }

                double average = sum / (parts.length - 1);

                report.write(name + " - Average = " + average);
                report.newLine();
            }

            double classAverage = totalMarks / totalSubjects;
            report.write("-----------------------------");
            report.newLine();
            report.write("Class Average = " + classAverage);

            reader.close();
            report.close();

            System.out.println("Report created: " + outputFile);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid mark in input file.");
        }
    }
}