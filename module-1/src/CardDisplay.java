import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDisplay extends Application {

    private static final int CARD_COUNT = 52;
    private static final int DISPLAY_COUNT = 4;
    private static final String CARD_PATH = "";

    private HBox cardBox;

    @Override
    public void start(Stage primaryStage) {
        cardBox = new HBox(10);
        cardBox.setStyle("-fx-alignment: center;");

        // Initial display
        displayRandomCards();

        // Refresh button with Lambda expression
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> displayRandomCards());

        BorderPane root = new BorderPane();
        root.setCenter(cardBox);
        root.setBottom(refreshButton);
        BorderPane.setAlignment(refreshButton, javafx.geometry.Pos.CENTER);
        root.setStyle("-fx-padding: 20; -fx-background-color: lightgreen;");

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Random Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayRandomCards() {
        cardBox.getChildren().clear();

        // Create a list of card indices and shuffle
        List<Integer> cards = new ArrayList<>();
        for (int i = 1; i <= CARD_COUNT; i++) {
            cards.add(i);
        }
        Collections.shuffle(cards);

        // Select first 4 cards
        for (int i = 0; i < DISPLAY_COUNT; i++) {
            try {
                Image cardImage = new Image(new FileInputStream(CARD_PATH + cards.get(i) + ".png"));
                ImageView imageView = new ImageView(cardImage);
                imageView.setFitHeight(150);
                imageView.setPreserveRatio(true);
                cardBox.getChildren().add(imageView);
            } catch (FileNotFoundException e) {
                System.out.println("Card image not found: " + cards.get(i) + ".png");
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
