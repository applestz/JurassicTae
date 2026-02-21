package spawnscreen.Scene;

import spawnscreen.LivingThing.Player;
import spawnscreen.Location.Gym;
import spawnscreen.Location.Shop;
import spawnscreen.Location.Ufo;
import spawnscreen.Location.Zoo;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import spawnscreen.logic.*;
import spawnscreen.logic.GameController;
import spawnscreen.logic.KeyboardController;

public class SpawnCanvas extends Canvas {
    private GraphicsContext gc ;
    private Player player;
    private Shop shop;
    private Zoo zoo;
    private Ufo ufo;
    private Gym gym;
    private Image shopImg,zooImg,ufoImg,gymImg;

    public SpawnCanvas(){
        super(1422,800);

        gc = this.getGraphicsContext2D();

        shop = new Shop();
        zoo = new Zoo();
        gym = new Gym();
        ufo = new Ufo();

        shopImg = shop.getImage();
        zooImg = zoo.getImage();
        gymImg = gym.getImage();
        ufoImg = ufo.getImage();

        player = new Player();

        startGameLoop();   // ✅ ต้องเรียก
    }

    private void startGameLoop() {

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                gc.clearRect(0,0,getWidth(),getHeight());

                update();
                render();
            }
        };

        timer.start();
    }

    private void update() {
        if (GameController.getInstance().isGameEnded()) return;

        KeyboardController keyboard =
                GameController.getInstance().getKeyboard();

        int dx = 0;
        int dy = 0;

        if (keyboard.isLeftPressed())  dx = -1;
        if (keyboard.isRightPressed()) dx = 1;
        if (keyboard.isUpPressed())    dy = -1;
        if (keyboard.isDownPressed())  dy = 1;

        player.move(dx, dy);
    }

    private void render() {

        // วาด background object ทุก frame
        gc.drawImage(shopImg,shop.getxPos(),shop.getxPos(),shop.getWidth(),shop.getHeight());
        gc.drawImage(zooImg,zoo.getxPos(),zoo.getyPos(),zoo.getWidth(), zoo.getHeight());
        gc.drawImage(gymImg,gym.getxPos(),gym.getyPos(),gym.getWidth(), gym.getHeight());
        gc.drawImage(ufoImg,ufo.getxPos(),ufo.getyPos(),ufo.getWidth(), ufo.getHeight());
        // วาด player ทุก frame
        player.render(gc);
    }

    public Player getPlayer(){
        return player;
    }
    public Shop getShop(){return shop;}
}
