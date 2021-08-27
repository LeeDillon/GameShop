package demo;

//import demo.DAO.ProductsDAO;
//import demo.domain.JDBCConnection;
//import demo.utilities.Utilities;
import menu.Menu;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		JDBCConnection dbCon = new JDBCConnection(Utilities.getUser(),Utilities.getPass());
//		String query = "INSERT INTO products (title,genre,quantity_of_stock,price) "
//				+ "VALUES('Super Mario','Platformer',45,44.99)";
//		dbCon.exUpdate(query);
		Menu menu = new Menu();
		menu.start();
		
		
		
	}

}
