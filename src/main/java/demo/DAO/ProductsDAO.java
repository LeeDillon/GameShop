package demo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import games.Products;
import demo.shop.GameShop;
import demo.utilities.DBUtils;

public class ProductsDAO {

	private static ProductsDAO instance = null;

	public static ProductsDAO getInstance() {
		if (instance == null) {
			instance = new ProductsDAO();
		}
		return instance;
	}

	public Products modelFromResultSet(ResultSet resultSet) throws SQLException {
		int ID = resultSet.getInt("product_id");
		String title = resultSet.getString("title");
		String genre = resultSet.getString("genre");
		int stock = resultSet.getInt("quantity_of_stock");
		double price = resultSet.getDouble("price");
		Products result = new Products(title, genre, stock, price);
		result.setID(ID);
		return result;
	}

	public void create(Products products) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("insert into products values(?,?,?,?,?)");) {
			statement.setInt(1, products.getID());
			statement.setString(2, products.getTitle());
			statement.setString(3, products.getGenre());
			statement.setInt(4, products.getStock());
			statement.setDouble(5, products.getPrice());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Products> readAll() {
		ArrayList<Products> found = new ArrayList<Products>();
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from products")) {
			while (resultSet.next()) {
				found.add(modelFromResultSet(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return found;
	}

	public void readByID(int id) {
		Products found = null;
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from products where product_id="+id))
		{
			if(resultSet.next()) {
				found = modelFromResultSet(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(found); 
	}

	public void update(Products products) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"update products set title=?,genre=?,quantity_of_stock=?,price=? where product_id=?");) {
			statement.setString(1, products.getTitle());
			statement.setString(2, products.getGenre());
			statement.setInt(3, products.getStock());
			statement.setDouble(4, products.getPrice());
			statement.setInt(5, products.getID());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("delete from products");) {
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteByID(int id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("delete from products where product_id=?");) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
