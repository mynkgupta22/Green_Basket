package com.masai.Model;

import javax.persistence.Entity;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
public class Vegetable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer VegId;
	@NotNull
	@Size(min=3,max =10	,message = "length should be 3 to 10")
	private String Name;
	@NotNull
	@Size(min=3,max =10	,message = "length should be 3 to 10")
	private String Type;
	@NotNull
	@Size(min=4,max =10	,message = "length should be 4 to 10")
	private String seasonality;
	@NotNull
	@Size(min=10,max =50	,message = "nutrition desc should be 10 to 50")
	private String nutrition_Details;
	@NotNull
	@Size(min=3,max =10	,message = "Storage should be 3 to 10")
	private String storage;
	@NotNull
	@Size(min=1,max =10	,message = "shel_lyf should be 1 day to 10 days")
	private String shelf_life;
	@NotNull
	@Size(min=3,max =50	,message = "descrption length should be 3 to 50")
	private String descrption;
	@NotNull
//	@Size(min=1,max=500, message = "unit should be greater than 0 ")
	private int Quantity;
	@NotNull
//	@DecimalMin("1")
//	@DecimalMax("10000")
	private Double Price;
	
	
	
	
	
	










	public Vegetable(Integer vid,
			@NotNull @Size(min = 3, max = 10, message = "length should be 3 to 10") String veg_name,
			@NotNull @Size(min = 3, max = 10, message = "length should be 3 to 10") String veg_type,
			@NotNull @Size(min = 4, max = 10, message = "length should be 4 to 10") String seasonality,
			@NotNull @Size(min = 10, max = 50, message = "nutrition desc should be 10 to 50") String nutrition_Details,
			@NotNull @Size(min = 3, max = 10, message = "Storage should be 3 to 10") String storage,
			@NotNull @Size(min = 1, max = 10, message = "shel_lyf should be 1 day to 10 days") String shelf_life,
			@NotNull @Size(min = 3, max = 50, message = "descrption length should be 3 to 50") String descrption,
			@NotNull int unit, @NotNull Double price) {
		super();
		this.VegId = vid;
		this.Name = veg_name;
		this.Type = veg_type;
		this.seasonality = seasonality;
		this.nutrition_Details = nutrition_Details;
		this.storage = storage;
		this.shelf_life = shelf_life;
		this.descrption = descrption;
		this.Quantity = unit;
		this.Price = price;
	}










	public Vegetable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	





	public Integer getVid() {
		return VegId;
	}
	public void setVid(Integer vid) {
		this.VegId = vid;
	}
	public String getVeg_name() {
		return Name;
	}
	public void setVeg_name(String veg_name) {
		this.Name = veg_name;
	}
	public String getVeg_type() {
		return Type;
	}
	public void setVeg_type(String veg_type) {
		this.Type = veg_type;
	}
	public String getSeasonality() {
		return seasonality;
	}
	public void setSeasonality(String seasonality) {
		this.seasonality = seasonality;
	}
	public String getNutrition_Details() {
		return nutrition_Details;
	}
	public void setNutrition_Details(String nutrition_Details) {
		this.nutrition_Details = nutrition_Details;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getShelf_life() {
		return shelf_life;
	}
	public void setShelf_life(String shelf_life) {
		this.shelf_life = shelf_life;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public int getUnit() {
		return Quantity;
	}
	public void setUnit(int unit) {
		this.Quantity = unit;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		this.Price = price;
	}
	
	
	
	@Override
	public String toString() {
		return "Vegetable [vid=" + VegId + ", veg_name=" + Name + ", veg_type=" + Type + ", seasonality="
				+ seasonality + ", nutrition_Details=" + nutrition_Details + ", storage=" + storage + ", shelf_life="
				+ shelf_life + ", descrption=" + descrption + ", unit=" + Quantity + ", price=" + Price + "]";
	}
	
	
	
}
