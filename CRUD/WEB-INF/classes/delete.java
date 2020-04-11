import javax.servlet.http.*;  
import javax.servlet.*;  
import java.io.*;  
import java.sql.*;
public class delete extends HttpServlet{  
public void doGet(HttpServletRequest req,HttpServletResponse res)  
throws ServletException,IOException  
{  

res.setContentType("text/html");  
PrintWriter pw=res.getWriter();  
String name=req.getParameter("name");
try{  
String URL = "jdbc:mysql://localhost:3306/serv"; 
Connection con = null; 
String driver="com.mysql.jdbc.Driver";
String user="root";
String pass="";
        Class.forName(driver);
             con=DriverManager.getConnection(URL,user,pass);
             if(con!=null)
			 {
				 pw.println("Connection for delete Successful");
			 }
           			 String query = "delete from crud where name = ?";
            
                       PreparedStatement st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
                       st.setString(1,name);
					   int r=st.executeUpdate();
					   //con.commit();
					   if (r>0) 							 
			            {
			            	
                 				res.sendRedirect("home.html"); 
                            //req.getRequestDispatcher("/second").forward(req, res);
                           //out.println("Data Inserted");
						}
					   else
					   	pw.print("not");
  
con.close();
}catch (Exception e2) {System.out.println(e2);}  
          
pw.close();  
}  
  
} 		
