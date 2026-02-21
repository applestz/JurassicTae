package spawnscreen.Scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;

public class SpawnScreen extends StackPane {

    private SellScene sellScene;
    private ShopScene shopScene;
    private InventoryPane inventoryPane;
    private SpawnCanvas spawnCanvas;

    public SpawnScreen(){

        setPrefSize(1422,800);
        setMaxSize(1422,800);
        setMinSize(1422,800);

        Image ImgBck  = new Image(getClass().getResource("/spawnscreen/background.png").toExternalForm());
        BackgroundSize size = new BackgroundSize(1440,800,false,false,false,false);

        //setBackground(new Background(new BackgroundImage(ImgBck,null,null,null,size)));

        spawnCanvas = new SpawnCanvas();
        sellScene = new SellScene();
        shopScene = new ShopScene();
        inventoryPane = new InventoryPane();

        getChildren().addAll(spawnCanvas,sellScene,shopScene,inventoryPane);

        StackPane.setAlignment(sellScene, Pos.CENTER);
        StackPane.setAlignment(shopScene, Pos.CENTER);
        StackPane.setAlignment(inventoryPane, Pos.CENTER);

        Button inventoryBtn = new Button("Inventory");
        inventoryBtn.setOnMouseClicked(e -> {
            inventoryPane.setVisible(true);
        });
        StackPane.setAlignment(inventoryBtn,Pos.TOP_RIGHT);
        StackPane.setMargin(inventoryBtn, new Insets(20));

        getChildren().add(inventoryBtn);

        sellScene.setVisible(false);
        shopScene.setVisible(false);
        inventoryPane.setVisible(false);

    }

    public void showSellScene(){
        sellScene.setVisible(true);
        sellScene.toFront();
    }

    public void hideSellScene(){
        sellScene.setVisible(false);
    }

    public void setSellScene(SellScene sellScene){
        this.getChildren().remove(sellScene);
        this.sellScene = sellScene;
        getChildren().add(sellScene);
        hideSellScene();
    }

    public void showShopScene(){
        shopScene.setVisible(true);
        shopScene.toFront();
    }

    public void hideShopScene(){
        shopScene.setVisible(false);
    }

    public void setShopScene(ShopScene shopScene){
        this.getChildren().remove(shopScene);
        this.shopScene = shopScene;
        getChildren().add(shopScene);
        hideShopScene();
    }

    public void showInventory(){
        inventoryPane.setVisible(true);
        inventoryPane.toFront();
    }

    public void hideInventory(){
        inventoryPane.setVisible(false);
    }

    public void setInventoryPane(InventoryPane inventoryPane){
        this.getChildren().remove(inventoryPane);
        this.inventoryPane = inventoryPane;
        getChildren().add(inventoryPane);
        hideInventory();
    }

    public SpawnCanvas getSpawnCanvas(){
        return spawnCanvas;
    }
}
