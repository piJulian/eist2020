package eistbrecher;

import eistbrecher.gameview.GameBoardUI;
import eistbrecher.objects.Alien;
import eistbrecher.objects.Shot;
import eistbrecher.objects.UIEntity;
import eistbrecher.objects.UFO;

import java.util.ArrayList;
import java.util.List;

public class GameBoard implements Observer{
    private boolean gameRunning;
    private List<UIEntity> attackers;

    private Player player;
    private DisplaySize gameBoardSize;

    private int ufos = 2;
    private int aliens = 3;

    public GameBoard(DisplaySize gameBoardSize, Player player){
        this.gameRunning = true;
        this.attackers = new ArrayList<UIEntity>();
        this.player = player;
        this.gameBoardSize = gameBoardSize;
        setup();
    }

    public void setup(){
        for(int i = 0; i < ufos; i++ ){
            UFO ufo = new UFO(gameBoardSize);
            ufo.setObserver(this);
            this.attackers.add(ufo);

        }
        for(int i = 0; i < aliens; i++ ){
            Alien alien = new Alien(gameBoardSize);
            alien.setObserver(this);
            this.attackers.add(alien);
        }
    }

    public List<UIEntity> getAttackers(){return this.attackers;}
    public boolean isGameRunning(){
        return gameRunning;
    }

    public void addPlayerShot(Shot shot){
        player.getShots().add(shot);
    }

    @Override
    public void update() {
        if(attackers.size() == 0){
            this.gameRunning = false;
        }
        for(int i = 0;i < player.getShots().size(); i++){
            if(player.getShots().get(i).getSmartPosition().getY() < -player.getShots().get(i).getDisplaySize().getY() -  1)
                player.getShots().remove(i);
            else {
                boolean hit = false;
                for(int j = 0; j < attackers.size(); j++) {
                    if (player.getShots().get(i).getSmartPosition().checkHit(attackers.get(j).getSmartPosition())){
                        attackers.get(j).setScore(attackers.get(j).getScore() - player.getShots().get(i).getScore());
                        if(attackers.get(j).getScore() <= 0) {
                            player.setScore(player.getScore() + player.getShots().get(i).getScore() + attackers.get(j).getScore());
                            attackers.get(j).removeObserver();
                            attackers.remove(j);
                        }
                        else{
                            player.setScore(player.getScore() + player.getShots().get(i).getScore());
                        }

                        player.getShots().remove(i);
                        hit = true;
                        break;
                    }
                }
                if(!hit)
                    player.getShots().get(i).move(player.getShots().get(i).getSpeed());
            }
        }

        for(UIEntity uiEntity:attackers){
            uiEntity.move(uiEntity.getSpeed());
        }
    }
}
