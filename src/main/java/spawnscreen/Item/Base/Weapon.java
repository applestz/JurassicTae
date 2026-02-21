package spawnscreen.Item.Base;

import spawnscreen.Interfaces.Buyable;
import spawnscreen.Interfaces.Useable;
import spawnscreen.LivingThing.Player;

public class Weapon extends Item implements Useable, Buyable {
    private final int buyPrice;

    public Weapon(String name, String imgUrl, int buyPrice) {
        super(name, imgUrl);
        this.buyPrice = buyPrice;
    }

    @Override
    public int getBuyPrice() {
        return buyPrice;
    }

    @Override
    public void use(Player player) {

    }
}
