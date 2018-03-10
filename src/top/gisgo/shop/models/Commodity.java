package top.gisgo.shop.models;

public class Commodity {
	
	private int id;
	private int categoryId;
	private String name;
	private float money;
	private String description;
	private String imgUrl;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Override
	public String toString() {
		return "Commodity [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", money=" + money
				+ ", description=" + description + ", imgUrl=" + imgUrl + "]";
	}
	
}
