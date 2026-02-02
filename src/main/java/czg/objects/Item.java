/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package czg.objects;

import czg.scenes.BaseScene;
import java.awt.Image;

/**
 *
 * @author guest-2lih6l
 */
public class Item extends BaseObject{
    
   
    
    public final int level;
    public final String name;
    
    private Item(Image sprite, int x, int y, int level, String name) {
        super(sprite, x, y);
        
        this.level = level;
        this.name = name;
    }
    
    @Override
    public void update(BaseScene scene) {
       
    }
    
}
