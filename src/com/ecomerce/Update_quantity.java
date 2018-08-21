package com.ecomerce;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update_quantity
 */
@WebServlet("/Update_quantity")
public class Update_quantity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_quantity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username , item , sql ;
		int quantity;
		username = request.getParameter("username");
		response.getWriter().append(username);
		item = request.getParameter("item");
		response.getWriter().append(item);
		
		try {
			quantity=Integer.parseInt(request.getParameter("quantity"));
			sql = "UPDATE cart SET quantity='"+quantity+"' WHERE username='"+username+"' and item='"+item+"'";
			Class.forName("com.mysql.jdbc.Driver");  
    		Connection con = DriverManager.getConnection(  
    		"jdbc:mysql://localhost:3306/details","root","rohit263");
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.execute();
    		response.getWriter().append("Updated Successfully");
    		con.close();
	}catch(Exception e) {
		response.getWriter().append("error");
		}
	}

}
