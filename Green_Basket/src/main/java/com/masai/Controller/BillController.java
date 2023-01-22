package com.masai.Controller;

import java.util.List;

import com.masai.Exception.BillException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.BillServiceModel;
import com.masai.Services.BillService;

@RestController
@RequestMapping("/BillingService")
public class BillController {

	@Autowired
	private BillService f;
	
	
	
	//add
	
	@PostMapping("/addBill")
	public ResponseEntity<BillServiceModel> BillsAdded(@RequestBody BillServiceModel addBills)throws BillException {
		
		BillServiceModel f1=f.BillsAdded(addBills);
		return new ResponseEntity<BillServiceModel>(f1,HttpStatus.CREATED);
		
	}
	

	//Get
	
	@GetMapping("/getAllBill")
	public ResponseEntity<List<BillServiceModel>> getAllBill() throws BillException{
		
		List<BillServiceModel> f2=f.getAllBill();
		return new ResponseEntity<List<BillServiceModel>>(f2,HttpStatus.OK);
		
		
	}

	//update
	
	@PutMapping("/updateBill")
	public ResponseEntity<BillServiceModel> updateBill(@RequestBody BillServiceModel UpdateBills) throws BillException{

		BillServiceModel f4=f.BillsAdded(UpdateBills);
		return new ResponseEntity<BillServiceModel>(f4,HttpStatus.CREATED);


	}
	
	
}














