package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;


@WebServlet(urlPatterns = "/MainBase")
public class HomeServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String top = "<head><title>Hello " + req.getParameter("name") +  "</title></head>"
                + "<body>"
                +" <nav style='box-sizing: border-box; text-decoration: none;\n" +
                "               font-size: 188%;\n" +
                "               font-weight:lighter;\n" +
                "               color:gold;\n" +
                "               display: inline-block;\n" +
                "               border: 3px solid black;\n" +
                "               border-radius: 12px; justify-content: center;\n" +
                "            display: flex;\n" +
                "            gap: 30px;'>\n" +
                "            <a href=\"/MainBase\" style=\"border: 1px solid black; background-color: #96D4D4;  padding: 50px;\n" +
                "                width: auto;\n" +
                "                margin-left:auto;\n" +
                "                margin-right: auto;\n" +
                "                border: auto;\n" +
                "                border-radius: 50px; \">HOME</a>\n" +
                "            <a href=\"/personchooser\" style=\"border: 1px solid black; background-color: #96D4D4;  padding: 50px;\n" +
                "                width: auto;\n" +
                "                margin-left: auto;\n" +
                "                margin-right: auto;\n" +
                "                border: auto;\n" +
                "                border-radius: 50px; \">Show Person Classes</a>\n" +
                "   <a href=\"/UpdateDb\" style=\"border: 1px solid black; background-color: #96D4D4;  padding: 50px;\n" +
                "                width: auto;\n" +
                "                margin-left: auto;\n" +
                "                margin-right: auto;\n" +
                "                border: auto;\n" +
                "                border-radius: 50px; \">UpdateDb</a>"+
                "            <a href=\"/UpdateDbKurs\" style=\"border: 1px solid black; background-color: #96D4D4;  padding: 50px;\n" +
                "                width: auto;\n" +
                "                margin-left: auto;\n" +
                "                margin-right: auto;\n" +
                "                border: auto;\n" +
                "                border-radius: 50px; \">UpdateDbKurs</a>\n" +
                "            <a href=\"/InsertDbAssociation\" style=\"border: 1px solid black; background-color: #96D4D4;  padding: 50px;\n" +
                "                width: auto;\n" +
                "                margin-left: auto;\n" +
                "                margin-right: auto;\n" +
                "                border: auto;\n" +
                "                border-radius: 50px; \">InsertDbAssociation</a>\n" +
                "        </nav>"
                + "<h2>Hello this is the homepage where you can navigate to any webpage on the site.</h2>";
        String bottom =
                "</body>"
                        + "</html>";

        out.println(top);
        out.println(bottom);
    }


    protected  void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //System.out.println("redirecting");
        //getServletContext().getRequestDispatcher("/dbconnect").forward(req, resp);
        String top = "<head><title>Hello " + req.getParameter("name") +  "</title></head>"
                + "<body>"
                + "<nav>"
                +   "<a href=/>HOME</a>"
                +   "<a href=/personchooser>Show Person Classes</a>"
                +   "<a href=/home>Servlet Redirect</a>"
                + "</nav>"
                + "<h2>Hello from Java Servlet!</h2>";

        String bottom =
                "</body>"
                        + "</html>";
        PrintWriter out = resp.getWriter();
        out.println(top);
        out.println(bottom);
    }
}
