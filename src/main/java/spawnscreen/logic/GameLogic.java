package spawnscreen.logic;

import spawnscreen.LivingThing.Player;

public class GameLogic {
    private static GameLogic instance;
    private Player player;
    private GameState gameState;

    private GameLogic() {
        player = new Player();
    }

    public static GameLogic getInstance() {
        if (instance == null) {
            instance = new GameLogic();
        }
        return instance;
    }

    public Player getPlayer() {
        return player;
    }

    public void update(){
        if(gameState == GameState.SPAWN){
            
        }
    }

    public void render(){

    }
}
