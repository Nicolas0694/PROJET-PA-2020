package org.plugins;


import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;
import org.commun.GameButtonsInterface;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class GameButtons extends Button implements GameButtonsInterface {

    private final String FONT_PATH = "//Commun/src/main/resources/kenvector_future.ttf";
    private final String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('file:Commun/src/main/resources/Pressed.png');";
    private final String BUTTON_FREE_STYLE = "-fx-background-color: transparent;-fx-background-image: url('file:Commun/src/main/resources/Unpress.png');";

    public GameButtons(String text) {
        setText(text);
        setButtonFont();
        setPrefWidth(190);
        setPrefHeight(49);
        setStyle(BUTTON_FREE_STYLE);
        initializeButtonListeners();
    }

    @Override
    public void setButtonFont() {
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
        } catch (FileNotFoundException e) {
            setFont(Font.font("Verdana", 23));
        }
    }
    @Override
    public void setButtonPressedStyle() {
        setStyle(BUTTON_PRESSED_STYLE);
        setPrefHeight(45);
        setLayoutY(getLayoutY() + 4);
    }

    @Override
    public void setButtonReleasedStyle() {
        setStyle(BUTTON_FREE_STYLE);
        setPrefHeight(49);
        setLayoutY(getLayoutY() - 4);
    }

    @Override
    public void initializeButtonListeners(){

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

