package org.plugins;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;


import javafx.stage.Stage;
import org.plugins.GameButtons;
import org.plugins.GameSubScene;
import org.plugins.GameView;
import org.plugins.InfoLabel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Menu extends Application {

    private static final int HEIGHT = 880;
    private static final int WIDTH = 1300;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    private final static int MENU_BUTTONS_X = 100;
    private final static int MENU_BUTTONS_Y = 300;
    private GameSubScene startSubscene;
    private GameSubScene creditsSubscene;
    private GameSubScene helpSubscene;
    private GameSubScene pluginChooserScene;

    private GameSubScene sceneToHide;

    List<GameButtons> menuButtons;

    List<PluginPicker> pluginList;
    private PLUGIN choosenPlugin;
    
    public Menu(){
        menuButtons = new ArrayList<>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createSubscenes();
        createButtons();
        createBackground();
        createLogo();

    }




    private void showSubScene(GameSubScene subScene){
        if(sceneToHide != null) {
            sceneToHide.moveSubscene();
        }
        subScene.moveSubscene();
            sceneToHide = subScene;
        }

    public void createSubscenes(){
        createPluginChooserSubScene();
        createHelpSubscene();
        createCreditsSubscene();

    }

    private void createHelpSubscene() {
        helpSubscene=new GameSubScene();
        mainPane.getChildren().add(helpSubscene);
        Text helpLabel = new Text("Les flèches directionnelles :\npermettent de se déplacer sur la carte.\n&\nLa barre espace :\npermet d'attaquer");
        helpLabel.setLayoutX(50);
        helpLabel.setLayoutY(55);
        InfoLabel titleHelpLabel = new InfoLabel("Les Commandes Sont : ");
        titleHelpLabel.setLayoutX(110);
        titleHelpLabel.setLayoutY(25);

        helpSubscene.getPane().getChildren().add(helpLabel);
        helpSubscene.getPane().getChildren().add(titleHelpLabel);

    }

    private void createCreditsSubscene() {
        creditsSubscene=new GameSubScene();
        mainPane.getChildren().add(creditsSubscene);
        Text creditsLabel = new Text("Ce jeu a été créé par\nNicolas Drisset,\nThomas Gauci et\nAlexis Vighi\nProfitez de cette cartouche de déconfinée\npour vous évader");
        creditsLabel.setLayoutX(50);
        creditsLabel.setLayoutY(55);
        InfoLabel titleCreditsLabel = new InfoLabel("Credits : ");
        titleCreditsLabel.setLayoutX(110);
        titleCreditsLabel.setLayoutY(25);

        creditsSubscene.getPane().getChildren().add(creditsLabel);
        creditsSubscene.getPane().getChildren().add(titleCreditsLabel);



    }

    private void createPluginChooserSubScene(){
        pluginChooserScene = new GameSubScene();
        mainPane.getChildren().add(pluginChooserScene);
        InfoLabel choosePluginLabel = new InfoLabel("Choose your plugins");
        choosePluginLabel.setLayoutX(110);
        choosePluginLabel.setLayoutY(25);
        pluginChooserScene.getPane().getChildren().add(choosePluginLabel);
        pluginChooserScene.getPane().getChildren().add(createPluginToChoose());
        pluginChooserScene.getPane().getChildren().add(createButtonToPlay());



    }

    private void addMenuButton(GameButtons button){
        button.setLayoutX(MENU_BUTTONS_X);
        button.setLayoutY(MENU_BUTTONS_Y + menuButtons.size()*100);
        menuButtons.add(button);
        mainPane.getChildren().add(button);
    }

    public void createButtons() {
        createStartButton();
        createHelpButton();
        createCreditsButton();
        createExitButton();
    }

    private void createStartButton(){
        GameButtons startButton = new GameButtons("Start");
        addMenuButton(startButton);

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Menu.this.showSubScene(pluginChooserScene);
            }
        });

    }
    private void createHelpButton(){
        GameButtons helpButton = new GameButtons("Help");
        addMenuButton(helpButton);
        helpButton.setOnAction(event -> showSubScene(helpSubscene));
    }
    private void createCreditsButton(){
        GameButtons creditsButton = new GameButtons("Credits");
        addMenuButton(creditsButton);
        creditsButton.setOnAction(event -> showSubScene(creditsSubscene));
    }
    private void createExitButton(){
        GameButtons exitButton = new GameButtons("Exit");
        addMenuButton(exitButton);

        exitButton.setOnAction(event -> mainStage.close());

    }

    private void createBackground(){
        Image backgroundImage = new Image("file:Commun/src/main/resources/background.png", 1080,728, false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(background));
    }

    private void createLogo(){
        ImageView logo = new ImageView("file:Commun/src/main/resources/NTA_ITSINTHEGAME.png");
        logo.setLayoutX(1);
        logo.setLayoutY(10);

        logo.setOnMouseEntered(event -> logo.setEffect(new DropShadow()));

        logo.setOnMouseExited(event -> logo.setEffect(null));

        mainPane.getChildren().add(logo);
    }
    
    public ChoiceBox setPlugin(){
        ChoiceBox box = new ChoiceBox();
        final Slider sliderEnemy = new Slider(0, 15, 1);

        sliderEnemy.setShowTickLabels(true);
        sliderEnemy.setShowTickMarks(true);
        sliderEnemy.setMajorTickUnit(1);
        sliderEnemy.setMinorTickCount(1);
        sliderEnemy.setBlockIncrement(11);
        Enemy.setEnnemy(sliderEnemy.getValue());
        Label label = new Label("Nombre d'ennemies:");
        box.setLayoutX(300-(118*2));
        box.setLayoutY(100);
        return box;
    }

    private HBox createPluginToChoose(){
        HBox box = new HBox();
        box.setSpacing(20);
        pluginList = new ArrayList<>();
        for(PLUGIN plugin: PLUGIN.values()){
            PluginPicker pluginToPick = new PluginPicker(plugin);
            pluginList.add(pluginToPick);
            box.getChildren().add(pluginToPick);
            pluginToPick.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    for(PluginPicker plugin : pluginList){
                        plugin.setIsCircleChoosen(false);
                    }
                    pluginToPick.setIsCircleChoosen(true);
                    choosenPlugin = pluginToPick.getPlugin();
                }
            });
        }
        box.setLayoutX(300-(118*2));
        box.setLayoutY(100);
        return box;
    }

    private GameButtons createButtonToPlay(){
        GameButtons playButton = new GameButtons ("Play");
        playButton.setLayoutX(350);
        playButton.setLayoutY(300);

        playButton.setOnAction(event -> {
            if (choosenPlugin != null){
                GameView gameManager = new GameView();
                gameManager.createNewGame(mainStage, choosenPlugin);
            }
        });
        return playButton;
    }

    public Stage getMainStage(){
        return mainStage;
    }

    @Override
    public void start(Stage primaryStage) {


    }

}

