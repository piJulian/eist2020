package eistbrecher;

import eistbrecher.gameview.GameBoardUI;
import eistbrecher.gameview.Toolbar;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;

import javafx.scene.control.*;


public class SpaceInvadersApplication extends Application {
	public GameBoardUI gameBoardUI;
	public Toolbar toolBar;

	public static void main(String[] args)
	{
		launch(args);
	}

	public void start(Stage stage) {

		stage.setTitle( "SpaceInvaders" );
		Group group = new Group();
		Scene scene = new Scene( group);
		stage.setScene( scene );

		//Button button = new Button("test");

		DisplaySize gameBoardSize = new DisplaySize(800,500);
		GameBoardUI gameBoardUI = new GameBoardUI(gameBoardSize,scene);
		group.getChildren().add( gameBoardUI );

		stage.show();

	}
}