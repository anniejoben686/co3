import java.util.Scanner;

public class MarksProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter subject count:");
        int n = sc.nextInt();
        int[] marks = new int[n];

        try {
            for (int i = 0; i < n; i++) {
                System.out.print("Enter mark " + (i + 1) + ": ");
                marks[i] = sc.nextInt();
            }

            // ArrayIndexOutOfBoundsException can occur if an invalid index is used.
            System.out.println("First mark = " + marks[0]);

            int subjectCount = n;
            int sum = 0;

            for (int mark : marks) {
                sum += mark;
            }

            double average = (double) sum / subjectCount;
            System.out.println("Average = " + average);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index.");
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        } finally {
            System.out.println("Processing complete");
            sc.close();
        }
    }
}
