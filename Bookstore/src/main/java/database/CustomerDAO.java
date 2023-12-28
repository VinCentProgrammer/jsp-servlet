package database;

import java.util.ArrayList;

import model.Customer;

public class CustomerDAO implements DAOInterface<Customer> {

	private ArrayList<Customer> customers = new ArrayList<Customer>();

	@Override
	public ArrayList<Customer> selectAll() {
		return this.customers;
	}

	@Override
	public Customer selectById(Customer t) {
		for (Customer a : this.customers) {
			if (a.equals(t)) {
				return a;
			}
		}
		return null;
	}

	@Override
	public int insert(Customer customer) {
		if (selectById(customer) == null) {
			customers.add(customer);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<Customer> customers) {
		int count = 0;
		for (Customer customer : customers) {
			count += insert(customer);
		}
		return count;
	}

	@Override
	public int delete(Customer customer) {
		if (selectById(customer) != null) {
			customers.remove(customer);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<Customer> customers) {
		int count = 0;
		for (Customer customer : customers) {
			count += delete(customer);
		}
		return count;
	}

	@Override
	public int update(Customer customer) {
		if (selectById(customer) != null) {
			customers.remove(customer);
			customers.add(customer);
			return 1;
		}
		return 0;
	}

	@Override
	public int updateAll(ArrayList<Customer> customers) {
		int count = 0;
		for (Customer customer : customers) {
			count += update(customer);
		}
		return count;
	}

}
