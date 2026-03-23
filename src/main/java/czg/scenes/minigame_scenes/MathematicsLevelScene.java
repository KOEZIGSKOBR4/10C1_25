package czg.scenes.minigame_scenes;

import czg.MainWindow;
import czg.objects.BaseObject;
import czg.objects.Department;
import czg.objects.minigame_objects.MathematicsPuzzleObject;
import czg.objects.minigame_objects.TangramPieceObject;
import czg.util.Images;

import java.util.Arrays;

public class MathematicsLevelScene extends LevelScene {
    private final TangramPieceObject[] PIECES;
    private final MathematicsPuzzleObject PUZZLE;
    private final int PUZZLE_X;
    private final int PUZZLE_Y;
    private final int PUZZLE_WIDTH;
    private final int PUZZLE_HEIGHT;

    public MathematicsLevelScene(int level) {
        super(Department.MATHEMATICS, level);

        // PLEASE HELP!!!
        // Das Array ist anderes Objekt, aber inhalte sind die selben objekte
        // mimimi :(
        this.PIECES = TangramPieceObject.PIECES.clone();

        this.PUZZLE = MathematicsPuzzleObject.getPuzzle(level);

        TangramPieceObject.setLevelScene(PIECES, this);

        PUZZLE.reset(this.PIECES, MainWindow.HEIGHT / 4, MainWindow.HEIGHT / 4, MainWindow.HEIGHT/2);

        objects.addAll(Arrays.asList(PIECES));


        BaseObject puzzleObject = new BaseObject(PUZZLE.sprite, 0, 0);

        double scale = Images.get("/assets/minigames/mathematics/tangram_packed.png").getWidth(null) / (double) (MainWindow.HEIGHT/2);

        puzzleObject.width *= scale;
        puzzleObject.height *= scale;

        this.PUZZLE_WIDTH = puzzleObject.width;
        this.PUZZLE_HEIGHT = puzzleObject.height;
        this.PUZZLE_X = (int) (MainWindow.WIDTH - PUZZLE_WIDTH - MainWindow.WIDTH*0.1);
        this.PUZZLE_Y = (MainWindow.HEIGHT - PUZZLE_HEIGHT)/2;

        puzzleObject.x = PUZZLE_X;
        puzzleObject.y = PUZZLE_Y;

        objects.add(puzzleObject);
    }

    public void checkPuzzle() {
        System.out.println("check");
        if(PUZZLE.isSolutionValid(PIECES, PUZZLE_X, PUZZLE_Y, PUZZLE_WIDTH, PUZZLE_HEIGHT)) {
            System.out.println("won");
            minigameWon();
        }
    }
}
