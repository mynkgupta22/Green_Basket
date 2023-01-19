package com.masai.Model;

public class VegetableDTO {

	private Integer VegId;
	private String Name;
	private String Type;
	private Double Price;
	private Integer Quantity;
	public VegetableDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VegetableDTO(Integer vegId, String name, String type, Double price, Integer quantity) {
		super();
		VegId = vegId;
		Name = name;
		Type = type;
		Price = price;
		Quantity = quantity;
	}
	public Integer getVegId() {
		return VegId;
	}
	public void setVegId(Integer vegId) {
		VegId = vegId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public Integer getQuantity() {
		return Quantity;
	}
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	@Override
	public String toString() {
		return "VegetableDTO [VegId=" + VegId + ", Name=" + Name + ", Type=" + Type + ", Price=" + Price + ", Quantity="
				+ Quantity + "]";
	}
	
		
}
