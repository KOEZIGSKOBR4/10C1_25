package czg.objects.minigame_objects;

import czg.util.Images;

import java.awt.*;
import java.util.Random;

public enum LogicGateObject {
    AND("/assets/minigames/computer_science/and_gate.png"),
    OR("/assets/minigames/computer_science/or_gate.png"),
    NOT("/assets/minigames/computer_science/not_gate.png"),
    NAND("/assets/minigames/computer_science/nand_gate.png"),
    NOR("/assets/minigames/computer_science/nor_gate.png"),
    XOR("/assets/minigames/computer_science/xor_gate.png"),
    XNOR("/assets/minigames/computer_science/xnor_gate.png");

    public final Image sprite;

    LogicGateObject(String path) {
        this.sprite = Images.get(path);
    }

    public static LogicGateObject getRandom() {
        int r = (int) (new Random().nextDouble() * LogicGateObject.values().length);

        return LogicGateObject.values()[r];
    }

    public static LogicGateObject[] getRandomArray(int length, LogicGateObject excludedGate) {
        LogicGateObject[] tmp = new LogicGateObject[length];
        LogicGateObject[] usedGates = new LogicGateObject[length];

        for (int i = 0; i < length; i++) {
            boolean valid = false;
            LogicGateObject rGate = null;
            while (!valid) {
                valid = true;

                rGate = getRandom();

                if (rGate == excludedGate) {
                    valid = false;
                    continue;
                }
                for (int j = 0; j < length; j++) {
                    if (usedGates[j] == rGate) {
                        valid = false;
                        break;
                    }
                }
            }
            tmp[i] = rGate;
            usedGates[i] = rGate;
        }

        return tmp;
    }
}
