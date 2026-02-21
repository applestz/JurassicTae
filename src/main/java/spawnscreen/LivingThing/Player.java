package spawnscreen.LivingThing;

import spawnscreen.Item.Base.Item;
import spawnscreen.Scene.SellScene;
import spawnscreen.Scene.SpawnScreen;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

import spawnscreen.logic.GameController;

public class Player {
    //field
    private double x, y;
    private final double WIDTH = 60;
    private final double HEIGHT = 60;
    private final String name;
    private int money;
    private int hp;
    private int strength;
    private int exp;
    private int level;
    private ArrayList<Item> inventory;
    private double speed = 2;
    private final Image playerImage = new Image(getClass().getResource("/spawnscreen/person.png").toExternalForm());

    //constructor
    public Player() {
        this.name = "Tae";
        setMoney(0);
        setHp(100);
        setStrength(1);
        setExp(0);
        setLevel(1);
        inventory = new ArrayList<>();

        this.x = 711;
        this.y = 400;
    }

    //getter & setter
    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = Math.max(0, money);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = Math.max(0, strength);
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = Math.max(0, exp);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = Math.max(1, level);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    public double getWidth() { return WIDTH; }
    public double getHeight() { return HEIGHT; }


    //method

    public void addItem(Item item){
        if(inventory.size() >= 8 )return;
        inventory.add(item);
    }

    public void move(int dirLR, int dirUD) {

        if (GameController.getInstance().isGameEnded()) return;

        this.x += dirLR * speed;
        this.y += dirUD * speed;

        // กันออกนอกจอ
        if (x < 0) x = 0;
        if (x > 1422 - WIDTH) x = 1422 - WIDTH;

        if (y < 0) y = 0;
        if (y > 800 - HEIGHT) y = 800 - HEIGHT;

        SpawnScreen spawnScreen = GameController.getInstance().getRoot();
        if(intersects(80,75,250,500)){
            spawnScreen.showShopScene();
        }else if(intersects(800,75,250,500)){
            spawnScreen.setSellScene(new SellScene());
            spawnScreen.showSellScene();
        }else if(intersects(80,450,250,500)){
            // MiniGame Start
        }else if(intersects(800,450,250,500)){
            // go to dinosour world
        }

    }

    public void render(GraphicsContext gc) {
        gc.drawImage(playerImage, x, y, WIDTH, HEIGHT);
    }

    public boolean intersects(double otherX, double otherY,
                              double otherH, double otherW) {

        return x < otherX + otherW &&
                x + WIDTH > otherX &&
                y < otherY + otherH &&
                y + HEIGHT > otherY;
    }

}
