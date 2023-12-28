package model;

import java.sql.Date;
import java.util.Objects;

public class Order {
	private String orderId;
	private Customer customer;
	private String deliveryAddress;
	private String address;
	private String statusOrder;
	private String payment;
	private boolean statusPayment;
	private double totalPayment;
	private double remainPayment;
	private Date orderDate;
	private Date shipDate;

	public Order() {
	}

	public Order(String orderId, Customer customer, String deliveryAddress, String address, String statusOrder,
			String payment, boolean statusPayment, double totalPayment, double remainPayment, Date orderDate,
			Date shipDate) {
		this.orderId = orderId;
		this.customer = customer;
		this.deliveryAddress = deliveryAddress;
		this.address = address;
		this.statusOrder = statusOrder;
		this.payment = payment;
		this.statusPayment = statusPayment;
		this.totalPayment = totalPayment;
		this.remainPayment = remainPayment;
		this.orderDate = orderDate;
		this.shipDate = shipDate;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDeliveryAaddress() {
		return deliveryAddress;
	}

	public void setDeliveryAaddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getDdress() {
		return address;
	}

	public void setDdress(String address) {
		this.address = address;
	}

	public String getStatusOrder() {
		return statusOrder;
	}

	public void setStatusOrder(String statusOrder) {
		this.statusOrder = statusOrder;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public boolean isStatusPayment() {
		return statusPayment;
	}

	public void setStatusPayment(boolean statusPayment) {
		this.statusPayment = statusPayment;
	}

	public double getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(double totalPayment) {
		this.totalPayment = totalPayment;
	}

	public double getRemainPayment() {
		return remainPayment;
	}

	public void setRemainPayment(double remainPayment) {
		this.remainPayment = remainPayment;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(orderId, other.orderId);
	}

}
