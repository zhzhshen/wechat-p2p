package Entity.Request;

import Entity.BaseMessage;

/**
 * Created by twer on 4/14/15.
 */
public class ImageMessage extends BaseMessage {
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
