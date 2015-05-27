package Service;

import Entity.Response.TextMessage;
import Resource.Global;
import Util.MessageUtil;
import Util.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by twer on 4/14/15.
 * <p>
 * Handle the incoming requests
 */
public class RequestHandler {
    static Logger log = LoggerFactory.getLogger(RequestHandler.class);

    public static Map<String, String> processRequest(HttpServletRequest request) {
        // xml请求解析
        Map<String, String> requestMap = null;

        try {
            requestMap = MessageUtil.parseXml(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String openId = requestMap.get("FromUserName");
        String toUserName = requestMap.get("ToUserName");
        String msgType = requestMap.get("MsgType");

        HashMap<String, String> responseMap = new HashMap<String, String>();

        // 文本消息
        if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
            String respContent = TextMessageHandler.getInstance().processRequest(openId, requestMap.get("Content"));
            String respMessage = returnTextMessage(openId, toUserName, respContent);

            responseMap.put("type", Global.RESPONSE_TYPE_MESSAGE);
            responseMap.put("content", respMessage);

            return responseMap;
        }
        // 图片消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
            return null;
        }
        // 地理位置消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
            return null;
        }
        // 链接消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
            return null;
        }
        // 音频消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
            return null;
        }
        // 事件推送
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
            // 事件类型
            String eventType = requestMap.get("Event");
            String eventKey = requestMap.get("EventKey");
            // 订阅
            if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {

            }
            // 取消订阅
            else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {

            }
            // 自定义菜单点击CLICK事件
            else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                log.debug("自定义菜单click事件");
                String respMessage = returnTextMessage(openId, toUserName, EventMessageHandler.getInstance().processClickRequest(eventKey, openId));

                responseMap.put("type", Global.RESPONSE_TYPE_MESSAGE);
                responseMap.put("content", respMessage);

                return responseMap;
            }
            // 自定义菜单点击VIEW事件
            else if (eventType.equals(MessageUtil.EVENT_TYPE_VIEW)) {
                log.debug("自定义菜单view事件");

                responseMap.put("type", Global.RESPONSE_TYPE_MESSAGE);
                responseMap.put("content", requestMap.get("EventKey"));

                return responseMap;
            }
        }
        return null;
    }

    private static String returnTextMessage(String openId,String toUserName,String content) {
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(openId);
        textMessage.setFromUserName(toUserName);
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

        textMessage.setContent(content);

        return MessageUtil.textMessageToXml(textMessage);
    }

    public static boolean validate(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");

        log.debug("request received!");
        log.debug("signature:" + signature);
        log.debug("timestamp:" + timestamp);
        log.debug("nonce:" + nonce);


        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            return true;
        }

        return false;
    }
}
