package czg.objects.music_object;

import czg.objects.BaseObject;
import czg.scenes.BaseScene;
import czg.sound.BaseSound;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Objekt zum nahtlosen Abspielen von Musik, die undefiniert oft
 * wiederholt werden soll. So kann zum Beispiel zuerst ein Intro
 * und danach wiederholt ein wiederholbarer Part gespielt werden.
 * Es ist auch möglich, das nächste Segment bereits zu starten,
 * während das aktuelle noch läuft, sodass sie ineinander übergehen.
 * <br> Ein {@link MusicLoopObject} hat keinen {@link BaseObject#sprite}
 * und seine Position und Größe sind irrelevant.
 */
public class MusicLoopObject extends BaseObject {

    /**
     * Speichert {@link SegmentChangeMarker}-Objekte, welche angeben,
     * wann das nächste Segment gespielt werden soll.
     */
    private final Map<BaseSound, SegmentChangeMarker> segmentChangeMarkers = new HashMap<>();

    /**
     * Aktuell spielendes Segment. Siehe {@link #update(BaseScene)}
     */
    private BaseSound currentTrack;

    /**
     * Ein neues {@link MusicLoopObject} erstellen. Siehe
     * {@link #addTrackSegment(BaseSound, SegmentChangeMarker)} zum
     * hinzufügen von Segmenten.
     */
    public MusicLoopObject() {
        super(null, 0, 0, 0, 0);
    }

    /**
     * Ein neues Segment hinzufügen. Das zuerst hinzugefügte
     * Segment wird automatisch abgespielt.
     * @param sound Sound
     * @param marker Information, wann das nächste Segment gestartet werden soll
     */
    public void addTrackSegment(BaseSound sound, SegmentChangeMarker marker) {
        if(currentTrack == null) {
            currentTrack = sound;
            currentTrack.setPlaying(true);
        }

        segmentChangeMarkers.put(sound, marker);
    }

    @Override
    public void draw(Graphics2D g) {}

    @Override
    public void update(BaseScene scene) {
        super.update(scene);

        SegmentChangeMarker marker = segmentChangeMarkers.get(currentTrack);

        // Wenn die angegebene Zeit erreicht ist, wird das nächste
        // Segment gestartet. Das aktuelle Segment könnte dabei noch
        // weiter spielen.
        if(currentTrack.getPosition() >= marker.time()) {
            currentTrack = marker.next();
            currentTrack.setPlaying(true);
        }
    }
}
