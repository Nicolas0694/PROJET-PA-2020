package org.Commun;

import org.Commun.Board;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application  {
	
	private Board board;
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		stage.setTitle("NTA-GAME");
		Group root = new Group();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		Canvas canvas = new Canvas(512,512);
		root.getChildren().add(canvas);
		//GraphicsContext gc = canvas.getGraphicsContext2D();
		stage.sizeToScene();
		
		stage.show();
		
		
		//board = new Board(512,512);
		
		
		
		
		
		
		
	}
	
    public static void main( String[] args )
    {
        launch(args);
    }


		
		
}