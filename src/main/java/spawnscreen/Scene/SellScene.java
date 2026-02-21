package spawnscreen.Scene;

import spawnscreen.Item.Base.Item;
import spawnscreen.Item.Base.TamedDinosaur;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import spawnscreen.logic.GameLogic;

public class SellScene extends StackPane {

    public SellScene() {
        this.setPrefSize(600, 400);
        this.setMaxSize(600, 400);
        this.setStyle("""
            -fx-padding: 30;
            -fx-background-radius: 20;""");

        VBox shopBox = new VBox(20);
        shopBox.setAlignment(Pos.CENTER);

        shopBox.setPrefWidth(500);
        shopBox.setPrefHeight(350);

        shopBox.setStyle("""
            -fx-background-color: #2b2b2b;
            -fx-padding: 30;
            -fx-background-radius: 20;
        """);

        Label title = new Label("KHAO KHEOW ZOO");
        title.setStyle("""
        -fx-background-color: #ffcc00;
        -fx-text-fill: black;
        -fx-font-size: 24px;
        -fx-font-weight: bold;
        -fx-padding: 10 30 10 30;
        -fx-background-radius: 10;
        """);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        int col = 0;
        int row = 0;

        for (Item item : GameLogic.getInstance().getPlayer().getInventory()) {
            if(!(item instanceof TamedDinosaur)){
                continue;
            }

            ButtonSell btn = new ButtonSell(item);
            gridPane.add(btn, col, row);

            col++;

            if (col == 4) {
                col = 0;
                row++;
            }
        }

        shopBox.getChildren().addAll(title, gridPane);

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

        this.getChildren().addAll(shopBox, exitBtn);

    }
}
