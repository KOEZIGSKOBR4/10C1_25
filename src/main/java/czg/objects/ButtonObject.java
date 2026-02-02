package czg.objects;

import czg.scenes.BaseScene;

import java.awt.*;

public class ButtonObject extends BaseObject {
    Runnable method;

    public ButtonObject(Image sprite, Runnable method) {
        super(sprite);
        this.method = method;
    }

    public ButtonObject(Image sprite, int x, int y, Runnable method) {
        super(sprite, x, y);
        this.method = method;
    }

    public ButtonObject(Image sprite, int x, int y, int width, int height, Runnable method) {
        super(sprite, x, y);
        this.method = method;
    }

    @Override
    public void update(BaseScene scene) {
        if(isClicked()) {
            System.out.println("button pressed!");
            method.run();
        }
    }
}