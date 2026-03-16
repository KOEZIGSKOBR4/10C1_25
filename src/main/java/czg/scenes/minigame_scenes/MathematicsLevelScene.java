package czg.scenes.minigame_scenes;

import czg.objects.Department;
import czg.objects.minigame_objects.TangramPieceObject;

import java.util.Arrays;

public class MathematicsLevelScene extends LevelScene {
    public MathematicsLevelScene(int level) {
        super(Department.MATHEMATICS, level);

        objects.addAll(Arrays.asList(TangramPieceObject.PIECES));

        TangramPieceObject.generatePacked(100, 100, 400, 400);
    }
}
