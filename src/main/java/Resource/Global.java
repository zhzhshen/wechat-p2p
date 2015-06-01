package Resource;

public interface Global {
    /**
     * App parameters
     */


    /* 个人订阅号测试 */
//    public final static String APP_SECRET = "05b7f721eb9e20bfad0af50ab3f0e85b";
//    public final static String APP_ID = "wx2d182a4c8ff50784";

    public final static String APP_SECRET = "86e14ba953ec74fe13a7b5038735ef14";
    public final static String APP_ID = "wxac7b11d60ee735c4";

    public final static String ENCODING_UTF8 = "UTF-8";
    public final static String TOKEN = "twp2ptest";


    /**
     * URLs
     */

    // 菜单创建（POST） 限100（次/天）
    public static String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    // 获取access_token的接口地址（GET） 限200（次/天）
    public final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public final static String SERVERS_IP_ADDRESS_URL = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";


    /**
     * Event flags
     */
    public final static String EVENT_ACCOUNT_PROFILE = "EVENT_ACCOUNT_PROFILE";
    public final static String EVENT_SUBJECTS = "EVENT_SUBJECTS";
    public final static String EVENT_TOPUP = "EVENT_TOPUP";
    public final static String EVENT_WITHDRAW = "EVENT_WITHDRAW";
    public final static String EVENT_INVESTMENT = "EVENT_INVESTMENT";
    public final static String EVENT_SALES_INFO = "EVENT_SALES_INFO";
    
    public final static String WECHAT_FRONT = "http://www.davidlin.science/front/#";

    public final static String WECHAT_BACKEND = "http://52.68.149.90/wechat";

    public final static String SUBJECTS_URL = WECHAT_FRONT + "/subjects";
    public final static String MY_SUBJECTS_URL = WECHAT_FRONT + "/myInvestments";
    public final static String TRANSACTION_HISTORY_URL = WECHAT_FRONT + "/transactionHistory";
    public final static String TOPUP_URL = WECHAT_FRONT + "/topup";
    public final static String WITHDRAW_URL = WECHAT_FRONT + "/withdraw";
    public final static String MOBILE = WECHAT_BACKEND + "/mobileCheck";
    public final static String REGISTER_URL="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+APP_ID+"&redirect_uri="+"http%3A%2F%2Fwww.davidlin.science%2Fwechat%2FmobileCheck"+"&response_type=code&scope=snsapi_base&state=123#wechat_redirect";

    /**
     * Messages
     */
    public final static String MESSAGE_NEED_LOGIN = "NEED_TO_LOGIN";

    /**
     * Response type
     */
    public final static String RESPONSE_TYPE_MESSAGE = "MESSAGE";
    public final static String RESPONSE_TYPE_URL = "URL";

}
