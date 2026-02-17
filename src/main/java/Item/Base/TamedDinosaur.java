package Item.Base;

import Interfaces.Sellable;

public class TamedDinosaur extends Item implements Sellable {
    //field
    private final int sellPrice;

    //constructor
    public TamedDinosaur(String name, String imgUrl, int sellPrice) {
        super(name, imgUrl);
        this.sellPrice = sellPrice;
    }

    //getter
    @Override
    public int getSellPrice() {
        return sellPrice;
    }
}
