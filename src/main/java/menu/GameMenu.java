package menu;


import demo.DAO.ProductsDAO;
import demo.utilities.Utilities;
import games.Products;



public class GameMenu {

	private Utilities scan;
	private ProductsDAO productsDAO;
	
	public GameMenu() {
		scan = Utilities.getInstance();
		productsDAO = new ProductsDAO();
		
	}
	
	public GameMenu(Utilities scan) {
		this.scan = scan;
		this.productsDAO = new ProductsDAO();
		
	}

	public void create() {
		System.out.println("Title?");
		String title = scan.getString();
		System.out.println("Genre?");
		String genre = scan.getString();
		System.out.println("How many in stock?");
		int stock = scan.getInt();
		System.out.println("How much does it cost?");
		double price = scan.getDbl();
		Products userGame = new Products(title, genre, stock, price);
		productsDAO.create(userGame);
	}
	
	public void update() {
		System.out.println("What ID do you want to update?");
		int id = scan.getInt();
		System.out.println("Title?");
		String title = scan.getString();
		System.out.println("Genre?");
		String genre = scan.getString();
		System.out.println("How many in stock?");
		int stock = scan.getInt();
		System.out.println("How much does it cost?");
		double price = scan.getDbl();
		Products userGame = new Products(id, title, genre, stock, price);
		productsDAO.update(userGame);
	}


}
