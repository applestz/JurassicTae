package Item.Potion;

import Item.Base.Potion;
import LivingThing.Player;

public class StrengthPotion extends Potion {
    //constructor
    public StrengthPotion(String imgUrl, int buyPrice) {
        super("Strength", imgUrl, buyPrice);
    }

    //method
    @Override
    public void use(Player player) {

    }
}
