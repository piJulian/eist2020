package eistbrecher;

import eistbrecher.audio.AudioPlayer;
import eistbrecher.gameview.GameBoardUI;
import eistbrecher.gameview.Toolbar;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.*;

import javafx.scene.control.*;


public class SpaceInvadersApplication extends Application {
	public Toolbar toolBar;
	public Stage stage;
	public Scene scene;
	public Group group;
	public AudioPlayer audioPlayer;

	public int score = 0;
	public static void main(String[] args)
	{
		launch(args);
	}

	public void start(Stage stage) {
		stage.setTitle( "SpaceInvaders" );
		this.stage = stage;
		resume(0);
		stage.show();
	}

	public void resume(int newScore){
		if(newScore > this.score)
			this.score = newScore;

		if(this.audioPlayer != null)
			this.audioPlayer.stopBackgroundMusic();

		Button button= new Button("START");
		Label label= new Label("Welcome to SpaceInvaders!");
		Label score= new Label("current score: " + this.score);

		ToggleGroup music = new ToggleGroup();
		RadioButton music1 = new RadioButton("Music Version 1");
		music1.setToggleGroup(music);
		RadioButton music2 = new RadioButton("Music Version 2");
		music2.setToggleGroup(music);

		Font buttonFont = new Font(50);
		Font labelFont = new Font(50);
		Font scoreFont = new Font(50);
		Font radioFont = new Font(20);

		label.setFont(labelFont);
		score.setFont(scoreFont);

		music1.setFont(radioFont);
		music2.setFont(radioFont);
		music.selectToggle(music1);

		button.setFont(buttonFont);
		button.setOnAction(e -> this.newGame(music.getSelectedToggle().equals(music1)));

		VBox layout1 = new VBox(20);
		layout1.setAlignment(Pos.CENTER);
		layout1.getChildren().addAll(label,score,button,music1,music2);

		Scene startScene= new Scene(layout1, 800, 500);
		stage.setScene( startScene );
	}

	public void newGame(boolean music){
		this.audioPlayer = new AudioPlayer(music);
		this.audioPlayer.playBackgroundMusic();
		this.group = new Group();
		this.scene = new Scene(this.group);
		DisplaySize gameBoardSize = new DisplaySize(800,500);
		GameBoardUI gameBoardUI = new GameBoardUI(gameBoardSize,scene,this);
		group.getChildren().add( gameBoardUI );
		stage.setScene(scene);
	}
}