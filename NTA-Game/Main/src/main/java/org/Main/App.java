package org.Main;

import javafx.application.Application;
import javafx.stage.Stage;
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try{
            Menu menu = new Menu();
            primaryStage = menu.getMainStage();
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        launch(args);
    }
}