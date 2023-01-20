
package com.masai.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.Size;
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
	private Integer vegId;
	//@NotNull
	//@Size(min=3,max =10	,message = "length should be 3 to 10")

	private String name;
	//@NotNull
	//@Size(min=3,max =10	,message = "length should be 3 to 10")

	private String type;
	//@NotNull
	//@Size(min=4,max =10	,message = "length should be 4 to 10")


	//@NotNull
	//@Size(min=3,max =50	,message = "descrption length should be 3 to 50")
	private String descrption;

	//@NotNull
//	@Size(min=1,max=500, message = "unit should be greater than 0 ")
	private int quantity;

	//@NotNull
//	@DecimalMin("1")
//	@DecimalMax("10000")
	private Double price;



}
