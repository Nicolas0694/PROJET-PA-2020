package org.commun;

import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public interface MenuInterface {



    void createSubscenes();

    void createHelpSubscene();

    void createCreditsSubscene();

    void createPluginChooserSubScene();

    void createButtons();

    void createStartButton();

    void createHelpButton();

    void createCreditsButton();

    void createExitButton();

    void createBackground();

    void createLogo();

    Slider setPlugin();

    HBox createPluginToChoose();

    Stage getMainStage();
}
