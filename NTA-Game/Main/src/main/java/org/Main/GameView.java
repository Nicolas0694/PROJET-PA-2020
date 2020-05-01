package org.Main;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class GameView {

    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;

    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 800;

    private Stage menuStage;
    private ImageView Perso;

    public GameView(){
        initializeStage();
        createKeyLiseteners();
    }

    private void createKeyLiseteners() {
    }

    private void initializeStage() {
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
        gameStage = new Stage();
        gameStage.setScene(gameScene);


    }

    public void createNewGame(Stage menuStage, PLUGIN choosenPlugin){
        this.menuStage = menuStage;
        this.menuStage.hide();
        gameStage.show();
    }
}
