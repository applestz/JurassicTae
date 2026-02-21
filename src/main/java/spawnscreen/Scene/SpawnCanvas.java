package spawnscreen.Scene;

import spawnscreen.LivingThing.Player;
import spawnscreen.Location.*;
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
    private boolean fWasPressed = false;
    private boolean showEnterShop = false,showEnterSell = false,showEnterGym = false,showEnterUfo = false;

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

        showEnterShop = player.isNear(shop);
        showEnterGym = player.isNear(gym);
        showEnterSell = player.isNear(zoo);
        showEnterUfo = player.isNear(ufo);

        // 🔥 ENTER LOGIC (Fixed)
        if (keyboard.isFPressed() && !fWasPressed) {

            fWasPressed = true;   // prevent spam

            if (showEnterGym) {
                GameController.getInstance().startGymMiniGame();
            }
            else if (showEnterShop) {
                GameController.getInstance().getRoot().showShopScene();
            }
            else if (showEnterSell) {
                GameController.getInstance().getRoot().showSellScene();
            }
        }

        // Reset when key released
        if (!keyboard.isFPressed()) {
            fWasPressed = false;
        }
    }

    private void render() {

        // วาด background object ทุก frame
        gc.drawImage(shopImg,shop.getxPos(),shop.getxPos(),shop.getWidth(),shop.getHeight());
        gc.drawImage(zooImg,zoo.getxPos(),zoo.getyPos(),zoo.getWidth(), zoo.getHeight());
        gc.drawImage(gymImg,gym.getxPos(),gym.getyPos(),gym.getWidth(), gym.getHeight());
        gc.drawImage(ufoImg,ufo.getxPos(),ufo.getyPos(),ufo.getWidth(), ufo.getHeight());
        // วาด player ทุก frame
        player.render(gc);

        if (showEnterShop) {
            drawPressMessage(shop);
        }else if(showEnterSell){
            drawPressMessage(zoo);
        }else if(showEnterUfo){
            drawPressMessage(ufo);
        }else if(showEnterGym){
            drawPressMessage(gym);
        }
    }

    private void drawPressMessage(Location location) {

        String text = "Press F to enter the " + location.getName();

        javafx.scene.text.Font font =
                javafx.scene.text.Font.font("Consolas", 18);

        gc.setFont(font);

        // วัดขนาดข้อความ
        javafx.scene.text.Text tempText = new javafx.scene.text.Text(text);
        tempText.setFont(font);

        double textWidth = tempText.getLayoutBounds().getWidth();
        double textHeight = tempText.getLayoutBounds().getHeight();

        double padding = 20;

        double boxWidth = textWidth + padding * 2;
        double boxHeight = textHeight + padding * 2;

        // 🔥 จัดกึ่งกลางทั้งจอ
        double boxX = location.getxPos() + (location.getWidth() /2) - (boxWidth/2);
        double boxY = location.getyPos() + (location.getHeight() /2) - (boxHeight/2);

        // 🔳 พื้นหลังดำโปร่งใส
        gc.setFill(javafx.scene.paint.Color.rgb(0, 0, 0, 0.6));
        gc.fillRoundRect(boxX, boxY, boxWidth, boxHeight, 15, 15);

        // 🔲 ขอบขาว
        gc.setStroke(javafx.scene.paint.Color.WHITE);
        gc.setLineWidth(3);
        gc.strokeRoundRect(boxX, boxY, boxWidth, boxHeight, 15, 15);

        // ✍️ ข้อความ (จัดกลางจริง)
        gc.setFill(javafx.scene.paint.Color.WHITE);
        gc.fillText(
                text,
                boxX + (boxWidth - textWidth) / 2,
                boxY + (boxHeight + textHeight / 2) / 2
        );
    }

    public Player getPlayer(){
        return player;
    }
    public Shop getShop(){return shop;}
    public Zoo getZoo(){return zoo;
    }
    public Ufo getUfo(){return ufo;}
    public Gym getGym(){return gym;}
}
