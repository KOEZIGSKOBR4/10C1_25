package czg.sound;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SoundGroup {

    /**
     * Globale Sound-Gruppe
     */
    public static final SoundGroup GLOBAL_SOUNDS = new SoundGroup();


    /**
     * Wird von {@link #pause()} befüllt und von {@link #resume()} ausgelesen.
     * Dient gleichzeitig als Liste aller Sounds in der Gruppe.
     */
    private final Map<BaseSound, Boolean> soundsAndResumePlaybackStates = new HashMap<>();

    /**
     * Ob die Sounds gerade pausiert sind
     */
    private boolean paused = false;

    /**
     * Einen neuen Sound zur Gruppe hinzufügen. Tut nichts, wenn der Sound
     * bereits in der Gruppe ist.
     * @param sound Sound-Objekt
     */
    public void addSound(BaseSound sound) {
        if(sound.isStopped) {
            System.err.println("Kann gestoppten Sound nicht zur Szene hinzufügen: "+sound);
            return;
        }

        soundsAndResumePlaybackStates.putIfAbsent(sound, true);
    }

    /**
     * Fügt mehrere Sounds auf einmal zur Gruppe hinzu
     * @param sounds {@link Set} von Sounds. Wahrscheinlich von {@link #stop()} erhalten.
     */
    public void addAllSounds(Set<BaseSound> sounds) {
        sounds.forEach(this::addSound);
    }

    /**
     * Entfernt einen Sound aus der Sound-Gruppe. Falls {@link BaseSound#persistentAcrossSceneChange} {@code true} ist,
     * wird {@link BaseSound#stop()} aufgerufen.
     * @param sound Der zu entfernende Sound
     */
    public void removeSound(BaseSound sound) {
        if(! soundsAndResumePlaybackStates.containsKey(sound)) {
            System.err.println("Kann nicht aus der Sound-Gruppe entfernt werden (nicht enthalten): "+sound);
            return;
        }

        if(!sound.persistentAcrossSceneChange)
            sound.stop();

        soundsAndResumePlaybackStates.remove(sound);
    }


    /**
     * Stoppt alle Sounds, für die {@link BaseSound#persistentAcrossSceneChange} auf {@code true} gesetzt ist.
     * @return Ein {@link Set} mit allen Sounds, die in die nächste Szene übertragen werden sollten
     */
    public Set<BaseSound> stop() {
        if(soundsAndResumePlaybackStates.isEmpty())
            return Set.of();

        Set<BaseSound> persistent = new HashSet<>();

        for(BaseSound sound : soundsAndResumePlaybackStates.keySet()) {
            if(sound.persistentAcrossSceneChange) {
                persistent.add(sound);
            } else {
                sound.stop();
            }
        }

        soundsAndResumePlaybackStates.clear();

        return persistent;
    }

    /**
     * Pausiert alle Sounds
     */
    public void pause() {
        if(paused)
            return;

        clean();

        for(BaseSound sound : Set.copyOf(soundsAndResumePlaybackStates.keySet())) {
            soundsAndResumePlaybackStates.put(sound, sound.isPlaying());
            sound.setPlaying(false);
        }

        paused = true;
    }

    /**
     * Setzt die Wiedergabezustände aller Sounds so zurück,
     * wie sie vor dem Aufruf von {@link #pause()} waren
     */
    public void resume() {
        if(! paused)
            return;

        clean();

        for(BaseSound sound : soundsAndResumePlaybackStates.keySet()) {
            sound.setPlaying(soundsAndResumePlaybackStates.get(sound));
        }

        paused = false;
    }

    /**
     * Entfernt alle Sound-Objekte aus der Gruppe die {@link BaseSound#isStopped()} sind.
     */
    private void clean() {
        soundsAndResumePlaybackStates.keySet().removeIf(BaseSound::isStopped);
    }
}
