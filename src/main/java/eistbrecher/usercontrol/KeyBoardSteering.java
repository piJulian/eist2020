package eistbrecher.usercontrol;

import eistbrecher.Player;
import eistbrecher.SmartPosition;
import eistbrecher.gameview.GameBoardUI;
import eistbrecher.objects.Cannon;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class KeyBoardSteering {
    private Player player;
    private Cannon cannon;
    private GameBoardUI gameBoardUI;

    public KeyBoardSteering(Player player, GameBoardUI gameBoardUI, Scene scene){
        this.player = player;
        this.cannon = player.getCannon();
        this.gameBoardUI = gameBoardUI;
        //this.gameBoardUI.addEventHandler(KeyEvent.ANY,this.keyEventEventHandler);
        scene.addEventHandler(KeyEvent.ANY,this.keyEventEventHandler);
    }

    EventHandler<KeyEvent> keyEventEventHandler = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent keyEvent) {
            SmartPosition currentSmartPosition = cannon.getSmartPosition();

            if(keyEvent.getCode().equals(KeyCode.LEFT) || keyEvent.getCode().equals(KeyCode.A) )
                currentSmartPosition.moveXBoundless(-cannon.getSpeed());

            else if(keyEvent.getCode().equals(KeyCode.RIGHT) || keyEvent.getCode().equals(KeyCode.D))
                currentSmartPosition.moveXBoundless(cannon.getSpeed());

            else if(keyEvent.getCode().equals(KeyCode.UP) || keyEvent.getCode().equals(KeyCode.W))
                cannon.shoot(cannon.getSpeed());

            cannon.setSmartPosition(currentSmartPosition);
        }
    };

}
