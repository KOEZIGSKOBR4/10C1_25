package czg.objects.minigame_objects;

import czg.util.Images;

import java.awt.*;
import java.util.Random;

public enum MathematicsPuzzleObject {
    P_00("/assets/minigames/mathematics/puzzle_1_1.png", 2, new double[][][] {
        {
            {0.33, 0.4, 0.0},
            {0.0, 0.0, 180.0},
            {0.33, 0.0, 90.0},
            {0.5, 0.0, 0.0},
            {0.33, 0.4, 180.0},
            {0.5, 0.2, 90.0},
            {0.33, 0.6, 0.0}
        }
    }),
    P_01("/assets/minigames/mathematics/puzzle_1_1.png", 2, new double[][][] {
            {
                    {0.33, 0.4, 0.0},
                    {0.0, 0.0, 180.0},
                    {0.33, 0.0, 90.0},
                    {0.5, 0.0, 0.0},
                    {0.33, 0.4, 180.0},
                    {0.5, 0.2, 90.0},
                    {0.33, 0.6, 0.0}
            }
    }),
    P_02("/assets/minigames/mathematics/puzzle_1_1.png", 2, new double[][][] {
            {
                    {0.33, 0.4, 0.0},
                    {0.0, 0.0, 180.0},
                    {0.33, 0.0, 90.0},
                    {0.5, 0.0, 0.0},
                    {0.33, 0.4, 180.0},
                    {0.5, 0.2, 90.0},
                    {0.33, 0.6, 0.0}
            }
    }),

    P_10("/assets/minigames/mathematics/puzzle_1_1.png", 0, new double[][][] {
            {
                    {0.33, 0.4, 0.0},
                    {0.0, 0.0, 180.0},
                    {0.33, 0.0, 90.0},
                    {0.5, 0.0, 0.0},
                    {0.33, 0.4, 180.0},
                    {0.5, 0.2, 90.0},
                    {0.33, 0.6, 0.0}
            }
    }),
    P_11("/assets/minigames/mathematics/puzzle_1_1.png", 0, new double[][][] {
            {
                    {0.33, 0.4, 0.0},
                    {0.0, 0.0, 180.0},
                    {0.33, 0.0, 90.0},
                    {0.5, 0.0, 0.0},
                    {0.33, 0.4, 180.0},
                    {0.5, 0.2, 90.0},
                    {0.33, 0.6, 0.0}
            }
    }),
    P_12("/assets/minigames/mathematics/puzzle_1_1.png", 0, new double[][][] {
            {
                    {0.33, 0.4, 0.0},
                    {0.0, 0.0, 180.0},
                    {0.33, 0.0, 90.0},
                    {0.5, 0.0, 0.0},
                    {0.33, 0.4, 180.0},
                    {0.5, 0.2, 90.0},
                    {0.33, 0.6, 0.0}
            }
    }),

    P_20("/assets/minigames/mathematics/puzzle_1_1.png", 0, new double[][][] {
            {
                    {0.33, 0.4, 0.0},
                    {0.0, 0.0, 180.0},
                    {0.33, 0.0, 90.0},
                    {0.5, 0.0, 0.0},
                    {0.33, 0.4, 180.0},
                    {0.5, 0.2, 90.0},
                    {0.33, 0.6, 0.0}
            }
    }),
    P_21("/assets/minigames/mathematics/puzzle_1_1.png", 0, new double[][][] {
            {
                    {0.33, 0.4, 0.0},
                    {0.0, 0.0, 180.0},
                    {0.33, 0.0, 90.0},
                    {0.5, 0.0, 0.0},
                    {0.33, 0.4, 180.0},
                    {0.5, 0.2, 90.0},
                    {0.33, 0.6, 0.0}
            }
    }),
    P_22("/assets/minigames/mathematics/puzzle_1_1.png", 0, new double[][][] {
            {
                    {0.33, 0.4, 0.0},
                    {0.0, 0.0, 180.0},
                    {0.33, 0.0, 90.0},
                    {0.5, 0.0, 0.0},
                    {0.33, 0.4, 180.0},
                    {0.5, 0.2, 90.0},
                    {0.33, 0.6, 0.0}
            }
    });

    public static final MathematicsPuzzleObject[][] PUZZLES = {
        {
            MathematicsPuzzleObject.P_00,
            MathematicsPuzzleObject.P_01,
            MathematicsPuzzleObject.P_02
        }, {
            MathematicsPuzzleObject.P_10,
            MathematicsPuzzleObject.P_11,
            MathematicsPuzzleObject.P_12
        }, {
            MathematicsPuzzleObject.P_20,
            MathematicsPuzzleObject.P_21,
            MathematicsPuzzleObject.P_22
        }
    };
    
    public static final int MARGIN_OF_ERROR = 20;

    public final Image sprite;
    public final int amountOfGivenPieces;
    public final double[][][] solutions;

    MathematicsPuzzleObject(String path, int amountOfGivenPieces, double[][][] solutions) {
        this.sprite = Images.get(path);
        this.amountOfGivenPieces = amountOfGivenPieces;
        this.solutions = solutions;
    }

    public static MathematicsPuzzleObject getPuzzle(int level) {
        int r = (int) (new Random().nextDouble() * 3);

        return PUZZLES[level][r];
    }
    
    public boolean isSolutionValid(TangramPieceObject[] pieces, int x, int y, int width, int height) {
        for(double[][] solution : solutions) {
            boolean isValid = true;
            
            for(int i = 0; i < pieces.length; i++) {
                TangramPieceObject currentPiece = pieces[i];
                if (
                    currentPiece.x < x + solution[i][0]*width - MARGIN_OF_ERROR || currentPiece.x > x + solution[i][0]*width + MARGIN_OF_ERROR || // Überprüfung der X-Koordinate
                    currentPiece.y < y + solution[i][1]*height - MARGIN_OF_ERROR || currentPiece.y > y + solution[i][1]*height + MARGIN_OF_ERROR || // Überprüfung der Y-Koordinate
                    currentPiece.rotation != solution[i][2] // Überprüfung der Rotation
                ) {
                    isValid = false;
                    break;
                }
            }
            
            if(isValid) return true;
        }
        
        return false;
    }
    
    public void setGivenPieces(TangramPieceObject[] pieces, int x, int y, int scale) {
        int[] idx = new int[amountOfGivenPieces];
        for(int i = 0; i < amountOfGivenPieces; i++) {
            idx[i] = -1;
        }
        
        for(int i = 0; i < amountOfGivenPieces; i++) {
            int rIdx;
            while(true) {
                rIdx = (int) (amountOfGivenPieces * new Random().nextDouble());
                boolean validIdx = true;
                for(int j = 0; j < amountOfGivenPieces; j++) {
                    if (idx[j] == rIdx) {
                        validIdx = false;
                        break;
                    }
                }
                if(validIdx) break;
            }
            idx[i] = rIdx;
        }
        
        int rSolution = (int) (solutions.length * new Random().nextDouble());
        for(int i : idx) {
            // TEMPORÄR IMMER i = 0 UNBEDINGT NOCH ÄNDERN
            pieces[0].x = (int) (x + solutions[rSolution][0][0]*scale);
            pieces[0].y = (int) (y + solutions[rSolution][0][1]*scale);
            pieces[0].setRotation(solutions[rSolution][0][2]);
        }
    }
    
    public void reset(TangramPieceObject[] pieces, int x, int y, int size) {
        TangramPieceObject.generatePacked(pieces, x, y, size, size);
        setGivenPieces(pieces, x, y, size);
    }
}
