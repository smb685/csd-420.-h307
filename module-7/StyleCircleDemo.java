import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class StyleCircleDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Circle 1 - white/black style class
        Circle c1 = new Circle(40);
        c1.getStyleClass().add("plaincircle");

        // Circle 2 - white/black style class
        Circle c2 = new Circle(40);
        c2.getStyleClass().add("plaincircle");

        // Circle 3 - red (using ID)
        Circle red = new Circle(40);
        red.setId("redcircle");

        // Circle 4 - green (using ID)
        Circle green = new Circle(40);
        green.setId("greencircle");

        HBox pane = new HBox(20);
        pane.getChildren().addAll(c1, c2, red, green);

        Scene scene = new Scene(pane, 400, 150);

        // Load external CSS
        scene.getStylesheets().add(getClass().getResource("mystyle.css").toExternalForm());

        primaryStage.setTitle("Circle Style Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
