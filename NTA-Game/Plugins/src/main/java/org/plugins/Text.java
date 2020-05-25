package org.plugins;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import org.commun.TextInterface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Text extends Label implements TextInterface {
    public final static String FONT_PATH = "file:Commun/src/main/resources/kenvector_future.ttf";

    public Text(String text){
        setPrefWidth(500);
        setPrefHeight(300);
        setText(text);
        setWrapText(true);
        setLabelFont();
        setAlignment(Pos.CENTER);
    }

    private void setLabelFont() {
        try {
            setFont(Font.loadFont(new FileInputStream(new File(FONT_PATH)), 23));
        } catch(FileNotFoundException e){
            setFont(Font.font("Verdana", 23));
        }
    }
}

