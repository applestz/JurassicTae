package Item.Base;

import Interface.Buyable;
import Interface.Useable;

public abstract class Potion extends Item implements Useable, Buyable {
    private int buyPrice;

    public Potion(String name, String imgUrl, int buyPrice) {
        super(name, imgUrl);
        this.buyPrice = buyPrice;
    }

    @Override
    public int getBuyPrice() {
        return buyPrice;
    }
}
