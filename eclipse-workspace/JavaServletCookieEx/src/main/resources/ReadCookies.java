package com.jcg.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/readCookiesServlet")
public class ReadCookies extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    /***** This Method Is Called By The Servlet Container To Process A 'GET' Request *****/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        handleRequest(request, response);
    }
 
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
 
        Cookie cookie = null;
        Cookie[] cookies = null;
        boolean isPresent = false;
 
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
            out.println("<h2 align = \"center\">Found Cookies Name and Value</h2>\n" + 
                    "<table width = \"100px\" border = \"1\" align = \"center\">\n" +
                    "<tr bgcolor = \"lightgrey\">\n" +
                    "<th>Cookie Name</th><th>Cookie Value(s)</th>\n"+
                    "</tr>\n");
 
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if(cookie.getName( ).equals("first_name")) {
                    isPresent = true;
                }
                out.println("<tr><td>" + cookie.getName( ) + "</td>\n");
                out.println("<td>" + cookie.getValue( ) + "</td></tr>\n");
            }
            out.println("</table>\n");
 
            if(isPresent) {
                out.println("<div style='padding-top: 63px; text-align: center; padding-left: 16px;'>"
                        + "Do you want to 'Delete' a cookie? Click <a href='delete' style='text-decoration: none; cursor: pointer;'>this</a> link.</div>\n");
            }           
        } else {
            out.println("<h2 align = \"center\">No Cookies Found ....!</h2>");
        }
        out.println("</body></html>");
        out.close();
    }
}