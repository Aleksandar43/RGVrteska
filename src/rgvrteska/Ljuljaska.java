/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgvrteska;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

/**
 *
 * @author Aleksandar
 */
public final class Ljuljaska extends Group{
    private Cylinder gornjeUze,levoUze,desnoUze,precka;
    private Box sediste;
    private PhongMaterial uzeMaterijal,sedisteMaterijal,preckaMaterijal;
    public Ljuljaska(){
        uzeMaterijal=new PhongMaterial(Color.YELLOW);
        gornjeUze=new Cylinder(0.5, 20);
        gornjeUze.setMaterial(uzeMaterijal);
        gornjeUze.setTranslateY(+10);
        getChildren().add(gornjeUze);
        levoUze=new Cylinder(0.5, 20);
        levoUze.setMaterial(uzeMaterijal);
        levoUze.setTranslateY(+30);
        levoUze.setTranslateX(-5);
        getChildren().add(levoUze);
        desnoUze=new Cylinder(0.5, 20);
        desnoUze.setMaterial(uzeMaterijal);
        desnoUze.setTranslateY(+30);
        desnoUze.setTranslateX(+5);
        getChildren().add(desnoUze);
        sediste=new Box(10,1,10);
        sediste.setTranslateY(40);
        sedisteMaterijal=new PhongMaterial(Color.BROWN);
        sediste.setMaterial(sedisteMaterijal);
        getChildren().add(sediste);
        precka=new Cylinder(2, 10);
        precka.getTransforms().addAll(new Translate(0, 20, 0),new Rotate(90, Rotate.Z_AXIS));
        preckaMaterijal=new PhongMaterial(Color.RED);
        precka.setMaterial(preckaMaterijal);
        getChildren().add(precka);
    }
}
