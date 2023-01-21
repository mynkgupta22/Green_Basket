package com.masai.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.VegetableException;
import com.masai.Model.Vegetable;
import com.masai.Services.VegetableService;



@RestController
public class VegetableController {

	
	@Autowired
	private VegetableService vs;
	
	
	@PostMapping("/vegetable")
	public ResponseEntity<Vegetable> registerVegetable(@RequestBody Vegetable vegetable){
		System.out.println(vegetable);
		Vegetable veg=vs.addVegetable(vegetable);
		return new ResponseEntity<>(veg,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/vegetables")
	public ResponseEntity<List<Vegetable>> allVegetableList() throws VegetableException{
		
		List<Vegetable> list =vs.listOfVegetables();
		return new ResponseEntity<List<Vegetable>>(list,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/vegetable/{vid}")
	public ResponseEntity<Vegetable> deleteVeg(@PathVariable("vid") Integer vId) throws VegetableException{
		
		Vegetable veg =vs.deleteVegetable(vId);
		return new ResponseEntity<Vegetable>(veg,HttpStatus.OK);
		
	}
	
	@PutMapping("/vegetable/{vid}")
	public ResponseEntity<Vegetable> update(@PathVariable("vid") Integer vId,@RequestBody Vegetable vegetable) throws VegetableException{
		
		Vegetable updated =vs.updateVegetable(vId, vegetable);
		return new ResponseEntity<Vegetable>(updated,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/vegetable/vegname/{vegname}")
	public ResponseEntity<List<Vegetable>> byVegName(@PathVariable("vegname") String veg_name) throws VegetableException{
		
		List<Vegetable> list =vs.getVegetableByName(veg_name);
		
		return new ResponseEntity<List<Vegetable>>(list,HttpStatus.OK);
		
	}

	
	
}
