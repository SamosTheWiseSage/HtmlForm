package servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Arrays;
import java.util.LinkedList;

@WebServlet(name="PersonChooser", urlPatterns= "/personchooser")
public class PersonChooser extends HttpServlet {
private String fname;
private String lname;
private String StudentID;
private String middle;
private String middle2;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            DisplayUserSql(req, resp);
        } catch (SQLException e) {
            System.out.println("jojojo");
            throw new RuntimeException(e);

        } catch (ClassNotFoundException e) {
            System.out.println("kilujfiejfnerijnfirj");
            throw new RuntimeException(e);
        }
        showForm(req, resp);

    }

    @Override
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
                + "<h2>Welcome. this is where you can search out any individual student and get their full school data in one row. including their name, courses and the YHP of said courses </h2><table>";  out.println(top);
        ResultSet rs2 = stmt.executeQuery("Select students.id,Fname,Lname,namn from Students join Associationstabellen on students.id = Associationstabellen.StudentID  Join kurser on kurser.id = Associationstabellen.KursID order by students.id asc");
        while (rs2.next()){
            //print to console column 1 and 2
            middle2 = "<tr style='border: 1px solid black; background-color: #96D4D4;'>" +
                    "<td> Student id" + rs2.getString(1) + "</td><td> First Name " +rs2.getString(2) +"</td><td> Last name "+ rs2.getString(3) +"</td><td> Kurs Name "+ rs2.getString(4)+"</td></tr>";
            out.println(middle2);
        }
        resp.setContentType("text/HTML");
String bottom ="</table>";
out.println(bottom);


        //out.println(bottom);
    }
    private void DisplayUserSql(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //PORT and DbName should be changed
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/GritAcademy", "ReadUser", "ReadUser");
        Statement stmt = con.createStatement(); //System.out.println("hello");
        //TABLENAME should be changed
        PrintWriter out = resp.getWriter();
        fname = req.getParameter("fname");
        lname = req.getParameter("lname");
        StudentID = req.getParameter("StudentID");


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
                + "<h2>Hello from Java Servlet!</h2>" +
                "<table>";
        out.println(top);
        ResultSet rs = stmt.executeQuery("select st.id,Fname,Lname,namn from students st inner join Associationstabellen on st.id = Associationstabellen.StudentID inner Join kurser on kurser.id = Associationstabellen.KursID where StudentID='" + StudentID + "' and Fname='" + fname + "' AND Lname='" + lname + "'");
        while (rs.next()){
            //print to console column 1 and 2
            middle = "<tr style='border: 1px solid black; background-color: #96D4D4;'>" +
                    "<td> id:" + rs.getString(1) + "</td><td> First name:" +rs.getString("Fname") + "</td><td> Last name:"+ rs.getString("Lname") + "</td><td> Kurs:"+rs.getString(4)+"<td></tr>";
            out.println(middle);
        }
        if (StudentID.isEmpty() & rs.next()) {
          rs = stmt.executeQuery("select st.id,Fname,Lname,namn from students st inner join Associationstabellen on st.id = Associationstabellen.StudentID inner Join kurser on kurser.id = Associationstabellen.KursID where StudentID='" + StudentID + "' OR Fname='" + fname + "' AND Lname='" + lname + "'");
            while (rs.next()){
                //print to console column 1 and 2
                middle = "<tr style='border: 1px solid black; background-color: #96D4D4;'>" +
                        "<td> id:" + rs.getString(1) + "</td><td> First name:" +rs.getString("Fname") + "</td><td> Last name:"+ rs.getString("Lname") + "</td><td> Kurs:"+rs.getString(4)+"</td></tr>";
                out.println(middle);
            }
        } else if (fname.isEmpty() & lname.isEmpty() & rs.next()) {
            rs = stmt.executeQuery("select st.id,Fname,Lname,namn from students st inner join Associationstabellen on st.id = Associationstabellen.StudentID inner Join kurser on kurser.id = Associationstabellen.KursID where StudentID='" + StudentID+ "'" );
            while (rs.next()){
                //print to console column 1 and 2
                middle = "<tr style='border: 1px solid black; background-color: #96D4D4;'>" +
                        "<td> id:" + rs.getString(1) + "</td><td>  First name:" +rs.getString("Fname") + "</td><td>  Last name:"+ rs.getString("Lname") + "</td><td>  Kurs:"+rs.getString(4)+"</td><td>";
                out.println(middle);
            }
        }
        else if (!rs.next()){
            String Warning = "<p style='border: 1px solid black; background-color: #96D4D4;'> You have typed in the wrong StudentID or KursID please press reset and try again</p>";
            out.println(Warning);
        }
        resp.setContentType("text/HTML");
String bottom = "</table>";
out.println(bottom);


        //out.println(bottom);
    }
    private void showForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println(
                "<br>"
                        + "<div style='border:black solid; width:200px; padding:5px display:block; margin-left:auto; margin-right:auto; margin-top:5px; margin-bottom:5px;'>"
                        + "<form style='margin:5px;' action=/personchooser method=POST>"
                        + "            <label for=fname>First Name:</label>"
                        + "            <input type=text id=fname name=fname><br><br>"
                        + "             <label for=lname>Last Name:</label>"
                        + "            <input type=text id=lname name=lname><br><br>"
                        +               "<label for=StudentID>StudentID:</label> "
                        +           "<input type=text id=StudentID name=StudentID><br><br>"
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
