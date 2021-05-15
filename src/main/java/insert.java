

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tryprob.addressdb;
import tryprob.globalnext;

/**
 * Servlet implementation class insert
 */
@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lname=request.getParameter("tlname");
		String fname=request.getParameter("tfname");
		String mi=request.getParameter("tmi");
		String stuid=request.getParameter("tstuid");
		String year=request.getParameter("tyear");
		String country=request.getParameter("tcountry");
		String email=request.getParameter("temail");
		
		addressdb mydb=new addressdb();
		Connection conn=mydb.getcon();
		Statement stmt=null;
		try {
		 stmt = conn.createStatement();
         String sql="INSERT INTO address.address(mi,firstname,lastname,studentID,year,city,email) VALUES ('"+ mi +"','"+ fname +"','"+ lname +"','"+ stuid +"','"+ year +"','"+ country +"','"+ email +"')";
         stmt.executeUpdate(sql);
         System.out.println("everything is fine!");
         stmt = conn.createStatement();
		 String sql2 = "SELECT count(*) FROM address.address";
         ResultSet rs1 = stmt.executeQuery(sql2);
         rs1.next();
         int count = rs1.getInt(1);
         globalnext.globalnext=count;
         
         String limit="Values Inserted";
    	 request.setAttribute("limiti", limit);
         request.getRequestDispatcher("/tryindex.jsp").forward(request, response);
         System.out.println("dispatched!");
		}catch(SQLException se){
	        //Handle errors for JDBC
	        se.printStackTrace();
	    }catch(Exception e){
	        //Handle errors for Class.forName
	        e.printStackTrace();
	    }finally{
	    	try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
	        try{
	            if(conn!=null)
	                conn.close();
	        }catch(SQLException se){
	            se.printStackTrace();
	        }//end finally try
	    }//end try
	    System.out.println("Goodbye!");
	}

}
