package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "UpdateDb", urlPatterns = "/UpdateDb")
public class UpdateDb extends HttpServlet {
private String town;
private String hobby;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            DisplaySqlText(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        showForm(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            DisplaySqlText(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        showForm(req, resp);
    }
    private void InsertSqlText(HttpServletRequest req, HttpServletResponse resp,String fname, String lname) throws ServletException, IOException, SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        //PORT and DbName should be changed
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/GritAcademy", "ReadUser", "ReadUser");
        Statement stmt = con.createStatement(); //System.out.println("hello");
        //TABLENAME should be changed
        PrintWriter out = resp.getWriter();
        fname = req.getParameter("fname");
        lname = req.getParameter("lname");
        town = req.getParameter("Town");
        hobby = req.getParameter("Hobby");


        int rs2 = stmt.executeUpdate("insert into students(Fname,Lname,Town,Hobby) Values('"+fname+"','"+lname+"','"+town+"','"+hobby+"'");


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
                "            <a href=\"/\"style=\"border: 1px solid black; background-color: #96D4D4;  padding: 50px;\n" +
                "                width: auto;\n" +
                "                margin-left: 5%;\n" +
                "                margin-right: auto;\n" +
                "                border: 50px;\n" +
                "                border-radius: 50px; \">HOME</a>\n" +
                "            <a href=\"/personchooser\" style=\"border: 1px solid black; background-color: #96D4D4;  padding: 50px;\n" +
                "                width: auto;\n" +
                "                margin-left: 5%;\n" +
                "                margin-right: auto;\n" +
                "                border: 50px;\n" +
                "                border-radius: 50px; \">Show Person Classes</a>\n" +
                "            <a href=\"/MainBase\" style=\"border: 1px solid black; background-color: #96D4D4;  padding: 50px;\n" +
                "                width: auto;\n" +
                "                margin-left: 5%;\n" +
                "                margin-right: auto;\n" +
                "                border: 50px;\n" +
                "                border-radius: 50px; \">Servlet Redirect</a>\n" +
                "        </nav>"
                + "<h2>Hello from Java Servlet!</h2>";
        String bottom =
                "</body>"
                        + "</html>";

        out.println(top);
        out.println(bottom);
    }
    private void DisplaySqlText(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        //PORT and DbName should be changed
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/GritAcademy", "ReadUser", "ReadUser");
        Statement stmt = con.createStatement(); //System.out.println("hello");
        //TABLENAME should be changed
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
                "            <a href=\"/\"style=\"border: 1px solid black; background-color: #96D4D4;  padding: 50px;\n" +
                "                width: auto;\n" +
                "                margin-left: 5%;\n" +
                "                margin-right: auto;\n" +
                "                border: 50px;\n" +
                "                border-radius: 50px; \">HOME</a>\n" +
                "            <a href=\"/personchooser\" style=\"border: 1px solid black; background-color: #96D4D4;  padding: 50px;\n" +
                "                width: auto;\n" +
                "                margin-left: 5%;\n" +
                "                margin-right: auto;\n" +
                "                border: 50px;\n" +
                "                border-radius: 50px; \">Show Person Classes</a>\n" +
                "            <a href=\"/MainBase\" style=\"border: 1px solid black; background-color: #96D4D4;  padding: 50px;\n" +
                "                width: auto;\n" +
                "                margin-left: 5%;\n" +
                "                margin-right: auto;\n" +
                "                border: 50px;\n" +
                "                border-radius: 50px; \">Servlet Redirect</a>\n" +
                "        </nav>"
                + "<h2>Hello from Java Servlet!</h2>";
        ResultSet rs2 = stmt.executeQuery("Select students.id,Fname,Lname,namn from Students join Associationstabellen on students.id = Associationstabellen.StudentID  Join kurser on kurser.id = Associationstabellen.KursID");
        while (rs2.next()){
            //print to console column 1 and 2
            String middle = "<table>"+
                    "<th style='border: 1px solid black; background-color: #96D4D4;'>" +
                    " " + rs2.getString(1) + " " +rs2.getString(2) + rs2.getString(3) + rs2.getString(4)+"<br>" +"</th></table>";
            out.println(middle);
            System.out.println("GET REQUEST");
        }
        resp.setContentType("text/HTML");

        out.println(top);
    }
    private void showForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println(
                "<br>"
                        + "<div style='border:black solid; width:200px; padding:5px display:block; margin-left:auto; margin-right:auto; margin-top:5px; margin-bottom:5px;'>"
                        + "<form style='margin:5px;' action=/UpdateDb method=POST>"
                        + "            <label for=fname>First Name:</label>"
                        + "            <input type=text id=fname name=fname><br><br>"
                        + "             <label for=lname>Last Name:</label>"
                        + "            <input type=text id=lname name=lname><br><br>" +
                                         "<label for=Town>Town:</label><br>"
                                     +"<input type=text id=Town name=Town><br><br>"+
                                       "<label for=Hobby>Hobby:</label>"
                        +           "<input type=text id=hobby name=hobby><br><br>"
                        + "            <input type=submit value=Submit>"
                        + "        </form>"
                        + "</div>"
                        + "<br>"+ "<table>\n" +
                        "                + <button style='display:block; margin-left:auto; margin-right:auto; margin-top:5px; margin-bottom:5px; padding:5px;' id=reset onclick=location.href='/personchooser'>RESET</button></div>\n"+
                        "</body>"
                        + "</html>"
        );
    }
}