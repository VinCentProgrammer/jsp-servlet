package database;

import java.util.ArrayList;

import model.Category;

public class CategoryDAO implements DAOInterface<Category> {

	private ArrayList<Category> catList = new ArrayList<Category>();

	@Override
	public ArrayList<Category> selectAll() {
		return this.catList;
	}

	@Override
	public Category selectById(Category t) {
		for (Category a : this.catList) {
			if (a.equals(t)) {
				return a;
			}
		}
		return null;
	}

	@Override
	public int insert(Category c) {
		if (selectById(c) == null) {
			catList.add(c);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<Category> list) {
		int count = 0;
		for (Category c : list) {
			count += insert(c);
		}
		return count;
	}

	@Override
	public int delete(Category c) {
		if (selectById(c) != null) {
			catList.remove(c);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<Category> list) {
		int count = 0;
		for (Category c : list) {
			count += delete(c);
		}
		return count;
	}

	@Override
	public int update(Category c) {
		if (selectById(c) != null) {
			catList.remove(c);
			catList.add(c);
			return 1;
		}
		return 0;
	}

	@Override
	public int updateAll(ArrayList<Category> list) {
		int count = 0;
		for (Category c : list) {
			count += update(c);
		}
		return count;
	}

}
