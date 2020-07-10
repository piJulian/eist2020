package eistbrecher;

import javafx.scene.image.Image;

public class ImageSize {
    private int x;
    private int y;
    private double scale;

    public ImageSize(Image image){
        this.x = image.widthProperty().intValue();
        this.y = image.heightProperty().intValue();
        this.scale = 1;
    }

    public void setScale(double scale){
        if(scale < 0) throw new IllegalArgumentException("No negative scale");
        this.scale = scale;
    }

    public int getX() {
        return (int) (x*scale);
    }

    public int getY() {
        return (int) (y*scale);
    }



}
