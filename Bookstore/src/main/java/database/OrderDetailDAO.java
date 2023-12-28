package database;

import java.util.ArrayList;

import model.Order;
import model.OrderDetail;

public class OrderDetailDAO implements DAOInterface<OrderDetail> {

	private ArrayList<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();

	@Override
	public ArrayList<OrderDetail> selectAll() {
		return this.orderDetailList;
	}

	@Override
	public OrderDetail selectById(OrderDetail t) {
		for (OrderDetail a : this.orderDetailList) {
			if (a.equals(t)) {
				return a;
			}
		}
		return null;
	}

	@Override
	public int insert(OrderDetail cat) {
		if (selectById(cat) == null) {
			orderDetailList.add(cat);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<OrderDetail> orderDetailList) {
		int count = 0;
		for (OrderDetail cat : orderDetailList) {
			count += insert(cat);
		}
		return count;
	}

	@Override
	public int delete(OrderDetail cat) {
		if (selectById(cat) != null) {
			orderDetailList.remove(cat);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<OrderDetail> orderDetailList) {
		int count = 0;
		for (OrderDetail cat : orderDetailList) {
			count += delete(cat);
		}
		return count;
	}
	
	public int deleteAll(Order order) {
		int count = 0;
		for (OrderDetail o : orderDetailList) {
			if (o.getOrder().equals(order)) {
				count += delete(o);
			}
		}
		return count;
	}

	@Override
	public int update(OrderDetail cat) {
		if (selectById(cat) != null) {
			orderDetailList.remove(cat);
			orderDetailList.add(cat);
			return 1;
		}
		return 0;
	}

	@Override
	public int updateAll(ArrayList<OrderDetail> orderDetailList) {
		int count = 0;
		for (OrderDetail cat : orderDetailList) {
			count += update(cat);
		}
		return count;
	}

}
