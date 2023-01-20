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
	

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "customerId")
	private Integer customerId;

	@OneToOne(cascade = CascadeType.ALL)
	private Order order;

	@ElementCollection
  @CollectionTable(name = "vegetableDto", joinColumns = @JoinColumn(name = "cartId"),foreignKey = @ForeignKey(name="vege_cart_fk"))
	private List<VegetableDTO> vegetable = new ArrayList<>();


}
