package czg.scenes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SceneStackCoveringTest extends BaseSceneStackTest {

    @Test
    public void testEffectiveRules() {
        sceneStack.push(backgroundScene);
        sceneStack.push(fullScreenScene);
        sceneStack.push(partiallyCoveringScene);

        sceneStack.repaint();
        sceneStack.update();

        assertFalse(hasDrawn.getOrDefault(backgroundScene, false));
        assertTrue(hasDrawn.getOrDefault(fullScreenScene, false));
        assertTrue(hasDrawn.getOrDefault(partiallyCoveringScene, false));

        assertFalse(hasUpdated.getOrDefault(backgroundScene, false));
        assertFalse(hasUpdated.getOrDefault(fullScreenScene, false));
        assertTrue(hasUpdated.getOrDefault(partiallyCoveringScene, false));
    }

}
