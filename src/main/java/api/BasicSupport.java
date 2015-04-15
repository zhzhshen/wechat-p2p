package api;

import Entity.AccessToken;
import Resource.Global;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by twer on 4/15/15.
 *
 * This class implements the basic support api that Wechat provides
 */
public class BasicSupport {
    public static AccessToken accessToken = null;

    /**
     * 获取access_token
     *
     * @param appid 凭证
     * @param appsecret 密钥
     * @return
     */
    public static AccessToken getAccessToken(String appid, String appsecret) {
        String requestURL = Global.ACCESS_TOKEN_URL.replace("APPID", appid).replace("APPSECRET", appsecret);
        JSONObject jsonObject = HttpHelper.httpRequest(requestURL, "GET", null);
        // 如果请求成功
        if (null != jsonObject) {
            try {
                accessToken = new AccessToken();
                accessToken.setToken(jsonObject.getString("access_token"));
                accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
            } catch (JSONException e) {
                accessToken = null;
                e.printStackTrace();
            }
        }
        return accessToken;
    }

    public static AccessToken getAccessToken() {
        return (accessToken==null)? getAccessToken(Global.APP_ID,Global.APP_SECRET):accessToken;
    }

    //TODO implement the api service for getting the server IPs
    public static List<String> getServerIPAddresses(){
        String requestURL = Global.SERVERS_IP_ADDRESS_URL.replace("ACCESS_TOKEN", getAccessToken().getToken());
        JSONObject jsonObject = HttpHelper.httpRequest(requestURL, "GET", null);

        // 如果请求成功
        if (null != jsonObject) {
            try {
                jsonObject.getString("ip_list");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
