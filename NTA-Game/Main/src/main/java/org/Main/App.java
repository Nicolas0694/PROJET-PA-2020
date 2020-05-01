package org.Main;

import javafx.application.Application;
import javafx.stage.Stage;
public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        try{
            final Menu menu = new Menu();
            primaryStage = menu.getMainStage();
            primaryStage.show();
        } catch(final Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(final String[] args){
        launch(args);
    }
}