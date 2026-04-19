package czg.scenes.intro;

import czg.objects.BackdropObject;
import czg.objects.ButtonObject;
import czg.objects.ItemType;
import czg.objects.PlayerObject;
import czg.scenes.BaseScene;
import czg.scenes.FoyerScene;
import czg.scenes.SceneStack;
import czg.util.Images;

import static czg.MainWindow.PIXEL_SCALE;


public class ChoosingScene extends BaseScene {
    public ChoosingScene() {
        objects.add(new BackdropObject(Images.get("/assets/intro/choosingbackground.png")));
        objects.add(new ButtonObject(Images.get("/assets/intro/computersciencebutton.png"), 50*PIXEL_SCALE, 10*PIXEL_SCALE, 160*PIXEL_SCALE, 66*PIXEL_SCALE, () -> {
            PlayerObject.INSTANCE.inventar.add(ItemType.CD);
            SceneStack.INSTANCE.pop();
            SceneStack.INSTANCE.push(new FoyerScene());
            SceneStack.INSTANCE.push(new EntranceScene());
        }));
        objects.add(new ButtonObject(Images.get("/assets/intro/chemistrybutton.png"), 50*PIXEL_SCALE, 30*PIXEL_SCALE, 160*PIXEL_SCALE, 66*PIXEL_SCALE, () -> {
            PlayerObject.INSTANCE.inventar.add(ItemType.ATOM);
            SceneStack.INSTANCE.pop();
            SceneStack.INSTANCE.push(new FoyerScene());
            SceneStack.INSTANCE.push(new EntranceScene());
        }));
        objects.add(new ButtonObject(Images.get("/assets/intro/biologybutton.png"), 50*PIXEL_SCALE, 50*PIXEL_SCALE, 160*PIXEL_SCALE, 66*PIXEL_SCALE, () -> {
            PlayerObject.INSTANCE.inventar.add(ItemType.VIRUS);
            SceneStack.INSTANCE.pop();
            SceneStack.INSTANCE.push(new FoyerScene());
            SceneStack.INSTANCE.push(new EntranceScene());
        }));
        objects.add(new ButtonObject(Images.get("/assets/intro/physicsbutton.png"), 50*PIXEL_SCALE, 70*PIXEL_SCALE, 160*PIXEL_SCALE, 66*PIXEL_SCALE, () -> {
            PlayerObject.INSTANCE.inventar.add(ItemType.KRAFTMESSER);
            SceneStack.INSTANCE.pop();
            SceneStack.INSTANCE.push(new FoyerScene());
            SceneStack.INSTANCE.push(new EntranceScene());
        }));
        objects.add(new ButtonObject(Images.get("/assets/intro/mathsbutton.png"), 50*PIXEL_SCALE, 90*PIXEL_SCALE, 160*PIXEL_SCALE, 66*PIXEL_SCALE, () -> {
            PlayerObject.INSTANCE.inventar.add(ItemType.LINEAL);
            SceneStack.INSTANCE.pop();
            SceneStack.INSTANCE.push(new FoyerScene());
            SceneStack.INSTANCE.push(new EntranceScene());
        }));



    }
}
