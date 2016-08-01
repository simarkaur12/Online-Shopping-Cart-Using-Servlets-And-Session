package com.bitwise.onlineShopping;

import java.util.ArrayList;
import java.util.HashMap;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;



public class ShoppingUserDetails {
	private static HashMap<String, String> shoppingUserLoginDetails = new HashMap<String, String>();
	private static HashMap<String, ArrayList<Item>> shoppingCart = new HashMap<String, ArrayList<Item>>();
	private ArrayList<Item> itemsInCart = new ArrayList<>();
	
	public ShoppingUserDetails() {
		super();
		shoppingUserLoginDetails.put("simar", "simar");
		shoppingUserLoginDetails.put("abc", "abc");
		shoppingUserLoginDetails.put("anuja", "anuja");
	}
	
	HashMap<String, String> getUserLogin(){
		return shoppingUserLoginDetails;
	}
	
	HashMap<String, ArrayList<Item>> getShoppingCart(){
		return shoppingCart;
	}
	
	ArrayList<Item> getItemsInCartList(){
		return itemsInCart;
	}
}
