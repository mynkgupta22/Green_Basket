package com.masai.Model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name="Orders")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderNo;
	
	private Double totalAmount;
	
	private String status;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Cart cart;
	
    @Embedded
	private List<VegetableDTO> vegetableList=new ArrayList<>();
	

	
	private Integer customerId;


}
