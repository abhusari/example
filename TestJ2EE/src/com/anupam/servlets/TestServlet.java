package com.anupam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

public class TestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3170828811286320164L;

	int []sampleData=null;
    //sampleData= here you can get data from database

    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Get is called");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Post is called");
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
	/*	if(userName.isEmpty() || password.isEmpty()){
			RequestDispatcher dispatcher =  req.getRequestDispatcher("index.jsp");
			dispatcher.include(req, resp);
			System.out.println("User name :-"+userName+"\nPassword :-"+password);
			PrintWriter out =resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Please enter manatory information.</h1>");
			out.println("</body>");
			out.println("</html>");	
		}else {
			System.out.println("User name :-"+userName+"\nPassword :-"+password);
			PrintWriter out =resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Hello "+userName+"....!!</h1>");
			out.println("</body>");
			out.println("</html>");	
		}*/
		
		//writing data to json
		
	    response.setContentType("application/json;charset=utf-8");

	    JSONObject json = new JSONObject();
	    JSONArray array = new JSONArray();
	    JSONObject member =  new JSONObject();

	   String jsonResponse="";

	    try {
			jsonResponse  = JSONObject.valueToString(new A("Text Message"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Gson gson= new Gson();
	    PrintWriter pw = response.getWriter(); 
	    pw.print(gson.toJson(new A("Text Message")));
	    pw.close();
	    
	}


}

class A{
	String text;

	public A(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
