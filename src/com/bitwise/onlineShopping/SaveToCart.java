package com.bitwise.onlineShopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

/**
 * Servlet implementation class SaveToCart
 */
@WebServlet("/SaveToCart")
public class SaveToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveToCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=  response.getWriter();
		HttpSession ssn = request.getSession();
		String name = (String)ssn.getAttribute("name");

		if(name==null){
			out.println("<font color='red'>You are logged out.Login Again</font>");
			request.getRequestDispatcher("/Login.jsp").include(request, response);
		}
		else{
			String item = request.getParameter("items");
			if(item==null){
				out.print("<font color='red'>Select the items first</font>");
				request.getRequestDispatcher("/userShopping.jsp").include(request, response);
			}
			else{
				getListOfSelectedItemsAndAddToHashMap(request, response, out, name);
			}
		}
	}

	private void getListOfSelectedItemsAndAddToHashMap(HttpServletRequest request, HttpServletResponse response,
			PrintWriter out, String name) throws ServletException, IOException {
		String[] listOfItemsSelected = request.getParameterValues("items");
		Item arrayOfItemObjects[] =new Item[listOfItemsSelected.length];
		int i=0;
		for(String getItem : listOfItemsSelected){
			String []a = getItem.split(",");
			arrayOfItemObjects[i] = new Item(a[0],Integer.parseInt(a[1]));
			i++;
		}
		if(listOfItemsSelected[0].equals("select")){
			out.print("<font color='red'>Don't Select Invalid Values( such as select)</font>");
			request.getRequestDispatcher("/userShopping.jsp").include(request, response);
		}
		else{
			AddToHashMap(request, response, out, name, arrayOfItemObjects);
		}
	}

	private void AddToHashMap(HttpServletRequest request, HttpServletResponse response, PrintWriter out, String name, Item[] arrayOfItemObjects) throws ServletException, IOException {
		ShoppingUserDetails details = new ShoppingUserDetails();
		ArrayList<Item> itemsList = details.getItemsInCartList();
		java.util.Collections.addAll(itemsList, arrayOfItemObjects);

		HashMap<String, ArrayList<Item>> shoppingCart = details.getShoppingCart();
		shoppingCart.put(name, itemsList);
		out.println("<font color='green'>items added to your Cart</font>");
		request.setAttribute("hashmap", shoppingCart);
		request.getRequestDispatcher("/userShopping.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
