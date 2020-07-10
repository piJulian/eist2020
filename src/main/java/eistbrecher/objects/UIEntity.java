package eistbrecher.objects;

import eistbrecher.*;
import javafx.scene.image.Image;

public abstract class UIEntity implements Observable {
    private Observer observer;

    private boolean alive;
    private int speed;

    private Image image;
    private SmartPosition smartPosition;
    private DisplaySize displaySize;
    private double relativeScale;

    private int score;

    public UIEntity(DisplaySize gameBoardSize){
        this.alive = true;
    }

    public void setImage(String imageFile) {
        if(imageFile == null) throw new IllegalArgumentException("image path can't be null");
        this.image =  new Image(getClass().getResourceAsStream(imageFile));
    }

    public void setDisplaySize(DisplaySize gameBoardSize,Image image,double relativeScale){
        ImageSize imageSize = new ImageSize(image);
        this.displaySize = new DisplaySize(imageSize.getX(),imageSize.getY());
        this.displaySize.scaleXTo((int) (gameBoardSize.getX() * relativeScale));
    }

    public void setSmartPosition(SmartPosition smartPosition){
        this.smartPosition = smartPosition;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void setRelativeScale(double relativeScale) {
        this.relativeScale = relativeScale;
    }
    public void setDead(){
        this.alive = false;
    }
    public void setScore(int score){ this.score = score;}


    public boolean isAlive() {
        return this.alive;
    }
    public int getSpeed(){
        return this.speed;
    }
    public int getScore() { return score; }

    public double getRelativeScale() { return this.relativeScale; }
    public Image getImage(){return this.image;}
    public SmartPosition getSmartPosition() {
        return this.smartPosition;
    }
    public DisplaySize getDisplaySize(){return this.displaySize;}

    @Override
    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void removeObserver() {
        this.observer = null;
    }
}
