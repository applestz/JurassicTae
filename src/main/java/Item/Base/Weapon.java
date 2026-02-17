package Item.Base;

import Interfaces.Buyable;
import Interfaces.Useable;
import LivingThing.Player;

public abstract class Weapon extends Item implements Useable, Buyable {
    //field
    private final int attack;
    private final int buyPrice;

    //constructor
    public Weapon(String name, String imgUrl, int attack, int buyPrice) {
        super(name, imgUrl);
        this.attack = attack;
        this.buyPrice = buyPrice;
    }

    //getter
    public int getAttack() {
        return attack;
    }

    @Override
    public int getBuyPrice() {
        return buyPrice;
    }

    //method
    @Override
    public abstract void use(Player player);
}
