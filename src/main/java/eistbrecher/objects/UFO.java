package eistbrecher.objects;

import eistbrecher.DisplaySize;
import eistbrecher.SmartPosition;


public class UFO extends UIEntity {
    private String imageFile = "img/ufo.png";

    public UFO(DisplaySize gameBoardSize){
        super(gameBoardSize);

        setImage(imageFile);
        setRelativeScale(0.15);
        setSpeed(1);
        setScore(5);
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
