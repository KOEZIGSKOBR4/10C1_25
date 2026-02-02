/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package czg.scenes.minigame_scenes;

import czg.objects.BackdropObject;
import czg.objects.BaseObject;
import czg.objects.ButtonObject;
import czg.scenes.*;
import czg.util.Images;

import java.awt.*;

/**
 *
 * @author guest-kaafgt
 */
public class LevelSelectorScene extends BaseScene {
    public LevelSelectorScene(BaseScene level1, BaseScene level2, BaseScene level3) {
        objects.add(new BackdropObject(new Color(150, 150, 150)));
        
        BaseObject buttonLevel1 = new ButtonObject(Images.get("/assets/minigames/informatics/button.png"), 100, 100, 200, 50, () -> SceneStack.INSTANCE.push(level1));
        BaseObject buttonLevel2 = new ButtonObject(Images.get("/assets/minigames/informatics/button.png"), 100, 200, 200, 50, () -> SceneStack.INSTANCE.push(level2));
        BaseObject buttonLevel3 = new ButtonObject(Images.get("/assets/minigames/informatics/button.png"), 100, 300, 200, 50, () -> SceneStack.INSTANCE.push(level3));

        objects.add(buttonLevel1);
        objects.add(buttonLevel2);
        objects.add(buttonLevel3);
    }
}
