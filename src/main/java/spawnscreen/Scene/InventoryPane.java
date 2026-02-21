package spawnscreen.Scene;

import spawnscreen.Item.Base.Item;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import spawnscreen.logic.GameLogic;
import javafx.scene.image.Image;

public class InventoryPane extends StackPane {
    public InventoryPane() {

        this.setPrefSize(600, 400);
        this.setMaxSize(600, 400);
        this.setStyle("""
            -fx-padding: 30;
            -fx-background-radius: 20;""");

        VBox box = new VBox(20);
        box.setAlignment(Pos.CENTER);

        box.setPrefSize(500, 400);
        box.setStyle("""
            -fx-background-color: #2b2b2b;
            -fx-background-radius: 20;
            -fx-padding: 20;
        """);

        Label title = new Label("INVENTORY");
        title.setStyle("""
            -fx-text-fill: white;
            -fx-font-size: 22px;
            -fx-font-weight: bold;
        """);

        // Grid สำหรับไอเท็ม
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.TOP_CENTER);

        int col = 0;
        int row = 0;

        for (Item item : GameLogic.getInstance().getPlayer().getInventory()) {

            Pane pane = new Pane();
            pane.setPrefSize(100,100);
            Image img = new Image(getClass().getResource(item.getImgUrl()).toExternalForm());
            BackgroundSize size = new BackgroundSize(100,100,false,false,false,false);
            pane.setBackground(new Background(
                    new BackgroundImage(
                            img,
                            BackgroundRepeat.NO_REPEAT,
                            BackgroundRepeat.NO_REPEAT,
                            BackgroundPosition.CENTER,
                            size
                    )
            ));
            grid.add(pane, col, row);

            col++;
            if (col == 4) {   // 4 ช่องต่อแถว
                col = 0;
                row++;
            }
        }

        // ScrollPane ครอบ grid
        ScrollPane scrollPane = new ScrollPane(grid);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(250);

        scrollPane.setStyle("""
            -fx-background: transparent;
            -fx-background-color: transparent;
        """);

        box.getChildren().addAll(title, scrollPane);

        // 🔴 Exit Button
        Button exitBtn = new Button("X");
        exitBtn.setStyle("""
            -fx-background-color: red;
            -fx-text-fill: white;
            -fx-font-weight: bold;
        """);

        exitBtn.setOnAction(e -> this.setVisible(false));
        StackPane.setAlignment(exitBtn, Pos.TOP_RIGHT);
        StackPane.setMargin(exitBtn, new Insets(10));


        this.getChildren().addAll(box,exitBtn);
    }
}
