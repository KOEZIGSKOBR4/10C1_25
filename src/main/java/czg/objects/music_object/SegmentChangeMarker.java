package czg.objects.music_object;

import czg.sound.BaseSound;

/**
 * Ein Eintrag für {@link MusicLoopObject}
 * @param time Zeit (siehe {@link BaseSound#getPosition()}), zu welcher {@link #next} zu spielen beginnen soll
 * @param next Nächster Track
 */
public record SegmentChangeMarker(double time, BaseSound next) {}
