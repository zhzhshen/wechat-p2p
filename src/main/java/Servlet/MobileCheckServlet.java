package Servlet;

import Resource.Global;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class MobileCheckServlet extends HttpServlet{
    private static Logger logger = LoggerFactory.getLogger(AccessTokenServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("get mobile check");
        String code = req.getParameter("code");

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+ Global.APP_ID+"&secret="+Global.APP_SECRET+"&code="+code+"&grant_type=authorization_code";

        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        con.setRequestMethod("POST");
        con.setDoOutput(true);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();


        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject jsonObject = new JSONObject(response.toString());
        String openId = jsonObject.getString("openid");
        String accessToken = jsonObject.getString("access_token");

        logger.debug(openId+":"+accessToken);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("post mobile check");
    }
}
