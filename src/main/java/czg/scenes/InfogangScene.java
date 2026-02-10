/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package czg.scenes;

import czg.objects.BackdropObject;
import czg.objects.ButtonObject;
import czg.objects.minigame_objects.LogicGateObject;
import czg.scenes.minigame_scenes.InformaticsLevelScene;
import czg.scenes.minigame_scenes.MinigameScene;
import czg.util.Images;

import java.util.List;

/**
 *
 * @author guest-zmpzia
 */
public class InfogangScene extends BaseScene{
    public InfogangScene(){
        objects.add(new BackdropObject(Images.get("/assets/background/Infogang.png")));

        MinigameScene informaticsTest = new MinigameScene(
                new InformaticsLevelScene(null, List.of(LogicGateObject.AND, LogicGateObject.OR,LogicGateObject.NOT, LogicGateObject.NAND)),
                new InformaticsLevelScene(null, List.of(LogicGateObject.NOR, LogicGateObject.XOR,LogicGateObject.XNOR, LogicGateObject.AND)),
                new InformaticsLevelScene(null, List.of(LogicGateObject.OR,LogicGateObject.NOT, LogicGateObject.NAND, LogicGateObject.NOR))
        );

        objects.add(new ButtonObject(Images.get("/assets/minigames/informatics/button.png"), informaticsTest::startMinigame));
    }
}
