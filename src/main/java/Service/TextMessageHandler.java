package Service;

/**
 * Created by twer on 4/14/15.
 *
 * Handle the incoming text messages
 */
public class TextMessageHandler implements IMessageHandler{
    private static TextMessageHandler instance = null;

    public static TextMessageHandler getInstance(){
        if (instance == null) {
            synchronized (TextMessageHandler.class) {
                if (instance == null) {
                    instance = new TextMessageHandler();
                }
            }
        }
        return instance;
    }

    public String processRequest(String openId, String content) {
        String result;
        if (content == null || content.equals("?")){
            result = getMainMenu();
        }
        else if (content.equals("1")){
            result = getLoginPage(openId);
        } else if (content.equals("2")) {
            result = getHomePage();
        } else{
            result = getMainMenu();
        }
        return result;
    }

    private String getHomePage() {
        return "<a href=\"http://52.68.149.90/www/#/\">Home</a>";
    }

    public String processRequest(String content){
        return null;
    }

    private static String getLoginPage(String openId) {
       return "<a href=\"http://52.68.149.90/www/#/mobileCheck/"+openId+"\">登录</a>";
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
