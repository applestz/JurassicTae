package Item.Weapon;

import Item.Base.Weapon;
import LivingThing.Player;

public class ElectricGun extends Weapon {
    //constructor
    public ElectricGun(String imgUrl, int attack, int buyPrice) {
        super("Electric Gun", imgUrl, attack, buyPrice);
    }

    //method
    @Override
    public void use(Player player) {

    }
}
