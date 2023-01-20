package com.masai.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	

	private Integer customerId;

	@OneToOne(cascade = CascadeType.ALL)
	private Order order;

	@ElementCollection
	private List<VegetableDTO> vegetable = new ArrayList<>();


}
