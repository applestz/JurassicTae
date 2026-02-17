package Item.Weapon;

import Item.Base.Weapon;
import LivingThing.Player;

public class Noose extends Weapon {
    //constructor
    public Noose(String imgUrl, int attack, int buyPrice) {
        super("Noose", imgUrl, attack, buyPrice);
    }

    //method
    @Override
    public void use(Player player) {

    }
}
