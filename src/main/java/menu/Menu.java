package menu;

import demo.DAO.ProductsDAO;
import demo.shop.GameShop;
import demo.utilities.Utilities;
import games.Products;


public class Menu {

	Utilities scan = Utilities.getInstance();
	GameMenu gameMenu = new GameMenu();
	GameShop gameShop = GameShop.getInstance();
	ProductsDAO productsDAO = ProductsDAO.getInstance();
	

	public void start() {
		while (true) {
			System.out.println("What would you like to do?");
			System.out.println("1) Create");
			System.out.println("2) Read");
			System.out.println("3) Update");
			System.out.println("4) Delete");
			System.out.println("5) Exit");
			int input = scan.getInt();
			switch (input) {
			case 1:
				create();
				break;
			case 2:
				read();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				System.exit(0);
			default:
				start();
			}
		}
	}

	private void create() {
		gameMenu.create();
		}
	
	private void update() {
		gameMenu.update();
		}
	

	private void delete() {
		System.out.println("Delete what?");
		System.out.println("1) All");
		System.out.println("2) By ID");
		int input = scan.getInt();
		switch (input) {
		case 1:
			productsDAO.delete();
		case 2:
			System.out.println("Enter ID?");
			productsDAO.deleteByID(scan.getInt());
		default:
			System.out.println("Invalid");
		}

	}

	private void read() {
		System.out.println("Read what?");
		System.out.println("1) All");
		System.out.println("2) By ID");
		int input = scan.getInt();
		switch (input) {
		case 1:
			for (Products game : productsDAO.readAll()){
				System.out.println(game);
				}
			break;
		case 2:
			System.out.println("Enter ID?");
			productsDAO.readByID(scan.getInt());
			
			break;
		default:
			System.out.println("Invalid");
			
	}
}
}
