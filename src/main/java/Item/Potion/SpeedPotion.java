package Item.Potion;

import Item.Base.Potion;
import LivingThing.Player;

public class SpeedPotion extends Potion {
    //constructor
    public SpeedPotion(String imgUrl, int buyPrice) {
        super("Speed", imgUrl, buyPrice);
    }

    //method
    @Override
    public void use(Player player) {

    }
}
