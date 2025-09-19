package vn.devpro.javaweb32.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_category")
public class Category extends BaseModel {
	@Column(name = "name", length = 300, nullable = false)
	private String name;

	@Column(name = "description", length = 300, nullable = true)
	private String description;

	// ---------------- Mapping many-to-one:
	// category-to-user-create--------------------------------
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "create_by", referencedColumnName = "id")
	private User userCreateCategory;

	// ---------------- Mapping many-to-one:
	// category-to-user-update--------------------------------
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "update_by", referencedColumnName = "id")
	private User userUpdateCategory;

	public Category() {
		super();
	}



	public Category(Integer id, java.sql.Date createDate, java.sql.Date updateDate, Boolean status, String name,
			String description, User userCreateCategory, User userUpdateCategory) {
		super(id, createDate, updateDate, status);
		this.name = name;
		this.description = description;
		this.userCreateCategory = userCreateCategory;
		this.userUpdateCategory = userUpdateCategory;
	}



	public User getUserCreateCategory() {
		return userCreateCategory;
	}

	public void setUserCreateCategory(User userCreateCategory) {
		this.userCreateCategory = userCreateCategory;
	}

	public User getUserUpdateCategory() {
		return userUpdateCategory;
	}

	public void setUserUpdateCategory(User userUpdateCategory) {
		this.userUpdateCategory = userUpdateCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}