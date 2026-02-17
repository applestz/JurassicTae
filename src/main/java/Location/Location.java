package Location;

import Interfaces.Interactable;
import LivingThing.Player;

public abstract class Location implements Interactable {
    private String name;
    private final int xPos;
    private final int yPos;

    public Location(String name, int xPos, int yPos) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public void interact(Player player) {

    }
}
