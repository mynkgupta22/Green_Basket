package com.masai.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@Getter
@Setter
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

	@Embedded
	private List<VegetableDTO> vegetable=new ArrayList<>();


}
