package database;

import java.util.ArrayList;

import model.Product;

public class ProductDAO implements DAOInterface<Product> {

	private ArrayList<Product> products = new ArrayList<Product>();

	@Override
	public ArrayList<Product> selectAll() {
		return this.products;
	}

	@Override
	public Product selectById(Product t) {
		for (Product a : this.products) {
			if (a.equals(t)) {
				return a;
			}
		}
		return null;
	}

	@Override
	public int insert(Product product) {
		if (selectById(product) == null) {
			products.add(product);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<Product> products) {
		int count = 0;
		for (Product product : products) {
			count += insert(product);
		}
		return count;
	}

	@Override
	public int delete(Product product) {
		if (selectById(product) != null) {
			products.remove(product);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<Product> products) {
		int count = 0;
		for (Product product : products) {
			count += delete(product);
		}
		return count;
	}

	@Override
	public int update(Product product) {
		if (selectById(product) != null) {
			products.remove(product);
			products.add(product);
			return 1;
		}
		return 0;
	}

	@Override
	public int updateAll(ArrayList<Product> products) {
		int count = 0;
		for (Product product : products) {
			count += update(product);
		}
		return count;
	}

}
