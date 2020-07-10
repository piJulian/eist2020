package eistbrecher;

import eistbrecher.objects.Cannon;
import eistbrecher.objects.Shot;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Cannon cannon;
    private List<Shot> shots;
    private int score;

    public Player(DisplaySize gameBoardSize){
        this.cannon = new Cannon(gameBoardSize,this);
        this.shots = new ArrayList<>();
        this.score = 13;
    }

    public Cannon getCannon() {
        return cannon;
    }
    public List<Shot> getShots(){ return this.shots;}

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
