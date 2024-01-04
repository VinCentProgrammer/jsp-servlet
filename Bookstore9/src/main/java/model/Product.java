package model;

import java.util.Objects;

public class Product {
	private String productId;
	private String title;
	private Author author;
	private int publicYear;
	private double importPrice;
	private double rootPrice;
	private double salePrice;
	private int number;
	private Category category;
	private String lang;
	private String description;

	public Product() {
	}

	public Product(String productId, String title, Author author, int publicYear, double importPrice, double rootPrice,
			double salePrice, int number, Category category, String lang, String description) {
		this.productId = productId;
		this.title = title;
		this.author = author;
		this.publicYear = publicYear;
		this.importPrice = importPrice;
		this.rootPrice = rootPrice;
		this.salePrice = salePrice;
		this.number = number;
		this.category = category;
		this.lang = lang;
		this.description = description;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getPublicYear() {
		return publicYear;
	}

	public void setPublicYear(int publicYear) {
		this.publicYear = publicYear;
	}

	public double getImportPrice() {
		return importPrice;
	}

	public void setImportPrice(double importPrice) {
		this.importPrice = importPrice;
	}

	public double getRootPrice() {
		return rootPrice;
	}

	public void setRootPrice(double rootPrice) {
		this.rootPrice = rootPrice;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(productId, other.productId);
	}

}
