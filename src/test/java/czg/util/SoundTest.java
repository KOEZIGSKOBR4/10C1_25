package czg.util;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import static czg.util.Sounds.TARGET_AUDIO_FORMAT;

public class SoundTest {

    final URL url = Objects.requireNonNull(Sounds.class.getResource("/beep.ogg"));

    // Kann nicht automatisch ausgeführt werden
    public void audioPlayerTest() {
        playBeeps(1);
        playBeeps(2);
        playBeeps(3);
    }

    private void playBeeps(int n) {
        final Thread thread;
        final AudioInputStream in;
        final SourceDataLine line;

        try {
            in = AudioSystem.getAudioInputStream(TARGET_AUDIO_FORMAT, AudioSystem.getAudioInputStream(url));
            line = AudioSystem.getSourceDataLine(TARGET_AUDIO_FORMAT);
            line.open(TARGET_AUDIO_FORMAT);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }


        thread = new Thread(() -> {

            final int bytesPerSecond =
                    (TARGET_AUDIO_FORMAT.getSampleSizeInBits() / 8)
                            * (int) TARGET_AUDIO_FORMAT.getSampleRate()
                            * TARGET_AUDIO_FORMAT.getChannels();

            final byte[] buffer = new byte[(int) (bytesPerSecond * n)];

            line.start();

            try {
                int read = in.read(buffer, 0, buffer.length);
                line.write(buffer, 0, read);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
