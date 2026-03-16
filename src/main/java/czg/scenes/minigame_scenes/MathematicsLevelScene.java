package czg.scenes.minigame_scenes;

import czg.objects.ButtonObject;
import czg.objects.Department;
import czg.objects.DragObject;
import czg.objects.minigame_objects.TangramPieceObject;
import czg.util.Images;

public class MathematicsLevelScene extends LevelScene {
    public MathematicsLevelScene(int level) {
        super(Department.MATHEMATICS, level);
        
        for(TangramPieceObject piece : TangramPieceObject.PIECES)
            objects.add(piece);
        
        TangramPieceObject.generatePacked(100, 100, 400, 400);
    }
}
