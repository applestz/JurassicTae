package spawnscreen.logic;

import javafx.scene.Scene;
import javafx.stage.Stage;
import spawnscreen.Scene.SpawnScreen;

public class GameController {

    private static GameController instance = new GameController();

    private Stage stage;
    private Scene mainScene;
    private SpawnScreen root;

    private KeyboardController keyboard;
    private boolean gameEnded;

    private GameController(){}

    public static GameController getInstance() {
        return instance;
    }

    // 🔥 NEW init
    public void init(Stage stage, Scene scene){
        this.stage = stage;
        this.mainScene = scene;
        keyboard = new KeyboardController(scene);
    }

    public void switchScene(Scene scene){
        stage.setScene(scene);
    }

    public void returnToMain(){
        stage.setScene(mainScene);

        if (root != null) {
            root.requestFocus();   // ✅ correct
        }
    }

    public void setRoot(SpawnScreen spawnScreen){
        this.root = spawnScreen;
    }

    public SpawnScreen getRoot(){
        return root;
    }

    public KeyboardController getKeyboard(){
        return keyboard;
    }

    public boolean isGameEnded(){
        return gameEnded;
    }
}