package czg.objects;

import czg.scenes.BaseScene;
import czg.util.Images;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class LehrerObject extends BaseObject{

    public final int LEVEL;
    public int hp;
    public final String FACHSCHAFT;
    public final List<ItemType> lehrer_items;

    public LehrerObject(Image sprite, int x, int y, String FACHSCHAFT, int hp, int LEVEL, List<ItemType> lehrer_items) {
        super(sprite, x, y);
        this.LEVEL = LEVEL;
        this.hp = hp;
        this.FACHSCHAFT = FACHSCHAFT;
        this.lehrer_items = lehrer_items;
    }

    public void verteidigung(int level) {
        // Es wird random ausgewählt, ob ein Item gewählt wird (und welches), oder ob der Lehrer nichts macht.
        Random rand = new Random();
        int move = rand.nextInt(5);
        int schaden;
        ItemType item_lehrer;

        if (move == 0) {
            schaden = level;
            item_lehrer = null;
        }
        else {
            item_lehrer = lehrer_items.get(move - 1);
            schaden = level - item_lehrer.LEVEL;
            if (schaden <= 0) {
                schaden = 0;
            }

        }

        hp -= schaden;

    }
    
    public void angriff() {
        Random rand = new Random();
        int move = rand.nextInt(4);
        int level;
        ItemType item_lehrer;
        
        item_lehrer = lehrer_items.get(move);
        level = item_lehrer.LEVEL;
        
        PlayerObject.INSTANCE.verteidigung(level);
    }
    
    public static Image getImage(Department fachschaft) { // ordnet den Fachschaften die Lehrer mit Bild zu
        if (fachschaft == Department.COMPUTER_SCIENCE) {
            
            return Images.get("assets/characters/bre.png");
                    
        } else if (fachschaft == Department.PHYSICS) {
             
            return Images.get("assets/characters/tno.png");
            
        } else if (fachschaft == Department.MATHEMATICS) {
             
            return Images.get("assets/characters/gei.png");  
            
        } else if (fachschaft == Department.BIOLOGY) {

            return Images.get("assets/characters/kho.png");
            
        } else if (fachschaft == Department.CHEMISTRY) {
            
            return Images.get("assets/characters/kko.png");
        }
        
        throw new IllegalArgumentException("Konnte der Fachschaft "+fachschaft+", kein Foto zuordnen!");
    }

    @Override
    public void update(BaseScene scene) {
    }
}
