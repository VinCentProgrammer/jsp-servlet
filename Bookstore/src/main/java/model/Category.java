package model;

import java.util.Objects;

public class Category {
	private String catId;
	private String catName;

	public Category() {
	}

	public Category(String catId, String catName) {
		this.catId = catId;
		this.catName = catName;
	}

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(catId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(catId, other.catId);
	}

}
