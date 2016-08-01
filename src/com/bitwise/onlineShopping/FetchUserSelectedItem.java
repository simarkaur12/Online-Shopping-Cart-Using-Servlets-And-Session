package com.bitwise.onlineShopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FetchUserSelectedItem
 */
@WebServlet("/FetchUserSelectedItem")
public class FetchUserSelectedItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FetchUserSelectedItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=  response.getWriter();
		HttpSession ssn = request.getSession();
		String name= (String) ssn.getAttribute("name");

		if(name==null){
			out.println("<font color='red'>You are logged out.Login Again</font>");
			request.getRequestDispatcher("/Login.jsp").include(request, response);
		}
		else{
			HashMap<String, ArrayList<Item>> itemsInCart = new ShoppingUserDetails().getShoppingCart();
			if(itemsInCart.containsKey(name)&&itemsInCart.get(name).isEmpty()){
				out.println("<font color='red'>Select Some item first</font>");
				request.getRequestDispatcher("/userShopping.jsp").include(request, response);
			}
			else{
				FetchSelectedItems(out, name, itemsInCart);
			}
		}
	}

	private void FetchSelectedItems(PrintWriter out, String name, HashMap<String, ArrayList<Item>> itemsInCart) {
		out.println("<html><body>");
		out.println("<h3>Your Cart Items</h3>");
		out.println("<form action='DeleteFromCart'>");
		out.println("<select id='deleteItems' name='deleteItems'>");
		for(Item item : itemsInCart.get(name)){
			out.println("<option value='"+item.getName()+"'>"+item.getName()+","+item.getCost()+"</option>");
		}
		out.println("</select>");
		out.println("<input type='submit' value='Delete From Cart'>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
