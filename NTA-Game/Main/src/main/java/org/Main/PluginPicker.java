package org.Main;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class PluginPicker extends VBox {

    private ImageView circleImage;

    private String circleChoosen = "NTA-Game/Commun/src/main/resources/grey_circle.png";

    private String circleNotChoosen = "NTA-Game/Commun/src/main/resources/grey_tickGrey.png";

    private PLUGIN plugin;
    private boolean isCircleChoosen;

    public PluginPicker(PLUGIN plugin){
        circleImage = new ImageView(circleNotChoosen);
        this.plugin=plugin;
        isCircleChoosen = false;
       // this.setAlignement(Pos.CENTER);
        this.setSpacing(20);
        this.getChildren().add(circleImage);
    }

    public PLUGIN getPlugin(){
        return plugin;
    }

    public boolean getIsCircleChoosen(){
        return isCircleChoosen;
    }

    public void setIsCircleChoosen(boolean isCircleChoosen){
        this.isCircleChoosen = isCircleChoosen;
        String pluginToSet = this.isCircleChoosen ? circleChoosen : circleNotChoosen;
        //circleImage.setPlugin(pluginToSet);
    }
}
