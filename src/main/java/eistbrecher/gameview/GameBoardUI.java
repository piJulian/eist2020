package eistbrecher.gameview;

import eistbrecher.*;
import eistbrecher.audio.AudioPlayer;
import eistbrecher.audio.MusicService;
import eistbrecher.objects.UIEntity;
import eistbrecher.usercontrol.KeyBoardSteering;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameBoardUI extends Canvas{
	private GameBoard gameBoard;
	private KeyBoardSteering keyBoardSteering;
	private Player player;
	private GraphicsContext graphicsContext = this.getGraphicsContext2D();
	private DisplaySize gameBoardSize;
	private AnimationTimer updateThread;
	private SpaceInvadersApplication application;


	public GameBoardUI(DisplaySize gameBoardSize, Scene scene, SpaceInvadersApplication application){
		this.player = new Player(gameBoardSize);
		this.keyBoardSteering = new KeyBoardSteering(player,this,scene);
		this.gameBoardSize = gameBoardSize;
		this.gameBoard = new GameBoard(gameBoardSize,player);
		this.application = application;
		setup();
		startGame();
	}


	public void setup(){
		this.widthProperty().set(gameBoardSize.getX());
		this.heightProperty().set(gameBoardSize.getY());
	}

	public void startGame(){
		this.updateThread = new AnimationTimer() {
			@Override
			public void handle(long l) {
				if(gameBoard.isGameRunning()) {
					gameBoard.update();
					paint();
				}
				else {
					application.resume(player.getScore());
					updateThread.stop();
				}

				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		updateThread.start();
	}



	public void paint(){
		this.graphicsContext.setFill(Color.WHITE);
		graphicsContext.clearRect(0,0,gameBoardSize.getX(),gameBoardSize.getY());

		for(UIEntity uiEntity:this.gameBoard.getAttackers()){
			paintUIEntity(uiEntity);
		}

		for(UIEntity uiEntity:this.player.getShots()){
			paintUIEntity(uiEntity);
		}

		paintUIEntity(player.getCannon());
	}

	public void paintUIEntity(UIEntity uiEntity){
		SmartPosition pos = uiEntity.getSmartPosition();
		DisplaySize ds = uiEntity.getDisplaySize();
		graphicsContext.drawImage(uiEntity.getImage(),pos.getX(),pos.getY(),ds.getX(),ds.getY());
	}

	public Player getPlayer(){
		return this.player;
	}

}
