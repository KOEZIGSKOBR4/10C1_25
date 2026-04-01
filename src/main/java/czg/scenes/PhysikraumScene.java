/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package czg.scenes;

import czg.objects.BackdropObject;
import czg.objects.PfeilObject;
import czg.objects.PlayerObject;
import czg.util.Images;

/**
 *
 * @author guest-rwl69f
 */
public class PhysikraumScene extends BaseScene{
    public PhysikraumScene(){
        //Einfügen des Hintergrunds
        objects.add(new BackdropObject(Images.get("/assets/background/Physik-Raum.png")));
        
        //Pfeilobjekt für den Wechsel in die Gangszene
        objects.add(new PfeilObject(this, PhysikgangScene::new, PfeilObject.UNTEN));
        
        //Einfügen der Spieler-Figur
        this.objects.add(PlayerObject.INSTANCE);
        PlayerObject.INSTANCE.x = 210;
        PlayerObject.INSTANCE.y = 290;
        
       objects.add(new ButtonObject(null,370, 210, 410, 150,
                () -> SceneStack.INSTANCE.push(Minigames.generateMinigame(Department.PHYSICS)))); 
    }
}
