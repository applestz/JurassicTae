package main;

import scene.IntroScene;
import spawnscreen.Scene.SpawnScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import spawnscreen.logic.GameController;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // Create Hub root
        SpawnScreen root = new SpawnScreen();

        // Create main scene
        Scene mainScene = new Scene(root, 1422, 800);

        // Initialize controller (FIXED)
        GameController.getInstance().init(stage, mainScene);
        GameController.getInstance().setRoot(root);

        stage.setTitle("Jurassic Tae");

        // Start with intro scene instead of hub
        stage.setScene(new IntroScene().getScene());

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
