package com.ecomerce;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class View_cart
 */
@WebServlet("/View_cart")
public class View_cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username , sql ,username1 ;
		
		//int quantity;
		username = request.getParameter("username");
		response.getWriter().append(username);
	//	item = request.getParameter("item");
		//response.getWriter().append(item);
		sql = "SELECT * FROM cart WHERE username='"+username+"'";
		
		try {
			//quantity=Integer.parseInt(request.getParameter("quantity"));
			
			Class.forName("com.mysql.jdbc.Driver");  
    		Connection con = DriverManager.getConnection(  
    		"jdbc:mysql://localhost:3306/details","root","rohit263");
    		Statement stmt = con.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
    		while(rs.next()) {
    			response.getWriter().append("\n");
    			response.getWriter().append(rs.getString(1)).append("\t").append(rs.getString(2)).append("\t").append(Integer.toString(rs.getInt(3)));
    		}
    		response.getWriter().append("\n");
    		response.getWriter().append("Updated Successfully");
    		con.close();
	}catch(Exception e) {
		System.out.println("ERROR IS"+e);
		response.getWriter().append("error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
