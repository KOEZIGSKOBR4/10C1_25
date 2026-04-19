package czg.scenes;

import czg.objects.ButtonObject;
import czg.objects.ItemType;
import czg.objects.PlayerObject;
import czg.util.Draw;
import czg.util.Images;
import static czg.MainWindow.PIXEL_SCALE;

import java.awt.*;

import static czg.MainWindow.*;

public class InventarScene extends BaseScene {

    /**
     * X-Koordinate der linken Seite
     */
    private static final int iLeft = (int)(WIDTH * 0.03);
    /**
     * Y-Koordinate der oberen Seite
     */
    private static final int iTop = (int)(HEIGHT * 0.03);
    /**
     * Breite des Inventars
     */
    private static final int iWidth = WIDTH - 2 * iLeft;
    /**
     * Höhe des Inventars
     */
    private static final int iHeight = (int)(HEIGHT * 0.3);
    /**
     * Abstand zwischen Items
     */
    private static final int iPadding = (int)(WIDTH * 0.025);

    public InventarScene() {
        // Button zum Schließen
        ButtonObject exit = new ButtonObject (
                Images.get("/assets/minigames/general/button_exit.png"),
                SceneStack.INSTANCE::pop
        );

        exit.x = iLeft + iWidth - iPadding - exit.sprite.getWidth(null) * PIXEL_SCALE;
        exit.y = iTop + (iHeight / 2) - (exit.sprite.getHeight(null) * PIXEL_SCALE )/2;
        objects.add(exit);
    }
    
    @Override
    public void draw(Graphics2D g) {
        // Hintergrund
        g.setColor(new Color(0x9A6B9C));
        g.fillRect(iLeft, iTop, iWidth, iHeight);

        // Für Text
        g.setColor(Color.WHITE);
        g.setFont(Draw.FONT_TITLE.deriveFont(20f));

        // Items mit Beschriftung zeichnen
        int x = iLeft + iPadding;
        for (int i = 0; i < PlayerObject.INSTANCE.inventar.size(); i++) {
            // Item abfragen
            ItemType item = PlayerObject.INSTANCE.inventar.get(i);

            // Sprite zeichnen
            int y = iTop + ((int) (HEIGHT * 0.05));
            g.drawImage(item.SPRITE, x, y, item.SPRITE.getWidth(null) * PIXEL_SCALE, item.SPRITE.getHeight(null) * PIXEL_SCALE, null);

            // Text zeichnen
            Draw.drawTextCentered(g, item.NAME, x + item.SPRITE.getWidth(null) * PIXEL_SCALE / 2, y + item.SPRITE.getHeight(null) * PIXEL_SCALE + 32);

            x += item.SPRITE.getWidth(null) * PIXEL_SCALE + iPadding;
        }

        // Objekte
        super.draw(g);
    }
    
}
