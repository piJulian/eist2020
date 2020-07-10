package eistbrecher;

public interface Observable {
    public void setObserver(Observer observer);
    public void removeObserver();
    public abstract void move(int speed);
}
