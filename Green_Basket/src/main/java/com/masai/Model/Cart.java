package com.masai.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

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

	@Embedded
	@ElementCollection
	private List<VegetableDTO> vegetable = new ArrayList<>();


}
