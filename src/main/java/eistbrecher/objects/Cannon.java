package eistbrecher.objects;

import eistbrecher.*;

public class Cannon extends UIEntity{
    private static String imageFile= "img/shooter.png";
    private DisplaySize gameBoardSize;
    private Player player;

    public Cannon(DisplaySize gameBoardSize, Player player) {
        super(gameBoardSize);

        setImage(imageFile);
        setRelativeScale(0.2);
        setSpeed(5);
        setScore(100);

        setDisplaySize(gameBoardSize,this.getImage(),this.getRelativeScale());
        SmartPosition smartPosition = new SmartPosition((int) (gameBoardSize.getX()/2), (int)(gameBoardSize.getY()-getDisplaySize().getY()),gameBoardSize,this.getDisplaySize());
        setSmartPosition(smartPosition);

        this.player = player;
        this.gameBoardSize = gameBoardSize;
    }

    @Override
    public void move(int speed) {
    }

    public void shoot(int speed){
        SimplePosition simplePosition = new SimplePosition(this.getSmartPosition().getX()+this.getDisplaySize().getX()/2,this.getSmartPosition().getY());
        Shot shot = new Shot(gameBoardSize,simplePosition);
        player.getShots().add(shot);
        player.setScore(player.getScore()-shot.getScore());
    }

}
