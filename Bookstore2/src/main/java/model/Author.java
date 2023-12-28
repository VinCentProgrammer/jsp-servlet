package model;

import java.sql.Date;
import java.util.Objects;

public class Author {
	private String authorId;
	private String fullname;
	private Date dateOfBirth;
	private String bio;

	public Author() {
	}

	public Author(String authorId, String fullname, Date dateOfBirth, String bio) {
		this.authorId = authorId;
		this.fullname = fullname;
		this.dateOfBirth = dateOfBirth;
		this.bio = bio;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(authorId, other.authorId);
	}

}
