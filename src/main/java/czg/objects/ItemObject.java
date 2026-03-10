/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package czg.objects;

import czg.util.Images;

import java.awt.*;

/**
 * Enum für Items. Jedes Item sollte als <b>eine</b> {@code public static final}-Instanz
 * (Singleton) in dieser Klasse angelegt werden.
 */
public enum ItemObject{
    ATOM("Atom", "/assets/items/atom.png", 0),
    BSOD("Error-Screen", "/assets/items/blue_screen_of_death.png", 2),
    BRENNER("Brenner", "/assets/items/brenner.png", 2),
    CAS("Taschenrechner", "/assets/items/cas.png", 2),
    CD("CD", "/assets/items/cd.png", 0),
    CHROME("Chrome", "/assets/items/chrome.png", 1),
    DNA("DNA", "/assets/items/dna.png", 1),
    FELDSTECHER("Feldstecher", "/assets/items/feldstecher.png", 1),
    GLUEHBIRNE("Glühbirne", "/assets/items/glühbirne.png", 2),
    IKOSAEDER("Ikosaeder", "/assets/items/ikosaeder.png", 1),
    KRAFTMESSER("Federkraftmesser", "/assets/items/kraftmesser.png", 0),
    LAUTSPRECHER("Lautsprecher", "/assets/items/lautsprecher.png", 0),
    LINEAL("Lineal", "/assets/items/lineal.png", 0),
    MAGNET("Magnet", "/assets/items/magnet.png", 1),
    MIKROSKOP("Mikroskop", "/assets/items/mikroskop.png", 2),
    NERV("Nervenzelle", "/assets/items/nerv.png", 0),
    NEWTONSAPFEL("Newtons Apfel", "/assets/items/newtons_apfel.png", 0),
    THALES("Satz des Thales", "/assets/items/satz_des_thales.png", 1),
    SCHUTZBRILLE("Schutzbrille", "/assets/items/schutzbrille.png", 1),
    SCHAEDEL("Schädel", "/assets/items/schädel.png", 1),
    SEIZUREDFROG("Sezierter Frosch", "/assets/items/seizured_frog.png", 2),
    SPRITZFLASCHE("Spritzflasche", "/assets/items/spritzflasche.png", 0),
    SAEURE("Säure", "/assets/items/säure.png", 2),
    TASTATUR("Tastatur", "/assets/items/tastatur.png", 2),
    THERMOMETER("Thermometer", "/assets/items/thermometer.png", 2),
    VIRUS("Virus", "/assets/items/virus.png", 0),
    WLAN("Wlan", "/assets/items/wlan.png", 1),
    WUNDERKERZE("Wunderkerze", "/assets/items/wunderkerze.png", 1),
    ZETTEL("Zettel", "/assets/items/zettel.png", 2),
    ZIRKEL("Zirkel", "/assets/items/zirkel.png", 0);
        
    public final String NAME;
    public final Image SPRITE;
    public final int LEVEL;
    
    ItemObject(String name, String imagePath, int level) {
        this.NAME = name;
        this.SPRITE = Images.get(imagePath);
        this.LEVEL = level;
    }

    /**
     * Gibt ein Item als Belohnung für das Beenden eines Minispiels zurück.
     * @param minigame Das Minispiel, welches beendet wurde
     * @param level Das Level, welches beendet wurde
     */
    public static ItemObject getMinigameReward(Department minigame, int level) {
        switch(minigame) {
            case COMPUTER_SCIENCE -> {
                switch(level) {
                    case 0 -> {
                        return ItemObject.CD;
                    } case 1 -> {
                        return ItemObject.CHROME;
                    } case 2 -> {
                        return ItemObject.TASTATUR;
                    }
                }
            } case PHYSICS -> {
                switch(level) {
                    case 0 -> {
                        return ItemObject.KRAFTMESSER;
                    } case 1 -> {
                        return ItemObject.MAGNET;
                    } case 2 -> {
                        return ItemObject.GLUEHBIRNE;
                    }
                }
            } case MATHEMATICS -> {
                switch(level) {
                    case 0 -> {
                        return ItemObject.ZIRKEL;
                    } case 1 -> {
                        return ItemObject.THALES;
                    } case 2 -> {
                        return ItemObject.CAS;
                    }
                }
            } case BIOLOGY -> {
                switch(level) {
                    case 0 -> {
                        return ItemObject.VIRUS;
                    } case 1 -> {
                        return ItemObject.SCHAEDEL;
                    } case 2 -> {
                        return ItemObject.SEIZUREDFROG;
                    }
                }
            } case CHEMISTRY -> {
                switch(level) {
                    case 0 -> {
                        return ItemObject.SPRITZFLASCHE;
                    } case 1 -> {
                        return ItemObject.SCHUTZBRILLE;
                    } case 2 -> {
                        return ItemObject.SAEURE;
                    }
                }
            }  
        }
        return null;
    }
}
