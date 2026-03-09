/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package czg.scenes;

import czg.objects.BackdropObject;
import czg.objects.ButtonObject;
import czg.util.Images;

import static czg.MainWindow.WIDTH;

/**
 * @author Jonas648
 */
public class BioraumScene extends BaseScene{
    public BioraumScene(){
        //Einfügen des Hintergrunds
        objects.add(new BackdropObject(Images.get("/assets/background/Bio-Raum.png")));


        ButtonObject unten = new ButtonObject(
                Images.get("/assets/background/PfeilUnten.png"),
                () -> {
                    BiogangScene bio = new BiogangScene();
                    /*
                    this.objects.remove(ExamplePlayerObject.INSTANCE);
                    tr1.objects.add(ExamplePlayerObject.INSTANCE);
                    */
                    SceneStack.INSTANCE.replace(this, bio);
                });

        unten.x = (WIDTH/2) - (unten.width/2);
        unten.y = 452;
        objects.add(unten);

    }
}
