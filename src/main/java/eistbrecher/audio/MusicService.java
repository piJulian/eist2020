package eistbrecher.audio;


public interface MusicService{

    public static String backgroundMusicFile = "/mp3/music1.wav";
    public static String backgroundMusicFile2 = "/mp3/music2.wav";

    void playBackgroundMusic();
    void stopBackgroundMusic();
}