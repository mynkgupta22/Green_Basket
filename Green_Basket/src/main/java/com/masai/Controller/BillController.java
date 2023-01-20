package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.BillException;
import com.masai.Model.BillDetails;
import com.masai.Services.BillingService;

@RestController
@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	private BillingService cont;
	
	@PostMapping("/add")
	public ResponseEntity<BillDetails> addFrnd(@RequestBody BillDetails addBill) throws BillException{
		
		BillDetails f1=cont.addFrnd(addBill);
		return new ResponseEntity<BillDetails>(f1,HttpStatus.CREATED);
		
	}

}
