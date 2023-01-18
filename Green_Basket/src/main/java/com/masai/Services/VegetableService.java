package com.masai.Services;

import java.util.List;

import com.masai.Exception.VegetableException;
import com.masai.Model.Vegetable;



public interface VegetableService {

	public Vegetable addVegetable(Vegetable veg) throws VegetableException;
	
	public Vegetable updateVegetable(Integer vid,Vegetable veg) throws VegetableException;
	
	public Vegetable deleteVegetable (Integer vid) throws VegetableException;
	
	public List<Vegetable> listOfVegetables() throws VegetableException;
	
	public List<Vegetable> getVegetableByName(String veg_name) throws VegetableException;
	
	
	
}
