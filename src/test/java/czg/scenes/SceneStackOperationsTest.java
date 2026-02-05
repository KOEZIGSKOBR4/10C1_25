package czg.scenes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SceneStackOperationsTest extends BaseSceneStackTest {

    @Test
    public void testUnloadingWhenRemoving() {
        sceneStack.push(backgroundScene);
        sceneStack.push(partiallyCoveringScene);

        assertFalse(hasUnloaded.getOrDefault(backgroundScene, false));
        assertFalse(hasUnloaded.getOrDefault(partiallyCoveringScene, false));

        sceneStack.remove(backgroundScene);

        assertTrue(hasUnloaded.getOrDefault(backgroundScene, false));
        assertFalse(hasUnloaded.getOrDefault(partiallyCoveringScene, false));

    }

    @Test
    public void testUnloadingWhenReplacing() {
        sceneStack.push(backgroundScene);
        sceneStack.push(partiallyCoveringScene);

        assertFalse(hasUnloaded.getOrDefault(backgroundScene, false));
        assertFalse(hasUnloaded.getOrDefault(partiallyCoveringScene, false));

        sceneStack.replace(partiallyCoveringScene, fullScreenScene);

        assertFalse(hasUnloaded.getOrDefault(backgroundScene, false));
        assertTrue(hasUnloaded.getOrDefault(partiallyCoveringScene, false));
    }

    @Test
    public void testUnloadingWhenPopping() {
        sceneStack.push(backgroundScene);
        sceneStack.push(partiallyCoveringScene);

        assertFalse(hasUnloaded.getOrDefault(backgroundScene, false));
        assertFalse(hasUnloaded.getOrDefault(partiallyCoveringScene, false));

        sceneStack.pop();

        assertFalse(hasUnloaded.getOrDefault(backgroundScene, false));
        assertTrue(hasUnloaded.getOrDefault(partiallyCoveringScene, false));
    }

    @Test
    public void testCoveringStatus() {
        sceneStack.push(backgroundScene);
        assertFalse(backgroundScene.isCovered);

        sceneStack.push(fullScreenScene);
        assertTrue(backgroundScene.isCovered);
        assertFalse(fullScreenScene.isCovered);

        sceneStack.push(partiallyCoveringScene);
        assertTrue(backgroundScene.isCovered);
        assertTrue(fullScreenScene.isCovered);
        assertFalse(partiallyCoveringScene.isCovered);

        sceneStack.pop();
        assertTrue(backgroundScene.isCovered);
        assertFalse(fullScreenScene.isCovered);
    }

}
