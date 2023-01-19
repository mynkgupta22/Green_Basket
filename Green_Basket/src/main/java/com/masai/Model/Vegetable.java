
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
	




	public Vegetable(Integer vegId, @NotNull @Size(min = 3, max = 10, message = "length should be 3 to 10") String name,
			@NotNull @Size(min = 3, max = 10, message = "length should be 3 to 10") String type,
			@NotNull @Size(min = 4, max = 10, message = "length should be 4 to 10") String seasonality,
			@NotNull @Size(min = 10, max = 50, message = "nutrition desc should be 10 to 50") String nutrition_Details,
			@NotNull @Size(min = 3, max = 10, message = "Storage should be 3 to 10") String storage,
			@NotNull @Size(min = 1, max = 10, message = "shel_lyf should be 1 day to 10 days") String shelf_life,
			@NotNull @Size(min = 3, max = 50, message = "descrption length should be 3 to 50") String descrption,
			@NotNull int quantity, @NotNull Double price) {
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



	
	
}
