/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgvrteska;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

/**
 *
 * @author Aleksandar
 */
public final class Vrteska extends Group{
    private Cylinder osnova,podloga1,podloga2,podloga3,granicnik,drzacValjak;
    private Group drzac;
    private Cylinder[] drzaciLjuljaski=new Cylinder[10];
    private Ljuljaska[] ljuljaske=new Ljuljaska[10];
    private RotateTransition rotacijaDrzaca;
    private Rotate rotacijaLjuljaski;
    public Vrteska(){
        osnova=new Cylinder(12, 350);
        PhongMaterial osnovaMaterijal=new PhongMaterial();
        osnovaMaterijal.setDiffuseColor(Color.BLUE);
        osnova.setMaterial(osnovaMaterijal);
        getChildren().add(osnova);
        podloga1=new Cylinder(200, 5);
        podloga1.setTranslateY(185);
        PhongMaterial podlogaMaterijal=new PhongMaterial(Color.GREY);
        podloga1.setMaterial(podlogaMaterijal);
        getChildren().add(podloga1);
        podloga2=new Cylinder(175, 5);
        podloga2.setTranslateY(180);
        podloga2.setMaterial(podlogaMaterijal);
        getChildren().add(podloga2);
        podloga3=new Cylinder(150, 5);
        podloga3.setTranslateY(175);
        podloga3.setMaterial(podlogaMaterijal);
        getChildren().add(podloga3);
        granicnik=new Cylinder(20, 10);
        granicnik.setTranslateY(-180); //visina podloge / 2 + visina granicnika / 2
        PhongMaterial granicnikMaterijal=new PhongMaterial(Color.RED);
        granicnik.setMaterial(granicnikMaterijal);
        getChildren().add(granicnik);
        drzac=new Group();
        getChildren().add(drzac);
        drzacValjak=new Cylinder(40, 10);
        PhongMaterial drzacMaterijal=new PhongMaterial(Color.RED);
        drzacValjak.setMaterial(drzacMaterijal);
        drzac.getChildren().add(drzacValjak);
        rotacijaLjuljaski=new Rotate((drzac.getTranslateY()-120)/300*60, Rotate.Z_AXIS);
        for(int i=0;i<drzaciLjuljaski.length;i++){
            drzaciLjuljaski[i]=new Cylinder(5, 100);
            drzaciLjuljaski[i].getTransforms().addAll(new Rotate(90, Rotate.X_AXIS),new Rotate(i*360/drzaciLjuljaski.length, Rotate.Z_AXIS),new Translate(0, -50, 0));
            drzaciLjuljaski[i].setMaterial(drzacMaterijal);
            drzac.getChildren().add(drzaciLjuljaski[i]);
            ljuljaske[i]=new Ljuljaska();
            ljuljaske[i].getTransforms().addAll(new Rotate(i*360/drzaciLjuljaski.length, Rotate.Y_AXIS),new Translate(0, 0, -100),new Rotate(90, Rotate.Y_AXIS),rotacijaLjuljaski);
            drzac.getChildren().add(ljuljaske[i]);
        }
        rotacijaDrzaca=new RotateTransition(Duration.seconds(2), drzac);
        rotacijaDrzaca.setRate(-(drzac.getTranslateY()-120)/300+0.1);
        rotacijaDrzaca.setFromAngle(0);
        rotacijaDrzaca.setToAngle(360);
        rotacijaDrzaca.setAxis(Rotate.Y_AXIS);
        rotacijaDrzaca.setInterpolator(Interpolator.LINEAR);
        rotacijaDrzaca.setCycleCount(Animation.INDEFINITE);
        rotacijaDrzaca.play();
    }
    
    public void pomeriDrzac(int zaKoliko){
        drzac.setTranslateY(drzac.getTranslateY()+zaKoliko);
        if(drzac.getTranslateY()<-180) drzac.setTranslateY(-180);
        if(drzac.getTranslateY()>120) drzac.setTranslateY(120);
        rotacijaLjuljaski.setAngle((drzac.getTranslateY()-120)/300*60);
        rotacijaDrzaca.setRate(-(drzac.getTranslateY()-120)/300+0.1);
        
    }
}
