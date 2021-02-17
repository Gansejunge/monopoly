package monopoly.gui;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class GameWindow extends Application{

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        //Creating an image
        System.out.println("cwd" + System.getProperty("user.dir"));
        Image image = new Image(new FileInputStream("./img/logo.png"));
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(455);
        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);
        HBox hboxImage = new HBox();
        hboxImage.setAlignment(Pos.CENTER);
        hboxImage.getChildren().add(imageView);
        Scene scene = new Scene(hboxImage, 600, 500);
        stage.setTitle("Monopoly");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
