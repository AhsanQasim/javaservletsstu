

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tryprob.addressdb;
import tryprob.globalnext;

/**
 * Servlet implementation class first
 */
@WebServlet("/first")
public class first extends HttpServlet {
	public static int globalmi;
	public static String checkbutton="first";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public first() {
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
		addressdb mydb=new addressdb();
		Connection conn=mydb.getcon();
		Statement stmt=null;
		globalnext.globalnext=1;
		try {
		 stmt = conn.createStatement();
         String sql="SELECT * FROM address.address LIMIT 1";
         System.out.println("everything is fine!");
         ResultSet rs = stmt.executeQuery(sql);
         while(rs.next()){
             //Retrieve by column name
             globalmi  = rs.getInt("mi");
             request.setAttribute("mii", globalmi);
             request.setAttribute("bool", checkbutton);
             String Stuid = rs.getString("studentID");
             request.setAttribute("Stuidi", Stuid);
             String first = rs.getString("firstname");
             request.setAttribute("firsti", first);
             String last = rs.getString("lastname");
             request.setAttribute("lasti", last);
             String city = rs.getString("city");
             request.setAttribute("countryi", city);
             String email = rs.getString("email");
             request.setAttribute("emaili", email);
             int year = rs.getInt("year");
             request.setAttribute("yeari", year);
             request.getRequestDispatcher("/tryindex.jsp").forward(request, response);
             System.out.println("dispatched!");

         }
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
	    System.out.println("servletgoodbye!");
	}

}
