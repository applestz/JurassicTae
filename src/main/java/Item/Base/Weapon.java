package Item.Base;

import Interfaces.Buyable;
import Interfaces.Useable;

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
}
