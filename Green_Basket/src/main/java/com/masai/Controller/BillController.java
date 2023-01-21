package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.BillException;
import com.masai.Model.BillDetails;
import com.masai.Services.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	private BillService cont;
	
	@PostMapping("/addedBill")
	public ResponseEntity<BillDetails> addFrnd(@RequestBody BillDetails addBill) throws BillException{
		
		BillDetails f1=cont.addBill(addBill);
		return new ResponseEntity<BillDetails>(f1,HttpStatus.CREATED);
		
	}
	@PutMapping("/updateBill")
	public ResponseEntity<BillDetails> updateByIdFrnd(@RequestBody BillDetails UpdBill) throws BillException{
		
		BillDetails f2=cont.updateBill(UpdBill);
		return new ResponseEntity<BillDetails>(f2,HttpStatus.CREATED);
		
	}
	@GetMapping("/viewBill")
	public ResponseEntity<List<BillDetails>> viewBill() throws BillException{
		
		List<BillDetails> f3=cont.viewBill();
		return new ResponseEntity<List<BillDetails>>(f3,HttpStatus.OK);
		
		
	}

}
