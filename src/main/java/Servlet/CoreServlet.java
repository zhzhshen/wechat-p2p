package Servlet;

import Service.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by twer on 4/13/15.
 *
 *
 */
public class CoreServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(AccessTokenServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("core Get request received");
        if (!RequestHandler.validate(request)) {
            return;
        }

        String echostr = request.getParameter("echostr");
        PrintWriter out = response.getWriter();
        out.print(echostr);

        out.close();
        out = null;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("core Post request received");

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

//        if(!RequestHandler.validate(request)){
//            return;
//        }


        Map<String, String> responseMap = RequestHandler.processRequest(request);

//        if(responseMap.get("type")== Global.RESPONSE_TYPE_MESSAGE){
//            logger.debug("===========TextMessage:"+responseMap.get("content")+"==========");
//            PrintWriter out = response.getWriter();
//            out.print(responseMap.get("content"));
//            out.close();
//        } else if (responseMap.get("type")== Global.RESPONSE_TYPE_URL) {
//            logger.debug("===========redirecting:" + responseMap.get("content") + "==========");
//            response.addHeader("openId", "openId");
//            response.addCookie(new Cookie("openId", "openId"));
//        }

        PrintWriter out = response.getWriter();
        out.print(responseMap.get("content"));
        out.close();
    }
}