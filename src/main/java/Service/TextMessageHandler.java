package Service;

/**
 * Created by twer on 4/14/15.
 *
 * Handle the incoming text messages
 */
public class TextMessageHandler {
    public static String processRequest(String content){
        String result = null;
        if (content == null || content.equals("?")){
            result = getMainMenu();
        }
        else if (content.equals("1")){
            result = getLoginPage();
        } else {
            result = getMainMenu();
        }
        return result;
    }

    private static String getLoginPage() {
        String url = "<a href=\"http://pre.quboqu.com/login\">登录</a>";
        return url;
    }

    public static String getMainMenu(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("您好，欢迎使用思沃金融，请回复数字选择服务：").append("\n\n");
        buffer.append("1  登录").append("\n");
        buffer.append("2  注册").append("\n");
        buffer.append("3  查询产品").append("\n");
        buffer.append("4  查询自己").append("\n");
        buffer.append("回复“?”显示此帮助菜单");
        return buffer.toString();
    }
}
