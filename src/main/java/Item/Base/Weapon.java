package Item.Base;

import Interface.Buyable;
import Interface.Useable;

public class Weapon extends Item implements Useable, Buyable {
    private int buyPrice;

    public Weapon(String name, String imgUrl, int buyPrice) {
        super(name, imgUrl);
        this.buyPrice = buyPrice;
    }

    @Override
    public int getBuyPrice() {
        return buyPrice;
    }
}
