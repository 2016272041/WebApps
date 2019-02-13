package com.jcg.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/helloFormServlet")
public class HelloServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    /***** This Method Is Called By The Servlet Container To Process A 'POST' Request *****/
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        handleRequest(request, response);
    }
 
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
 
        /***** Create 'Cookies' For First & Last Name *****/
        Cookie fname = new Cookie("first_name", request.getParameter("first_name"));
        Cookie lname = new Cookie("last_name", request.getParameter("last_name"));
 
        /***** Setting The Expiry Date For Both The Cookies *****/
        int expireTime = 86400;
        fname.setMaxAge(expireTime);
        lname.setMaxAge(expireTime);
 
        /***** Add Both The Cookies In The Response Header *****/
        response.addCookie(fname);
        response.addCookie(lname);
 
        /***** Set Response Content Type *****/
        response.setContentType("text/html");
 
        /***** Print The Response *****/
        PrintWriter out = response.getWriter();
        String title = "Java Servlet Cookie Example";
        String docType ="<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body>\n" +
                "<h2 align = \"center\">" + title + "</h2>\n" +
                "<ul style='text-align: center; list-style: none;'>\n" +
                "<li><strong>First Name</strong>: "
                + request.getParameter("first_name") + "\n" +
                "<li><strong>Last Name</strong>: "
                + request.getParameter("last_name") + "\n" +
                "</ul>\n" +
                "<div style='padding-top: 12px; text-align: center; padding-left: 45px;'><a href='read' style='text-decoration: none; cursor: pointer;'>Read Cookies</a></div>\n" +
                "</body></html>");
        out.close();
    }
}