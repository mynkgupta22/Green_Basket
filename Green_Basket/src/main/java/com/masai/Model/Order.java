package com.masai.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name="Orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderNo;
	
	private Double totalAmount;
	
	private String status;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "order")
	@JsonIgnore
	private Cart cart;
	
    @Embedded
	@ElementCollection
	private List<VegetableDTO> vegetableList=new ArrayList<>();
	

	private Integer customerId;

}
