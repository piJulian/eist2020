package eistbrecher;

public class DisplaySize {
    private int x;
    private int y;

    public DisplaySize(int x, int y){
        if(x < 0 || y < 0){
            throw new IllegalArgumentException("no negative BoardSize");
        }
        this.x = x;
        this.y = y;
    }


    public void scaleXTo(int xSetPoint){
        if(xSetPoint <= 0 ) throw new IllegalArgumentException("no negative x SetPoint");
        double scale = ((double)xSetPoint)/x;
        this.x = (int) (scale * x);
        this.y = (int) (scale * y);
    }

    public void scaleYTo(int ySetPoint){
        if(ySetPoint <= 0 ) throw new IllegalArgumentException("no negative y SetPoint");
        double scale = ((double)ySetPoint)/y;
        this.x = (int) (scale * x);
        this.y = (int) (scale * y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
