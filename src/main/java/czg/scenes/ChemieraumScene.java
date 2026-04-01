/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package czg.scenes;

import czg.objects.BackdropObject;
import czg.objects.ButtonObject;
import czg.objects.Department;
import czg.objects.PfeilObject;
import czg.objects.PlayerObject;
import czg.scenes.minigame.Minigames;
import czg.util.Images;

/**
 *
 * @author guest-rwl69f
 */
public class ChemieraumScene extends BaseScene{
    public ChemieraumScene(){
        //Einfügen des Hintergrunds
        objects.add(new BackdropObject(Images.get("/assets/background/Chemieraum.png")));
        
        //Pfeilobjekt für den Wechsel in die Gangszene
        objects.add(new PfeilObject(this, ChemiegangScene::new, PfeilObject.UNTEN));
        
        //Einfügen der Spieler-Figur
        this.objects.add(PlayerObject.INSTANCE);
        PlayerObject.INSTANCE.x = 170;
        PlayerObject.INSTANCE.y = 290;
        
        objects.add(new ButtonObject(null,370, 210, 410, 150,
                () -> SceneStack.INSTANCE.push(Minigames.generateMinigame(Department.CHEMISTRY))));
        }
}

