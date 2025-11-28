import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

/**
 * SylvesterThreeThreads
 *
 * This class demonstrates using three threads to output different types of random characters
 * to a JavaFX TextArea. Each thread generates a different type of character:
 *  - Letters (a-z)
 *  - Numbers (0-9)
 *  - Special characters (!, @, #, $, %, &, *)
 *
 * Each thread generates a minimum of 10,000 characters.
 *
 * @author Sylvester
 */
public class SylvesterThreeThreads extends Application {

    private static final int CHAR_COUNT = 10000;
    private static final String SPECIAL_CHARS = "!@#$%&*";

    private TextArea textArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setEditable(false);

        VBox root = new VBox(textArea);
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Three Threads Character Generator");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Start the three threads
        new Thread(new LetterThread()).start();
        new Thread(new NumberThread()).start();
        new Thread(new SpecialCharThread()).start();
    }

    // Thread that generates random letters
    class LetterThread implements Runnable {
        @Override
        public void run() {
            Random random = new Random();
            for (int i = 0; i < CHAR_COUNT; i++) {
                char letter = (char) ('a' + random.nextInt(26));
                appendText(String.valueOf(letter));
            }
        }
    }

    // Thread that generates random numbers
    class NumberThread implements Runnable {
        @Override
        public void run() {
            Random random = new Random();
            for (int i = 0; i < CHAR_COUNT; i++) {
                char number = (char) ('0' + random.nextInt(10));
                appendText(String.valueOf(number));
            }
        }
    }

    // Thread that generates random special characters
    class SpecialCharThread implements Runnable {
        @Override
        public void run() {
            Random random = new Random();
            for (int i = 0; i < CHAR_COUNT; i++) {
                char special = SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length()));
                appendText(String.valueOf(special));
            }
        }
    }

    /**
     * Appends text to the TextArea safely from any thread.
     *
     * @param str the text to append
     */
    private void appendText(String str) {
        javafx.application.Platform.runLater(() -> textArea.appendText(str));
    }
}
