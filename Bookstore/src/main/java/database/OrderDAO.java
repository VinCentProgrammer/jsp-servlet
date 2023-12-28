package database;

import java.util.ArrayList;

import model.Order;

public class OrderDAO implements DAOInterface<Order> {

	private ArrayList<Order> orderList = new ArrayList<Order>();

	@Override
	public ArrayList<Order> selectAll() {
		return this.orderList;
	}

	@Override
	public Order selectById(Order t) {
		for (Order a : this.orderList) {
			if (a.equals(t)) {
				return a;
			}
		}
		return null;
	}

	@Override
	public int insert(Order order) {
		if (selectById(order) == null) {
			orderList.add(order);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<Order> orderList) {
		int count = 0;
		for (Order order : orderList) {
			count += insert(order);
		}
		return count;
	}

	@Override
	public int delete(Order order) {
		if (selectById(order) != null) {
			// Delete order detail
			OrderDetailDAO odd = new OrderDetailDAO();
			odd.deleteAll(order);
			// Delete order
			orderList.remove(order);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<Order> orderList) {
		int count = 0;
		for (Order order : orderList) {
			count += delete(order);
		}
		return count;
	}
	

	@Override
	public int update(Order order) {
		if (selectById(order) != null) {
			orderList.remove(order);
			orderList.add(order);
			return 1;
		}
		return 0;
	}

	@Override
	public int updateAll(ArrayList<Order> orderList) {
		int count = 0;
		for (Order order : orderList) {
			count += update(order);
		}
		return count;
	}

}
