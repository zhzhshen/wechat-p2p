package Entity.Response;

import Entity.BaseMessage;

/**
 * Created by twer on 4/14/15.
 */
public class TextMessage extends BaseMessage {
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
