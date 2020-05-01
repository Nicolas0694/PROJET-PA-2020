package org.Main;


import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class GameButtons extends Button{

    private final static String FONT_PATH = "file:///NTA-Game/Commun/src/main/resources/kenvector_future.ttf";
    private final String BUTTON_PRESSED = "-fx-background-color: transparent; -fx-background-image: url('NTA-Game/Commun/src/main/resources/Pressed.png')";
    private final String BUTTON_FREE = "-fx-background-image: url('NTA-Game/Commun/src/main/resources/Unpress.png')";

    public GameButtons(String text) {
        setText(text);
        setButtonFont();
        setPrefWidth(190);
        setPrefHeight(49);
        setStyle(BUTTON_FREE);
        initializeButtonListeners();
    }

    private void setButtonFont() {
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
        } catch (FileNotFoundException e) {
            setFont(Font.font("Verdana", 23));
        }
    }
    private void setButtonPressedStyle() {
        setStyle(BUTTON_PRESSED);
        setPrefHeight(45);
        setLayoutY(getLayoutY() + 4);
    }

    private void setButtonReleasedStyle() {
        setStyle(BUTTON_FREE);
        setPrefHeight(49);
        setLayoutY(getLayoutY() - 4);
    }

    private void initializeButtonListeners(){

        setOnMousePressed(event -> {
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                setButtonPressedStyle();
            }

        });
        setOnMouseReleased(event -> {
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                setButtonReleasedStyle();
            }

        });

        setOnMouseEntered(event -> setEffect(new DropShadow()));


        setOnMouseExited(event -> setEffect(null));
    }


}

