package Servlet;

import Service.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by twer on 4/13/15.
 *
 *
 */
public class CoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

//        if(!RequestHandler.validate(request)){
//            return;
//        }

        String respMessage = RequestHandler.processRequest(request);

        PrintWriter out = response.getWriter();
        out.print(respMessage);
        out.close();
    }
}
