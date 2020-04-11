import javax.servlet.http.*;  
import javax.servlet.*;  
import java.io.*;  
import java.sql.*;
public class second extends HttpServlet{  
public void doGet(HttpServletRequest req,HttpServletResponse res)  
throws ServletException,IOException  
{  
res.setContentType("text/html");//setting the content type  
PrintWriter pw=res.getWriter();
try
{
String URL = "jdbc:mysql://localhost:3306/serv"; 
Connection con = null; 
String driver="com.mysql.jdbc.Driver";
String user="root";
String pass="";
Class.forName(driver);
con=DriverManager.getConnection(URL,user,pass);//get the stream to write the data  
PreparedStatement ps=con.prepareStatement("select * from crud");         
pw.print("<html><body style=\"background-image: url('img1.jpg');background-repeat: no-repeat;background-size: cover;background-position: center;height: 500px;width: 1250px\">");
pw.print("<div align=\"center\" style=\"font-color: red\">");
pw.print("<table width=60% border=1 style=\"background-color=Red\">");  
pw.print("<caption>Result:</caption>");  
ResultSet rs=ps.executeQuery();  
pw.print("<tr style=\"font-color: red \">");  
pw.print("<th bgcolor=\"lightgreen\">NAME</th><th bgcolor=\"lightgreen\">ADDRESS</th><th bgcolor=\"lightgreen\">MOBILE NO</th><th bgcolor=\"lightgreen\">EDUCTAION</th><th bgcolor=\"lightgreen\">EMAIL</th>");  
pw.print("</tr>");  
while(rs.next())  
{  
pw.print("<tr><td bgcolor=\"pink\">"+rs.getString(1)+"</td><td bgcolor=\"pink\">"+rs.getString(2)+"</td><td bgcolor=\"pink\">"+rs.getString(3)+"</td><td bgcolor=\"pink\">"+rs.getString(4)+"</td><td bgcolor=\"pink\">"+rs.getString(5)+"</td></tr>");                 
}  
pw.print("</table>");
pw.print("<u><a href=\"home.html\" style=\"background-color: lightgreen; color: red\">BACK</a>");
pw.print("</body></html>");
}
catch (Exception e2) {System.out.println(e2);}
pw.close();//closing the stream  
}}  