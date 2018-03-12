package top.gisgo.shop.models;

public class Store {
	
	private int id;
	private String title;
	private String address;
	private String phone;
	private String description;
	private String boss;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBoss() {
		return boss;
	}
	public void setBoss(String boss) {
		this.boss = boss;
	}
	@Override
	public String toString() {
		return "Store [id=" + id + ", title=" + title + ", address=" + address + ", phone=" + phone + ", description="
				+ description + ", boss=" + boss + "]";
	}

}
