package eistbrecher;

public class SmartPosition extends SimplePosition{
    private DisplaySize objectSize;
    private DisplaySize gameBoardSize;

    public SmartPosition(int x, int y, DisplaySize gameBoardSize, DisplaySize objectSize){
        super(x,y);
        if(x < 0 || y < 0 || x > gameBoardSize.getX() || y > gameBoardSize.getY()){
            throw new IllegalArgumentException("no valid Position");
        }

        this.gameBoardSize = gameBoardSize;
        this.objectSize =  objectSize;
    }

    public void moveXBoundless(int xAdd){
        this.x += xAdd;

        if(this.x > gameBoardSize.getX() - this.objectSize.getX()/2)
            this.x = -objectSize.getX()/2 + Math.abs(this.x - (gameBoardSize.getX() - this.objectSize.getX()/2));
        else if(this.x < -this.objectSize.getX()/2)
            this.x = gameBoardSize.getX() - objectSize.getX()/2 - Math.abs(this.objectSize.getX()/2 + this.x);
        else
            this.x += xAdd;
    }

    public void moveYBoundless(int yAdd){
        this.y += yAdd;

        if(this.y > gameBoardSize.getY() - this.objectSize.getY()/2)
            this.y = -objectSize.getY()/2 + Math.abs(this.y - (gameBoardSize.getY() - this.objectSize.getY()/2));
        else if(this.y < -this.objectSize.getY()/2)
            this.y= gameBoardSize.getY() - objectSize.getY()/2 - Math.abs(this.objectSize.getY()/2 + this.y);
        else
            this.y += yAdd;
    }

    public int getLeftXEdge(){
        return this.getX()-this.objectSize.getX();
    }

    public int getRightXEdge(){
        return this.getX()+this.objectSize.getX();
    }

    public int getLeftYEdge(){
        return this.getY()-this.objectSize.getY();
    }

    public int getRightYEdge(){
        return this.getY()+this.objectSize.getY();
    }


    public boolean checkHit(SmartPosition smartPosition){

        if(this.getRightXEdge() < smartPosition.getLeftXEdge())
            return false;

        else if(smartPosition.getRightXEdge() < this.getLeftXEdge())
            return false;

        else if(this.getRightYEdge() < smartPosition.getLeftYEdge())
            return false;

        else if(smartPosition.getRightYEdge() < this.getLeftYEdge())
            return false;

        return true;
    }

    public void moveX(int xAdd){
        this.x += xAdd;
    }

    public void moveY(int yAdd){
        this.y += yAdd;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
