package api;

import Entity.Menu.Menu;
import Resource.Global;
import org.json.JSONObject;

/**
 * Created by twer on 4/15/15.
 */
public class MenuSupport {

    /**
     * 创建菜单
     *
     * @param menu 菜单实例
     * @return 0表示成功，其他值表示失败
     */
    public static int createMenu(Menu menu) {
        int result = 0;

        // 拼装创建菜单的url
        String url = Global.MENU_CREATE_URL.replace("ACCESS_TOKEN", BasicSupport.getAccessToken().getToken());
        // 将菜单对象转换成json字符串
        String jsonMenu = new JSONObject(menu).toString();
        // 调用接口创建菜单
        JSONObject jsonObject = HttpHelper.httpRequest(url, "POST", jsonMenu);

        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {
                result = jsonObject.getInt("errcode");}
        }

        return result;
    }
}
