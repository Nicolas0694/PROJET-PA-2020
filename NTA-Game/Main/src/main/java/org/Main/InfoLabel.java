package org.Main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class InfoLabel extends Label {
    public final static String FONT_PATH = "file:///NTA-Game/Commun/src/main/resources/kenvector_future.ttf";
    public static final String BACKGROUND = "file:///NTA-Game/Commun/src/main/resources/red_panel.png";

    public InfoLabel(String text){
        setPrefWidth(400);
        setPrefHeight(50);
        setPadding(new Insets(40,40,40,40));
        setText(text);
        setWrapText(true);
        setLabelFont();
        setAlignment(Pos.CENTER);

        BackgroundImage backgroundImage = new BackgroundImage(new Image(BACKGROUND, 400, 50, true, true), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        setBackground(new Background(backgroundImage));
    }

    private void setLabelFont() {
        try {
            setFont(Font.loadFont(new FileInputStream(new File(FONT_PATH)), 23));
        } catch(FileNotFoundException e){
            setFont(Font.font("Verdana", 23));
        }
    }
}