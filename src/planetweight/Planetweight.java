package planetweight;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Create a GUI Java FX application that given the weight of a person on Earth
 * then calculate the weight of the person on the Moon, Venus, Mars, and
 * Jupiter. Display the calculated weights with two decimal places and make sure
 * the calculated text field values cannot be edited.
 *
 * @author Administrator
 */
public class Planetweight extends Application {

    private static final double GRAVITY_MOON = 0.17;
    private static final double GRAVITY_VENUS = 0.91;
    private static final double GRAVITY_MARS = 0.38;
    private static final double GRAVITY_JUPITER = 2.54;

    private TextField tfEarth, tfMoon, tfVenus, tfMars, tfJupiter;

    @Override
    public void start(Stage primaryStage) {
        Label lbTitle = new Label("How Much Do I Weigh?");
        lbTitle.setStyle("-fx-font-size: 24pt; -fx-text-fill: #ff0000;");
        HBox hBoxTitle = new HBox();
        hBoxTitle.setAlignment(Pos.CENTER);
        hBoxTitle.getChildren().add(lbTitle);

        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-hgap: 10; -fx-vgap: 10; -fx-padding: 20; -fx-alignment: center");

        Label lbEarth = new Label("Earth");
        lbEarth.setStyle("-fx-font-size: 18pt; -fx-text-fill: #0000ff;");
        gridPane.add(lbEarth, 0, 0);

        tfEarth = new TextField();
        tfEarth.setPromptText("Enter your weight");
        gridPane.add(tfEarth, 1, 0);

        Label lbMoon = new Label("Moon");
        lbMoon.setStyle("-fx-font-size: 18pt; -fx-text-fill: #0000ff;");
        gridPane.add(lbMoon, 0, 1);

        tfMoon = new TextField();
        tfMoon.setEditable(false);
        gridPane.add(tfMoon, 1, 1);

        // add other planets here later
        
        Button btn = new Button();
        btn.setText("Calculate");
        btn.setStyle("-fx-font-size: 18pt; -fx-padding: 10; -fx-text-fill: #0000ff;");
        btn.setOnAction(e -> calculate());
        
        HBox hBoxBtn = new HBox();
        hBoxBtn.setAlignment(Pos.CENTER);
        hBoxBtn.getChildren().add(btn);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-padding: 20");
        borderPane.setTop(hBoxTitle);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(hBoxBtn);

        Scene scene = new Scene(borderPane);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void calculate(){
        double weight = Double.parseDouble(tfEarth.getText());
        double moonWeight = weight * GRAVITY_MOON;
        tfMoon.setText(String.format("%.2f", moonWeight));
        // do other planets here...
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}