

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tryprob.addressdb;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
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
		first.checkbutton="update";
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
         String sql="UPDATE address.address SET firstname='"+ fname +"', lastname='"+ lname +"', studentID='"+ stuid +"', year='"+ year +"', city='"+ country+"', email='"+ email +"' WHERE mi='"+ mi +"'";
         stmt.executeUpdate(sql);
        
         System.out.println("everything is fine!");
         
         String limit="Values updated";
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
