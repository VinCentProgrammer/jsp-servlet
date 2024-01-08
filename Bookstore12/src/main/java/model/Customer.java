package model;

import java.sql.Date;
import java.util.Objects;

public class Customer {
	private String customerId;
	private String username;
	private String password;
	private String fullname;
	private String gender;
	private String address;
	private String deliveryAddress;
	private String purchaseAddress;
	private Date dateOfBirth;
	private String phoneNumber;
	private String email;
	private boolean subscription;
	private String verifyCode;
	private Date verifyExpire;
	private boolean verifyStatus;

	public Customer() {
	}

	public Customer(String customerId, String username, String password, String fullname, String gender, String address,
			String deliveryAddress, String purchaseAddress, Date dateOfBirth, String phoneNumber, String email,
			boolean subscription) {
		this.customerId = customerId;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.gender = gender;
		this.address = address;
		this.deliveryAddress = deliveryAddress;
		this.purchaseAddress = purchaseAddress;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.subscription = subscription;
	}

	public Customer(String customerId, String username, String password, String fullname, String gender, String address,
			String deliveryAddress, String purchaseAddress, Date dateOfBirth, String phoneNumber, String email,
			boolean subscription, String verifyCode, Date verifyExpire, boolean verifyStatus) {
		this.customerId = customerId;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.gender = gender;
		this.address = address;
		this.deliveryAddress = deliveryAddress;
		this.purchaseAddress = purchaseAddress;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.subscription = subscription;
		this.verifyCode = verifyCode;
		this.verifyExpire = verifyExpire;
		this.verifyStatus = verifyStatus;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getPurchaseAddress() {
		return purchaseAddress;
	}

	public void setPurchaseAddress(String purchaseAddress) {
		this.purchaseAddress = purchaseAddress;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isSubscription() {
		return subscription;
	}

	public void setSubscription(boolean subscription) {
		this.subscription = subscription;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public Date getVerifyExpire() {
		return verifyExpire;
	}

	public void setVerifyExpire(Date verifyExpire) {
		this.verifyExpire = verifyExpire;
	}

	public boolean isVerifyStatus() {
		return verifyStatus;
	}

	public void setVerifyStatus(boolean verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(customerId, other.customerId);
	}

	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + "]";
	}

}
