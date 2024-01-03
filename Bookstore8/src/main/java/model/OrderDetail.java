package model;

import java.util.Objects;

public class OrderDetail {
	private String orderDetailId;
	private Order order;
	private Product product;
	private int numOrderDetail;
	private double coverPrice;
	private double discount;
	private double realPrice;
	private double vat;
	private double total;

	public OrderDetail() {
	}

	public OrderDetail(String orderDetailId, Order order, Product product, int numOrderDetail, double coverPrice,
			double discount, double realPrice, double vat, double total) {
		this.orderDetailId = orderDetailId;
		this.order = order;
		this.product = product;
		this.numOrderDetail = numOrderDetail;
		this.coverPrice = coverPrice;
		this.discount = discount;
		this.realPrice = realPrice;
		this.vat = vat;
		this.total = total;
	}

	public String getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNumOrderDetail() {
		return numOrderDetail;
	}

	public void setNumOrderDetail(int numOrderDetail) {
		this.numOrderDetail = numOrderDetail;
	}

	public double getCoverPrice() {
		return coverPrice;
	}

	public void setCoverPrice(double coverPrice) {
		this.coverPrice = coverPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(double realPrice) {
		this.realPrice = realPrice;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderDetailId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetail other = (OrderDetail) obj;
		return Objects.equals(orderDetailId, other.orderDetailId);
	}

}
