package Service;

import Entity.Response.TextMessage;
import Resource.Global;
import Util.MessageUtil;
import Util.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by twer on 4/14/15.
 *
 * Handle the incoming requests
 */
public class RequestHandler{
    static Logger log = LoggerFactory.getLogger(RequestHandler.class);

    public static String processRequest(HttpServletRequest request) {
        String respMessage = "Empty Message";

        // 默认返回的文本消息内容
        String respContent = "请求处理异常，请稍候尝试！";

        // xml请求解析
        Map<String, String> requestMap = null;

//        System.setProperty("org.xml.sax.driver","org.xmlpull.v1.sax2.Driver");
        try {
            requestMap = MessageUtil.parseXml(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String fromUserName = requestMap.get("FromUserName");
        // 公众帐号
        String toUserName = requestMap.get("ToUserName");
        // 消息类型
        String msgType = requestMap.get("MsgType");
        String content = requestMap.get("Content");

        // 回复文本消息
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
//            textMessage.setFuncFlag(0);

        // 文本消息
        if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
            respContent = TextMessageHandler.getInstance().processRequest(content);
        }
        // 图片消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
            respContent = "您发送的是图片消息！";
        }
        // 地理位置消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
            respContent = "您发送的是地理位置消息！";
        }
        // 链接消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
            respContent = "您发送的是链接消息！";
        }
        // 音频消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
            respContent = "您发送的是音频消息！";
        }
        // 事件推送
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
            // 事件类型
            String eventType = requestMap.get("Event");
            String eventKey = requestMap.get("EventKey");
            // 订阅
            if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                respContent = "谢谢您的关注！我猜你是小明明";
            }
            // 取消订阅
            else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
            }
            // 自定义菜单点击事件
            else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                log.debug("自定义菜单click事件");
                respContent = EventMessageHandler.getInstance().processRequest(eventKey,content);
            }
        }

        textMessage.setContent(respContent);
        respMessage = MessageUtil.textMessageToXml(textMessage);

        return respMessage;
    }

    public static boolean validate(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");

        log.debug("request received!");
        log.debug("signature:"+signature);
        log.debug("timestamp:"+timestamp);
        log.debug("nonce:"+nonce);


        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            return true;
        }

        return false;
    }
}
