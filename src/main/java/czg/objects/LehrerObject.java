package czg.objects;

import czg.MainWindow;
import czg.scenes.BaseScene;
import czg.scenes.InventarScene;
import czg.scenes.KampfScene;
import czg.scenes.SceneStack;
import czg.util.Draw;
import czg.util.Images;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class LehrerObject extends BaseObject{

    public final Department fachschaft;
    public static List<ItemType> lehrerItems;

    public LehrerObject(int x, int y, Department fachschaft) {
        super(getImage(fachschaft), x, y);
        this.fachschaft = fachschaft;
        lehrerItems = ItemType.getItems(fachschaft);
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
            item_lehrer = lehrerItems.get(move - 1);
            KampfScene.instance.objects.remove(KampfScene.currentItem);
            KampfScene.currentItem = new ItemObject(item_lehrer, 1, x - width, y + height / 2);
            KampfScene.instance.objects.add(KampfScene.currentItem);
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
        
        item_lehrer = lehrerItems.get(move);
        level = item_lehrer.LEVEL;
        
        return level;
    }
    
    public static Image getImage(Department fachschaft) { // ordnet den Fachschaften die Lehrer mit Bild zu
        if (fachschaft == Department.COMPUTER_SCIENCE) {
            
            return Images.get("/assets/characters/bre.png");
                    
        } else if (fachschaft == Department.PHYSICS) {
             
            return Images.get("/assets/characters/tno.png");
            
        } else if (fachschaft == Department.MATHEMATICS) {
             
            return Images.get("/assets/characters/gei.png");
            
        } else if (fachschaft == Department.BIOLOGY) {

            return Images.get("/assets/characters/kho.png");
            
        } else if (fachschaft == Department.CHEMISTRY) {
            
            return Images.get("/assets/characters/kko.png");
        }
        
        throw new IllegalArgumentException("Konnte der Fachschaft "+fachschaft+" kein Foto zuordnen!");
    }

    public static void addButtonObject(BaseScene scene, Department department) {
        if(KampfScene.uebrigeLehrer.contains(department))
            scene.objects.add(new ButtonObject(LehrerObject.getImage(department),
                () -> {
                    SceneStack.INSTANCE.push(new KampfScene(department));
                    SceneStack.INSTANCE.push(new InventarScene(false));
                    PlayerObject.INSTANCE.allowInventory = false;
            }));
    }

    @Override
    public void update(BaseScene scene) {
        super.update(scene);

        if(KampfScene.lehrerVerteidigung) {
            KampfScene.Endschaden = verteidigung(KampfScene.Zwischenschaden);
            KampfScene.LehrerLeben -= KampfScene.Endschaden;
            KampfScene.lehrerVerteidigung = false;
            KampfScene.lehrerTurn = true;
        }
        if(KampfScene.lehrerTurn) {
            KampfScene.Zwischenschaden = angriff();
            KampfScene.timer = 10 * MainWindow.FPS;
            KampfScene.lehrerTurn = false;
            KampfScene.PlayerVerteidigung = true;
        }




    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);

        g.setColor(Color.WHITE);
        g.setFont(Draw.FONT_INFO);
        if(KampfScene.imKampf) {
            String text = KampfScene.lehrerTurn ? "TURN" : "VERTEIDIGUNG";
            Draw.drawTextCentered(g, text, x + width / 2, y + height + 20, true);

            Draw.drawTextCentered(g, "HP: "+KampfScene.LehrerLeben, x + width  / 2, y + height + 40, true);
        }
    }
}
