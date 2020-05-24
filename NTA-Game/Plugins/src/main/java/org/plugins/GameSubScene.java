package org.plugins;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class GameSubScene extends SubScene {

    private final static String FONT = "Commun/src/main/resources/kenvector_future.ttf";
    private final static String BACKGROUND = "file:Commun/src/main/resources/red_panel.png";
    private boolean isHidden;


    public GameSubScene() {
        super(new AnchorPane(), 600, 400);
        prefWidth(600);
        prefHeight(400);

        BackgroundImage image = new BackgroundImage(new Image(BACKGROUND, 600, 400, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null); //BackgroundSize.DEFAULT

        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(image));
        isHidden = true;
        setLayoutX(2000);
        setLayoutY(180);
    }

    public void moveSubscene(){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);

        if(isHidden){
        transition.setToX(-1400);
        isHidden= false;
        } else{
            transition.setToX(0);
            isHidden=true;
        }
        transition.play();

    }

    public AnchorPane getPane(){

        return(AnchorPane) this.getRoot();
    }
}
