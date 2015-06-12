package Util;

import Resource.Global;

public class WechatRedirectUrlUtil {
    public static String getUrl(String redirectUrl){
        return "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+ Global.APP_ID+"&redirect_uri="+redirectUrl+"&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
    }
}
