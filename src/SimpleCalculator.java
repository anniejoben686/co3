// Import the JavaFX Application class
import javafx.application.Application;

// Import Scene
import javafx.scene.Scene;

// Import the controls used in the program
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// Import layout classes
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

// Import Stage - the application window
import javafx.stage.Stage;


// SimpleCalculator is a JavaFX application
public class SimpleCalculator extends Application {

    // This method is automatically called by JavaFX
    // after the application is launched.
    @Override
    public void start(Stage stage) {

        // ------------------------------------------------
        // 1. Create TextFields for entering two numbers
        // ------------------------------------------------

        TextField number1 = new TextField();
        number1.setPromptText("Enter first number");

        TextField number2 = new TextField();
        number2.setPromptText("Enter second number");


        // ------------------------------------------------
        // 2. Create four buttons
        // ------------------------------------------------

        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplyButton = new Button("*");
        Button divideButton = new Button("/");


        // ------------------------------------------------
        // 3. Create a Label to display the result
        // ------------------------------------------------

        Label resultLabel = new Label("Result will appear here");


        // ------------------------------------------------
        // 4. Create an event handler for the Add button
        // ------------------------------------------------

        addButton.setOnAction(event -> {

            // Get the text entered in the first TextField
            String text1 = number1.getText();

            // Get the text entered in the second TextField
            String text2 = number2.getText();

            // Convert the text into numbers
            double n1 = Double.parseDouble(text1);
            double n2 = Double.parseDouble(text2);

            // Perform addition
            double result = n1 + n2;

            // Display the result
            resultLabel.setText("Result = " + result);
        });


        // ------------------------------------------------
        // 5. Event handler for the Subtract button
        // ------------------------------------------------

        subtractButton.setOnAction(event -> {

            double n1 = Double.parseDouble(number1.getText());
            double n2 = Double.parseDouble(number2.getText());

            double result = n1 - n2;

            resultLabel.setText("Result = " + result);
        });


        // ------------------------------------------------
        // 6. Event handler for the Multiply button
        // ------------------------------------------------

        multiplyButton.setOnAction(event -> {

            double n1 = Double.parseDouble(number1.getText());
            double n2 = Double.parseDouble(number2.getText());

            double result = n1 * n2;

            resultLabel.setText("Result = " + result);
        });


        // ------------------------------------------------
        // 7. Event handler for the Divide button
        // ------------------------------------------------

        divideButton.setOnAction(event -> {

            double n1 = Double.parseDouble(number1.getText());
            double n2 = Double.parseDouble(number2.getText());

            // Check whether the second number is zero
            if (n2 != 0) {

                double result = n1 / n2;

                resultLabel.setText("Result = " + result);

            } else {

                // Division by zero is not allowed
                resultLabel.setText("Cannot divide by zero");
            }
        });


        // ------------------------------------------------
        // 8. Create an HBox for the operation buttons
        // ------------------------------------------------

        // HBox arranges its components horizontally
        HBox buttonBox = new HBox(10);

        buttonBox.getChildren().addAll(
                addButton,
                subtractButton,
                multiplyButton,
                divideButton
        );


        // ------------------------------------------------
        // 9. Create the main VBox layout
        // ------------------------------------------------

        // VBox arranges components vertically
        VBox root = new VBox(10);

        // Add all components to the VBox
        root.getChildren().addAll(
                number1,
                number2,
                buttonBox,
                resultLabel
        );


        // ------------------------------------------------
        // 10. Create the Scene
        // ------------------------------------------------

        Scene scene = new Scene(root, 400, 250);


        // ------------------------------------------------
        // 11. Put the Scene on the Stage
        // ------------------------------------------------

        stage.setScene(scene);

        // Set the window title
        stage.setTitle("Simple Calculator");

        // Display the window
        stage.show();
    }


    // ------------------------------------------------
    // Main method
    // ------------------------------------------------

    public static void main(String[] args) {

        // Launch the JavaFX application
        launch(args);
    }
}

