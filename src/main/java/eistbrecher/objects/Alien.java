package eistbrecher.objects;

import eistbrecher.DisplaySize;
import eistbrecher.SmartPosition;

public class Alien extends UIEntity {
    private static String imageFile= "/img/alien.png";

    public Alien(DisplaySize gameBoardSize){
        super(gameBoardSize);

        setImage(imageFile);
        setRelativeScale(0.1);
        setSpeed(2);
        setScore(1);

        setDisplaySize(gameBoardSize,this.getImage(),this.getRelativeScale());
        SmartPosition smartPosition = new SmartPosition((int) (Math.random()*gameBoardSize.getX()/2), (int)(gameBoardSize.getY()/2*Math.random()),gameBoardSize,this.getDisplaySize());
        setSmartPosition(smartPosition);

    }

    @Override
    public void move(int speed) {
        double random = Math.random();

        if(random < 0.25){
            this.getSmartPosition().moveXBoundless(speed);
            this.getSmartPosition().moveYBoundless(speed);
        }

        else if(random < 0.5){
            this.getSmartPosition().moveXBoundless(-speed);
            this.getSmartPosition().moveYBoundless(speed);
        }

        else if(random < 0.75){
            this.getSmartPosition().moveXBoundless(speed);
            this.getSmartPosition().moveYBoundless(-speed);
        }
        else{
            this.getSmartPosition().moveXBoundless(-speed);
            this.getSmartPosition().moveYBoundless(-speed);
        }
    }

}
