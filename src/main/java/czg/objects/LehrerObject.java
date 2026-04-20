package czg.objects;

import czg.scenes.BaseScene;
import czg.util.Images;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LehrerObject extends BaseObject{

    public final int LEVEL;
    public int hp;
    public final String FACHSCHAFT;
    public static List<ItemType> lehrer_items;

    public LehrerObject(int x, int y, String FACHSCHAFT, int hp, int LEVEL) {
        super(Images.get("/assets/characters/bre.png"), x, y);
        this.LEVEL = LEVEL;
        this.hp = hp;
        this.FACHSCHAFT = FACHSCHAFT;
        this.lehrer_items = Arrays.asList(ItemType.NEWTONSAPFEL, ItemType.ATOM, ItemType.CHROME, ItemType.BSOD);
    }

    public int verteidigung(int level) {
        // Es wird random ausgewählt, ob ein Item gewählt wird (und welches), oder ob der Lehrer nichts macht.
        Random rand = new Random();
        int move = rand.nextInt(5);
        int schaden;
        ItemType item_lehrer;

        // Falls die Null genommen wurde, wird kein Item vom Lehrer benutzt.
        if (move == 0) {
            schaden = level;
        }
        else {
            item_lehrer = lehrer_items.get(move - 1);
            schaden = level - item_lehrer.LEVEL;
            if (schaden <= 0) {
                schaden = 0;
            }

        }

        return schaden;

    }
    
    public int angriff() {
        // Der Lehrer wählt random, welches der Items er zum Angreifen benutzt.
        Random rand = new Random();
        int move = rand.nextInt(4);
        int level;
        ItemType item_lehrer;
        
        item_lehrer = lehrer_items.get(move);
        level = item_lehrer.LEVEL;
        
        return level;
    }

    @Override
    public void update(BaseScene scene) {
    }
}
