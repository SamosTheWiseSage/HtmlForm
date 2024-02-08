package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet(name = "InsertDbAssociation", urlPatterns = "/InsertDbAssociation")
public class InsertDbAssociation extends HttpServlet {
    private String StudentID;
    private String KursID;
    private String middle2;
    private String middle3;
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InsertSqlText(req, resp);
        } catch (SQLException e) {
            String Warning = "<p> You have typed in the wrong StudentID or KursID please press reset and try again</p>";
            PrintWriter out = resp.getWriter();
            out.println(Warning);
            //throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        showForm(req, resp);

    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            DisplaySqlText(req, resp);
        } catch (SQLException e) {
            System.out.println("hello this works");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("hello this works");
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
        String top = "<head><title>Hello</title></head>"
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
                + "<h2>Welcome. this is where you can insert another entry into the Associations table. </h2>";

        ResultSet rs3 = stmt.executeQuery("Select * from Students");
        while (rs3.next()){
            //print to console column 1 and 2
            middle3 = "<table>"+
                    "<th style='border: 1px solid black; background-color: #96D4D4;'>" +
                    "ID of Student:" + rs3.getString(1) + "<br> Student name:\n" +rs3.getString(2) +"<br> Student Last Name:\n "+ rs3.getString(3) +"<br> Town: "+ rs3.getString(4)+"<br>" +"</th></table>";
            out.print(middle3);
        }ResultSet rs2 = stmt.executeQuery("Select * from Kurser ");
        while (rs2.next()){
            //print to console column 1 and 2
            middle2 = "<table>"+
                    "<th style='border: 1px solid black; background-color: #96D4D4;'>" +
                    " Kurs ID:" + rs2.getString(1) + "<br> Kurs name: " +rs2.getString(2) +"<br> Kurs last name: "+ rs2.getString(3) +"<br>" +"</th></table>";
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
        StudentID = req.getParameter("StudentID");
        KursID = req.getParameter("KursID");
        String sql = "insert into Associationstabellen(StudentID,KursID) Values('"+ StudentID +"','"+ KursID +"')";
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
                "            <a href=\"/InsertDbAssociation\" style=\"border: 1px solid black; background-color: #96D4D4;  padding: 50px;\n" +
                "                width: auto;\n" +
                "                margin-left: auto;\n" +
                "                margin-right: auto;\n" +
                "                border: auto;\n" +
                "                border-radius: 50px; \">InsertDbAssociation</a>\n" +
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
                        + "<form style='margin:5px;' action=/InsertDbAssociation method=POST>"
                        + "            <label for=StudentID>StudentID:</label>"
                        + "            <input type=text id=StudentID name=StudentID><br><br>"
                        + "             <label for=KursID>KursID:</label><br>"
                        + "            <input type=text  id=KursID name=KursID><br><br>"
                        + "            <input type=submit value=Submit>"
                        + "        </form>"
                        + "</div>"
                        + "<br>"+ "<table>\n" +
                        "<button style='display:block; margin-left:auto; margin-right:auto; margin-top:5px; margin-bottom:5px; padding:5px;' id=reset onclick=location.href='/InsertDbAssociation'>RESET</button></div>\n"+
                        "</body>"
                        + "</html>"
        );
    }
}
