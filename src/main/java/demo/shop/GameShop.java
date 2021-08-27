package demo.shop;

import java.util.ArrayList;


import games.Products;




public class GameShop {

	private ArrayList<Products> gameshop = new ArrayList<Products>();
	
	private static GameShop instance = null;
	
	private GameShop() {
		
	}
	
	public static GameShop getInstance() {
		if (instance == null) {
			instance = new GameShop();
	}
	return instance;
}
	
	public void addProducts(Products game) {
		gameshop.add(game);
	}
	
	public void removeByID(int id) {
		Products found = null;
		for (Products game : gameshop) {
			if (game.getID() == id) {
				found = game;
			}
		}
		gameshop.remove(found);
	}

	public void removeByType(String type) {
		ArrayList<Products> found = new ArrayList<Products>();
		for (Products game : gameshop) {
			if (game.getTitle() == type) {
				found.add(game);
			}
		}
		for(Products destroy: found) {
			gameshop.remove(destroy);
		}
	}

	public double calculatePriceByID(int id) {
		for (Products game : gameshop) {
			if (game.getID() == id) {
				double yeet = game.getPrice();
				return yeet;
			}
		}
		return 0;
	}

	public void checkStockByID(int id) {
		for (Products game : gameshop) {
			if (game.getID() == id) {
				System.out.println("The stock for this game is:" + game.getStock());
			}
		}
	}

	public void printGameShop() {
		for (Products game : gameshop) {
			System.out.println(game);
		}
	}

	public void empty() {
		gameshop.clear();
	}

	public ArrayList<Products> getGameShop() {
		return gameshop;
	}
}