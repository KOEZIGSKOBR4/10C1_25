package czg.scenes;

import czg.scenes.cover_settings.CoverSettings;
import czg.scenes.cover_settings.Rules;
import czg.scenes.cover_settings.Setting;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class BaseSceneStackTest {

    public static SceneStack sceneStack;
    public static BaseScene backgroundScene;
    public static BaseScene fullScreenScene;
    public static BaseScene partiallyCoveringScene;

    public static final String fullscreenTag = "fullscreen";
    public static final String partiallyCoveringTag = "partially_covering";

    public static final Map<BaseScene, Boolean> hasUpdated = new HashMap<>();
    public static final Map<BaseScene, Boolean> hasDrawn = new HashMap<>();
    public static final Map<BaseScene, Boolean> hasUnloaded = new HashMap<>();

    public static class TestScene extends BaseScene {

        TestScene(CoverSettings settings) {
            super(settings);
        }

        @Override
        public void update() {
            hasUpdated.put(this, true);
        }

        @Override
        public void unload() {
            hasUnloaded.put(this, true);
        }

        @Override
        public void draw(Graphics2D g) {
            hasDrawn.put(this, true);
        }
    }

    @BeforeAll
    public static void setup() {
        CoverSettings coverSettings = new CoverSettings()
                // Soll Logik, Grafik (und Audio) deaktivieren, wenn die Vollbild-Szene darüber liegt
                .setRules(new Rules(Setting.ON, Setting.ON, Setting.ON), fullscreenTag)
                // Soll nur Logik deaktivieren, wenn die teilweise-verdeckende Szene darüber liegt
                .setRules(new Rules(Setting.KEEP, Setting.ON, Setting.KEEP), partiallyCoveringTag);

        backgroundScene = new TestScene(coverSettings);

        fullScreenScene = new TestScene(coverSettings);
        fullScreenScene.tags.add(fullscreenTag);

        partiallyCoveringScene = new TestScene(coverSettings);
        partiallyCoveringScene.tags.add(partiallyCoveringTag);

        sceneStack = new SceneStack();
    }

    @BeforeEach
    public void beforeEach() {
        sceneStack.clear();
        hasUpdated.clear();
        hasDrawn.clear();
        hasUnloaded.clear();
    }


}
