package database;

import java.util.ArrayList;

import model.Author;

public class AuthorDAO implements DAOInterface<Author> {

	private ArrayList<Author> authors = new ArrayList<Author>();

	@Override
	public ArrayList<Author> selectAll() {
		return this.authors;
	}

	@Override
	public Author selectById(Author t) {
		for (Author a : this.authors) {
			if (a.equals(t)) {
				return a;
			}
		}
		return null;
	}

	@Override
	public int insert(Author author) {
		if (selectById(author) == null) {
			authors.add(author);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<Author> authors) {
		int count = 0;
		for (Author author : authors) {
			count += insert(author);
		}
		return count;
	}

	@Override
	public int delete(Author author) {
		if (selectById(author) != null) {
			authors.remove(author);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<Author> authors) {
		int count = 0;
		for (Author author : authors) {
			count += delete(author);
		}
		return count;
	}

	@Override
	public int update(Author author) {
		if (selectById(author) != null) {
			authors.remove(author);
			authors.add(author);
			return 1;
		}
		return 0;
	}

	@Override
	public int updateAll(ArrayList<Author> authors) {
		int count = 0;
		for (Author author : authors) {
			count += update(author);
		}
		return count;
	}

}
