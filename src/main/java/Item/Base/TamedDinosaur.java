package Item.Base;

import Interface.Sellable;

public class TamedDinosaur extends Item implements Sellable {
    private int sellPrice;

    public TamedDinosaur(String name, String imgUrl, int sellPrice) {
        super(name, imgUrl);
        this.sellPrice = sellPrice;
    }

    @Override
    public int getSellPrice() {
        return sellPrice;
    }
}
