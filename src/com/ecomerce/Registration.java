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
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
	//	doGet(request, response);
		String input_username , input_password , sql ;
		input_username =  request.getParameter("username");
		input_password =  request.getParameter("password");
		sql = "INSERT INTO registration(user_name,password)" + " VALUES(?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");  
    		Connection con=DriverManager.getConnection(  
    		"jdbc:mysql://localhost:3306/details","root","rohit263");
    		//here details is database name, root is username and rohit263 is password
    		PreparedStatement pstmt = con.prepareStatement(sql);
    		pstmt.setString(1,input_username);
    		pstmt.setString(2,input_password);
    		pstmt.execute();
    		response.getWriter().append("Registered Succesfully");
    		//Statement stmt=con.createStatement();  
    		//esultSet rs=stmt.executeQuery("select * from registration");
    		//stmt.executeQuery("insert into registration values(@username,@password)");
    		con.close();
		}
		catch(Exception e){
			 System.out.println(e);
		}
		
	}

}
