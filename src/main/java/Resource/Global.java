package Resource;

/**
 * Created by twer on 4/15/15.
 */
public interface Global {
    // 菜单创建（POST） 限100（次/天）
    public static String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    // 获取access_token的接口地址（GET） 限200（次/天）
    public final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public final static String SERVERS_IP_ADDRESS_URL = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";

    public final static String APP_SECRET = "05b7f721eb9e20bfad0af50ab3f0e85b";

    public final static String APP_ID = "wx2d182a4c8ff50784";

    public final static String ENCODING_UTF8 = "UTF-8";

    public final static String TOKEN = "twp2ptest";
}
