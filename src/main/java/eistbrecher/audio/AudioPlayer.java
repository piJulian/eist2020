package eistbrecher.audio;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.MalformedURLException;
import java.net.URL;

public class AudioPlayer implements MusicService {
    private MediaPlayer myMediaPlayer;
    private String file;
    private boolean playsbackgroundMusic;


    public AudioPlayer(boolean music){
        if(music)
            this.file=MusicService.backgroundMusicFile;
        else
            this.file=MusicService.backgroundMusicFile2;
    }

    @Override
    public void playBackgroundMusic(){
        if(!playsbackgroundMusic) {
            this.playsbackgroundMusic = true;
            URL sourceUrl = getClass().getResource(file);

            if (sourceUrl != null) {
                String source = sourceUrl.toString();
                this.myMediaPlayer = new MediaPlayer(new Media(source));
                this.myMediaPlayer.setAutoPlay(true);
                this.myMediaPlayer.setOnEndOfMedia(() -> AudioPlayer.this.myMediaPlayer.seek(Duration.ZERO));
                this.myMediaPlayer.play();
            } else {
                throw new RuntimeException("Media could not be generated");
            }
        }
    }

    @Override
    public void stopBackgroundMusic() {
        if(playsbackgroundMusic) {
            playsbackgroundMusic = false;
            this.myMediaPlayer.stop();
        }
    }

}






