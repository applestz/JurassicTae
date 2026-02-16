package Item.Base;

import Interfaces.Buyable;
import Interfaces.Useable;
import LivingThing.Player;

public abstract class Potion extends Item implements Useable, Buyable {
    private final int buyPrice;

    public Potion(String name, String imgUrl, int buyPrice) {
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
