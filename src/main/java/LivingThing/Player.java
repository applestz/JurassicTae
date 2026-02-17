package LivingThing;

import Interfaces.Moveable;
import Item.Base.Item;

import java.util.ArrayList;

public class Player implements Moveable {
    //field
    private final String name;
    private int money;
    private int hp;
    private int strength;
    private int exp;
    private int level;
    private ArrayList<Item> inventory;

    //constructor
    public Player() {
        this.name = "Tae";
        setMoney(0);
        setHp(100);
        setStrength(1);
        setExp(0);
        setLevel(1);
        inventory = new ArrayList<>();
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

    //method
}
