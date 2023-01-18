package com.masai.Controller;

import java.util.List;

import javax.validation.Valid;

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
	public ResponseEntity<Vegetable> registerVegetable(@Valid @RequestBody Vegetable vegetable) throws VegetableException{
		
		Vegetable veg=vs.addVegetable(vegetable);
		return new ResponseEntity<>(veg,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/vegetables")
	public ResponseEntity<List<Vegetable>> allemp() throws VegetableException{
		
		List<Vegetable> list =vs.listOfVegetables();
		return new ResponseEntity<List<Vegetable>>(list,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/vegetable/{vid}")
	public ResponseEntity<Vegetable> delet(@PathVariable("vid") Integer vId) throws VegetableException{
		
		Vegetable empl =vs.deleteVegetable(vId);
		return new ResponseEntity<Vegetable>(empl,HttpStatus.OK);
		
	}
	
	@PutMapping("/vegetable/{vid}")
	public ResponseEntity<Vegetable> update(@Valid @PathVariable("vid") Integer vId,@RequestBody Vegetable customer) throws VegetableException{
		
		Vegetable updates =vs.updateVegetable(vId, customer);
		return new ResponseEntity<Vegetable>(updates,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/vegetable/vegname/{vegname}")
	public ResponseEntity<List<Vegetable>> byVegName(@PathVariable("vegname") String veg_name) throws VegetableException{
		
		List<Vegetable> list =vs.getVegetableByName(veg_name);
		
		return new ResponseEntity<List<Vegetable>>(list,HttpStatus.OK);
		
	}

	
	
}
