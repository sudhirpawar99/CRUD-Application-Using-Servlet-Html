import javax.servlet.http.*;  
import javax.servlet.*;  
import java.io.*;  
import java.sql.*;
public class home extends HttpServlet{  
public void doGet(HttpServletRequest req,HttpServletResponse res)  
throws ServletException,IOException  
{  

res.setContentType("text/html");  
PrintWriter pw=res.getWriter();  
String name=req.getParameter("name");
String addr=req.getParameter("add");
String mno=req.getParameter("mno");
String edu=req.getParameter("edu");
String email=req.getParameter("email");
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
				 pw.println("Connection Successful");
			 }
           			 String query = "insert into crud values(?,?,?,?,?)";
            
                       PreparedStatement st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
                       st.setString(1,name);
					   st.setString(2,addr);
					   st.setString(3,mno);
					   st.setString(4,edu);
					   st.setString(5,email);
					   int r=st.executeUpdate();
					   //con.commit();
					   if (r== 1) 							 
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

