package Item.Potion;

import Item.Base.Potion;
import LivingThing.Player;

public class HealPotion extends Potion {
    //constructor
    public HealPotion(String imgUrl, int buyPrice) {
        super("Heal", imgUrl, buyPrice);
    }

    //method
    @Override
    public void use(Player player) {

    }
}
