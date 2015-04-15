package Entity.Response;

import Entity.BaseMessage;

/**
 * Created by twer on 4/14/15.
 */
public class MusicMessage extends BaseMessage{
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}
