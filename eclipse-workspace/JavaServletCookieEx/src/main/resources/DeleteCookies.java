package com.jcg.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class DeleteCookies extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    /***** This Method Is Called By The Servlet Container To Process A 'GET' Request *****/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        handleRequest(request, response);
    }
 
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
 
        Cookie cookie = null;
        Cookie[] cookies = null;
 
        /***** Get An Array Of Cookies Associated With This Domain *****/
        cookies = request.getCookies();
 
        /***** Set Response Content Type *****/
        response.setContentType("text/html");
 
        /***** Print The Response *****/
        PrintWriter out = response.getWriter();
        String title = "Java Servlet Cookie Example";
        String docType ="<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n";
 
        out.println(docType +
                "<html>\n <head><title>" + title + "</title></head>\n <body>\n" );
        if(cookies != null) {
            out.println("<h2 align = \"center\">Cookies Name and Value</h2>\n<div style='text-align: center;'>");
 
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if(cookie.getName( ).compareTo("first_name") == 0) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    out.println("Deleted Cookie Is?= " + cookie.getName( ) + "\n");
                }
            }
            out.println("</div>\n<div style='padding-top: 12px; text-align: center; padding-left: 45px;'>"
                    + "<a href='read' style='text-decoration: none; cursor: pointer;'>Read Updated Cookies</a></div>\n");
        } else {
            out.println("<h2 align = \"center\">No Cookies Found ....!</h2>");
        }
        out.println("</body></html>");
        out.close();
    }
}