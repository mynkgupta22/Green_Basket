
package com.masai.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.Objects;

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

	private String imageUrl;

	//@NotNull
	//@Size(min=3,max =10	,message = "length should be 3 to 10")
	private String type;

	//@NotNull
	//@Size(min=3,max =10	,message = "Storage should be 3 to 10")
	private Integer quantity;

	//@NotNull
	private Double price;


}
