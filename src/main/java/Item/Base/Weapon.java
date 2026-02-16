package Item.Base;

import Interface.Buyable;
import Interface.Useable;

public class Weapon extends Item implements Useable, Buyable {
    public Weapon(String name, String imgUrl) {
        super(name, imgUrl);
    }
}
