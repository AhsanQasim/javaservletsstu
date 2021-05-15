

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
 * Servlet implementation class last
 */
@WebServlet("/last")
public class last extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public last() {
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
		first.checkbutton="last";
		addressdb mydb=new addressdb();
		Connection conn=mydb.getcon();
		Statement stmt=null;
		
		try {
		 stmt = conn.createStatement();
		 String sql = "SELECT count(*) FROM address.address";
         ResultSet rs1 = stmt.executeQuery(sql);
         rs1.next();
         int count = rs1.getInt(1);
         globalnext.globalnext=count;
         int n=count-1;
         String sql2 = "SELECT * FROM address.address LIMIT "+n+",1";
         ResultSet rs = stmt.executeQuery(sql2);
         while(rs.next()){
             //Retrieve by column name
             int mi  = rs.getInt("mi");
             request.setAttribute("miii", mi);
             request.setAttribute("bool", first.checkbutton);
             String Stuid = rs.getString("studentID");
             request.setAttribute("Stuidii", Stuid);
             String first = rs.getString("firstname");
             request.setAttribute("firstii", first);
             String last = rs.getString("lastname");
             request.setAttribute("lastii", last);
             String city = rs.getString("city");
             request.setAttribute("countryii", city);
             String email = rs.getString("email");
             request.setAttribute("emailii", email);
             int year = rs.getInt("year");
             request.setAttribute("yearii", year);
             request.getRequestDispatcher("/tryindex.jsp").forward(request, response);
             System.out.println("dispatched!");

         }
         
         
         System.out.println("everything is fine!");
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
	    System.out.println("lastGoodbye!");
	}

}
