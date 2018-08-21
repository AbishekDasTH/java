package com.ecomerce;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Remove_from_cart
 */
@WebServlet("/Remove_from_cart")
public class Remove_from_cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Remove_from_cart() {
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
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String username , item , sql ;
		username = request.getParameter("username");
		response.getWriter().append(username);
		item = request.getParameter("item");
		response.getWriter().append(item);
		sql = "DELETE FROM cart WHERE username='"+username+"' and item='"+item+"'";
		try {
			Class.forName("com.mysql.jdbc.Driver");  
    		Connection con = DriverManager.getConnection(  
    		"jdbc:mysql://localhost:3306/details","root","rohit263");
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.execute();
    		response.getWriter().append("Deleted Successfully");
    		con.close();
	}catch(Exception e) {
		response.getWriter().append("error");
		}
	}
}
