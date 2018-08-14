package com.ecomerce;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    	
    	 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		String username,password,input_username,input_password;
		input_username=request.getParameter("username");
		input_password=request.getParameter("password");
		//response.getWriter().append(username);
		try{  
    		Class.forName("com.mysql.jdbc.Driver");  
    		Connection con=DriverManager.getConnection(  
    		"jdbc:mysql://localhost:3306/details","root","rohit263");
    		//here sonoo is database name, root is username and password  
    		Statement stmt=con.createStatement();  
    		ResultSet rs=stmt.executeQuery("select * from registration");  
    		while(rs.next()) {
    			username=rs.getString("user_name");
    			password=rs.getString("password");
    			if(username == input_username && password == input_password) {
    				response.getWriter().append("success");
    			}
    			//response.getWriter().append(input_user_name);
    		}
    		//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
    		con.close();  
    		}catch(Exception e){ System.out.println(e);} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String username,password;
		username=request.getParameter("username");
		password=request.getParameter("password");
		
	}

}
