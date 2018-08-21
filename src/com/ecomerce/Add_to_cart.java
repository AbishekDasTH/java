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
 * Servlet implementation class Add_to_cart
 */
@WebServlet("/Add_to_cart")
public class Add_to_cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_to_cart() {
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

	/**
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
		String username,item,sql;
		int quantity;
	//	JSONObject j=new JSONObject();
		username =  request.getParameter("username");
		//System.out.println(username);
		response.getWriter().append(username);
		
		item =  request.getParameter("item");
		response.getWriter().append(item);
		//System.out.println(item);
		
		try {
		quantity = Integer.parseInt(request.getParameter("quantity"));
		System.out.println(quantity);
		
		
		
		sql = "INSERT INTO cart(username,item,quantity)" + " VALUES(?,?,?)";
		
			Class.forName("com.mysql.jdbc.Driver");  
    		Connection con=DriverManager.getConnection(  
    		"jdbc:mysql://localhost:3306/details","root","rohit263");
    		//here details is database name, root is username and rohit263 is password
    		PreparedStatement pstmt = con.prepareStatement(sql);
    		pstmt.setString(1, username);
    		pstmt.setString(2, item);
    		pstmt.setInt(3, quantity);
    		pstmt.execute();
    		response.getWriter().append("Details added to cart Succesfully");
    		//Statement stmt=con.createStatement();  
    		//esultSet rs=stmt.executeQuery("select * from registration");
    		//stmt.executeQuery("insert into registration values(@username,@password)");
    		con.close();
		}
		catch(Exception e){
			 System.out.println(e);
		}
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu
	}

}
