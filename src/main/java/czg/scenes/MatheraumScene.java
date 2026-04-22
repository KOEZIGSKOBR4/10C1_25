package czg.scenes;

import czg.objects.*;
import czg.util.Images;

public class MatheraumScene extends BaseScene{
    public MatheraumScene(){
        //Einfügen des Hintergrunds
        objects.add(new BackdropObject(Images.get("/assets/background/Matheraum.png")));
        
        //Pfeilobjekt für den Wechsel in die Gangszene
        objects.add(new PfeilObject(this, MathegangScene::new, PfeilObject.UNTEN));

        LehrerObject.addButtonObject(this, Department.MATHEMATICS);

        //Einfügen der Spieler-Figur
        this.objects.add(PlayerObject.INSTANCE);
        PlayerObject.INSTANCE.x = 270;
        PlayerObject.INSTANCE.y = 295;
    }
}