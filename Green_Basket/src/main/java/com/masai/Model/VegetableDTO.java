package com.masai.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.ManyToOne;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VegetableDTO {

	private Integer vegId;
	private String name;

	private Double price;
	private Integer quantity;


		
}
