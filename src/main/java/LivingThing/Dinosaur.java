package LivingThing;

import Interfaces.Interactable;
import Interfaces.Moveable;

public class Dinosaur implements Moveable, Interactable {
    private String name;
    private int hp;
    private int strength;
    private int expDrop;
    private int requiredLevel;

    @Override
    public void interact(Player player) {

    }
}
