/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgvrteska;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 *
 * @author Aleksandar
 */
public class RGVrteska extends Application {
    private Vrteska vrteska=new Vrteska();
    @Override
    public void start(Stage primaryStage) {
        Group root=new Group();
        vrteska=new Vrteska();
        root.getChildren().add(vrteska);
        
        PerspectiveCamera kamera=new PerspectiveCamera(true);
        kamera.setFarClip(3000);
        translacijaKamere = new Translate(0, 0, -1000);
        kamera.getTransforms().addAll(new Rotate(-30, Rotate.X_AXIS), translacijaKamere);
        Scene scene = new Scene(root, 640, 480, true);
        scene.setCamera(kamera);
        scene.setOnScroll(e->zum(e));
        scene.setOnKeyPressed(e->promenaPolozajaDrzaca(e));
        primaryStage.setTitle("VVVV");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private Translate translacijaKamere;

    public void zum(ScrollEvent e){
        translacijaKamere.setZ(translacijaKamere.getZ()+e.getDeltaY());
    }
    
    public void promenaPolozajaDrzaca(KeyEvent e){
        switch(e.getCode()){
            case UP:
                vrteska.pomeriDrzac(-10);
                break;
            case DOWN:
                vrteska.pomeriDrzac(+10);
                break;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
