package eistbrecher.objects;

import eistbrecher.DisplaySize;
import eistbrecher.SimplePosition;
import eistbrecher.SmartPosition;

public class Shot extends UIEntity{
    private static String imageFile= "img/shot.png";

    public Shot(DisplaySize gameBoardSize, SimplePosition simplePosition){
        super(gameBoardSize);

        setImage(imageFile);
        setRelativeScale(0.005);
        setSpeed(4);
        setScore(1);

        setDisplaySize(gameBoardSize,this.getImage(),this.getRelativeScale());

        SmartPosition smartPosition = new SmartPosition(simplePosition.getX(),simplePosition.getY(),gameBoardSize,this.getDisplaySize());
        setSmartPosition(smartPosition);


    }
    @Override
    public void move(int speed) {
        this.getSmartPosition().setY(this.getSmartPosition().getY()-speed);
    }

}
