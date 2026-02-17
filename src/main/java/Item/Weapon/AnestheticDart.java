package Item.Weapon;

import Item.Base.Weapon;
import LivingThing.Player;

public class AnestheticDart extends Weapon {
    //constructor
    public AnestheticDart(String imgUrl, int attack, int buyPrice) {
        super("Anesthetic Dart", imgUrl, attack, buyPrice);
    }


    //method
    @Override
    public void use(Player player) {

    }
}
