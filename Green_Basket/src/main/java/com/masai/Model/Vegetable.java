
package com.masai.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

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
	private Integer storage;
	
	public Vegetable(Integer vegId, @NotNull @Size(min = 3, max = 10, message = "length should be 3 to 10") String name,
			@NotNull @Size(min = 3, max = 10, message = "length should be 3 to 10") String type,
			@NotNull @Size(min = 4, max = 10, message = "length should be 4 to 10") String seasonality,
			@NotNull @Size(min = 10, max = 50, message = "nutrition desc should be 10 to 50") String nutrition_Details,
			@NotNull @Size(min = 3, max = 10, message = "Storage should be 3 to 10") Integer storage) {
		super();
		VegId = vegId;
		Name = name;
		Type = type;
		this.seasonality = seasonality;
		this.nutrition_Details = nutrition_Details;
		this.storage = storage;
	}
	


}
