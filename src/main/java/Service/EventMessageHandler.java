package Service;

import Resource.Global;

/**
 * Created by twer on 4/23/15.
 */
public class EventMessageHandler {
    private static EventMessageHandler instance = null;

    public static EventMessageHandler getInstance(){
        if (instance == null) {
            synchronized (EventMessageHandler.class) {
                if (instance == null) {
                    instance = new EventMessageHandler();
                }
            }
        }
        return instance;
    }

    public String processClickRequest(String eventKey, String openId) {
        String result = null;

        if (eventKey.equals(Global.EVENT_ACCOUNT_PROFILE)){
            result = "查看账户资金";
        } else if (eventKey.equals(Global.EVENT_SUBJECTS)) {
            result = "查看持有标的";
        } else if (eventKey.equals(Global.EVENT_TOPUP)) {
            result = "充值";
        } else if (eventKey.equals(Global.EVENT_WITHDRAW)) {
            result = "取现";
        } else if (eventKey.equals(Global.EVENT_INVESTMENT)) {
            result = "我要投资";
        } else if (eventKey.equals(Global.EVENT_SALES_INFO)) {
            result = "优惠资讯";
        }

        return result;
    }

    public String processViewRequest(String eventKey, String openId) {
        String result = null;

        if (eventKey.equals(Global.EVENT_ACCOUNT_PROFILE)){
            result = "查看账户资金";
        } else if (eventKey.equals(Global.EVENT_SUBJECTS)) {
            result = "查看持有标的";
        } else if (eventKey.equals(Global.EVENT_TOPUP)) {
            result = "充值";
        } else if (eventKey.equals(Global.EVENT_WITHDRAW)) {
            result = "取现";
        } else if (eventKey.equals(Global.EVENT_INVESTMENT)) {
            result = "我要投资";
        } else if (eventKey.equals(Global.EVENT_SALES_INFO)) {
            result = "优惠资讯";
        }

        return result;
    }
}
