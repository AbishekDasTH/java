package com.ecomerce;

import java.io.BufferedReader;
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
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		String username , password , input_username , input_password,s ;//username1 ;
		try {
		/***	BufferedReader username1 = request.getReader();

			JsonParser jsonParser = Json.createParser(username1);
			// JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
			// JsonObject object = (JsonObject) jsonArray.get(0);
			String elementaryProductId = jsonParser.getString();

			System.out.println("The id is: " + elementaryProductId); ***/
		/* JsonParser j=
		
		s=j.getString();
		response.getWriter().append("hellooo.........").append(s);*/
		  
		
			Class.forName("com.mysql.jdbc.Driver");  
    		Connection con = DriverManager.getConnection(  
    		"jdbc:mysql://localhost:3306/details","root","rohit263");
    	
    		
    		//
    		Statement stmt = con.createStatement(); 
    		input_username = request.getParameter("username");
    		input_password = request.getParameter("password");
    		//response.getWriter().append(input_username);
    		//response.getWriter().append(input_password);
    		
    		ResultSet rs = stmt.executeQuery("select password from registration where user_name='"+input_username+"' ");
    		//stmt.executeQuery("insert into registration values(@username,@password)");
    	
//    		while(rs.next()) {￼

    		//username=rs.getString("user_name");
    		password=rs.getString("password");
    		//response.getWriter().append(username);
    		//response.getWriter().append(password);
    		
    		if(password.equals(input_password)) {
    			response.getWriter().append("Logined Succesfully");
    		}
    		
	//	}
    		con.close();
    		
	}
		catch(Exception e){
			 System.out.println(e);
		}
	}

}
