package czg.scenes;
import czg.objects.BackdropObject;
import czg.objects.Department;
import czg.objects.LehrerObject;
import czg.objects.PlayerObject;
import czg.util.Images;

/**
 * @author Sophie
 */
public class KampfScene extends BaseScene{


    public KampfScene(String FACHSCHAFT){
        super();

        //Einfügen des Hintergrunds
        objects.add(new BackdropObject(Images.get("/assets/background/Kampfgang.png")));
        
        SceneStack.INSTANCE.push(new InventarScene());

        int LehrerLeben = 10;
        int PlayerLeben = 10;

        LehrerObject Lehrer = new LehrerObject(10, 10, FACHSCHAFT, LehrerLeben, 2);
        PlayerObject.INSTANCE.x = 330;
        PlayerObject.INSTANCE.y = 295;

        while (LehrerLeben > 0 && PlayerLeben > 0) {
            // Zuerst der Schüler
            int SchadenPlayer = PlayerObject.INSTANCE.angriff();
            int SchadenGesamt = Lehrer.verteidigung(SchadenPlayer);
            LehrerLeben -= SchadenGesamt;

            // Dann der Lehrer
            int SchadenLehrer = Lehrer.angriff();
            SchadenGesamt = PlayerObject.INSTANCE.verteidigung(SchadenPlayer);
            PlayerLeben -= SchadenGesamt;
        }
    }

}


