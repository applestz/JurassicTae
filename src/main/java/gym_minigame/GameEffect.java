package gym_minigame;

import javafx.animation.PauseTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GameEffect {

    private final Image effectImage;
    private final double size;
    private final double durationSeconds;

    public GameEffect(String resourcePath, double size, double durationSeconds) {
        this.size = size;
        this.durationSeconds = durationSeconds;

        this.effectImage = new Image(
                getClass().getResourceAsStream(resourcePath)
        );
    }

    public void playRandomNoLane(
            Pane root,
            double sceneWidth,
            double sceneHeight,
            double laneStartX,
            double laneWidth
    ) {

        ImageView effectView = new ImageView(effectImage);
        effectView.setFitWidth(size);
        effectView.setPreserveRatio(true);

        double laneLeft = laneStartX;
        double laneRight = laneStartX + laneWidth;

        double randomX;

        do {
            randomX = Math.random() * (sceneWidth - size);
        }
        while (randomX > laneLeft - size && randomX < laneRight);

        double randomY = Math.random() * (sceneHeight - size);

        effectView.setLayoutX(randomX);
        effectView.setLayoutY(randomY);

        root.getChildren().add(effectView);

        javafx.animation.PauseTransition delay =
                new javafx.animation.PauseTransition(
                        javafx.util.Duration.seconds(3)
                );

        delay.setOnFinished(e -> root.getChildren().remove(effectView));
        delay.play();
    }
}