package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet(name = "UpdateDbKurs", urlPatterns = "/UpdateDbKurs")
public class UpdatedbKurs extends HttpServlet {
    private String namn;
    private String YHP;
    private String beskrivning;
    private String middle2;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InsertSqlText(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        showForm(req, resp);

    }


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
    private void DisplaySqlText(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //PORT and DbName should be changed
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/GritAcademy", "InsertUser", "InsertUser");
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
                + "<h2>Welcome. this is where you can insert another entry into the UpdatedKurs table. </h2>";
        ResultSet rs2 = stmt.executeQuery("Select id,namn,YHP from Kurser");
        while (rs2.next()){
            //print to console column 1 and 2
            middle2 = "<table>"+
                    "<th style='border: 1px solid black; background-color: #96D4D4;'>" +
                    " Kurs id:" + rs2.getString("id") + ": kurs namn:" +rs2.getString("namn") +": YHP Points:"+ rs2.getString("YHP")+"<br>" +"</th></table>";
            out.println(middle2);
        }
        resp.setContentType("text/HTML");

        out.println(top);

        //out.println(bottom);
    }
    private void InsertSqlText(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //PORT and DbName should be changed
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/GritAcademy", "InsertUser", "InsertUser");
        Statement stmt = con.createStatement(); //System.out.println("hello");
        //TABLENAME should be changed
        PrintWriter out = resp.getWriter();
        namn = req.getParameter("namn");
        YHP = req.getParameter("YHP");
        beskrivning = req.getParameter("beskrivning");
        String sql = "insert into kurser(namn,YHP,beskrivning) Values('"+namn+"','"+YHP+"', '"+beskrivning+"')";
        int rs = stmt.executeUpdate(sql);
        System.out.println(sql);
        String top = "<head><title>Hello " + req.getParameter("name") +  "</title></head>"
                + "<body>"
                +" <nav style='box-sizing: border-box; text-decoration: none;\n" +
                "               font-size: 188%;\n" +
                "               font-weight:lighter;\n" +
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
                "                border:auto;\n" +
                "                border-radius: 50px; \">UpdateDb</a>"+
                "            <a href=\"/UpdateDbKurs\" style=\"border: 1px solid black; background-color: #96D4D4;  padding: 50px;\n" +
                "                width: auto;\n" +
                "                margin-left: auto;\n" +
                "                margin-right: auto;\n" +
                "                border: auto;\n" +
                "                border-radius: 50px; \">UpdateDbKurs</a>\n" +
                "        </nav>"
                + "<h2>Hello from Java Servlet!</h2>";
        resp.setContentType("text/HTML");

        out.println(top);

        //out.println(bottom);
    }
    private void showForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println(
                "<br>"
                        + "<div style='border:black solid; width:200px; padding:5px display:block; margin-left:auto; margin-right:auto; margin-top:5px; margin-bottom:5px;'>"
                        + "<form style='margin:5px;' action=/UpdateDbKurs method=POST>"
                        + "            <label for=namn>Name of the kurs:</label>"
                        + "            <input type=text required=true id=namn name=namn><br><br>"
                        + "             <label for=YHP>YHP:</label><br>"
                        + "            <input type=text required=true id=YHP name=YHP><br><br>"
                        +               "<label for=beskrivning>beskrivning:</label> "
                        +           "<input type=text id=beskrivning name=beskrivning><br><br>"
                        + "            <input type=submit value=Submit>"
                        + "        </form>"
                        + "</div>"
                        + "<br>"+ "<table>\n" +
                        "<button style='display:block; margin-left:auto; margin-right:auto; margin-top:5px; margin-bottom:5px; padding:5px;' id=reset onclick=location.href='/personchooser'>RESET</button></div>\n"+
                        "</body>"
                        + "</html>"
        );
    }
}

