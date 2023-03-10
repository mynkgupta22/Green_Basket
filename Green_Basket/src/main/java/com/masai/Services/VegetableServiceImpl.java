package com.masai.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.VegetableException;
import com.masai.Model.Vegetable;
import com.masai.Repository.VegetableDao;




@Service
public class VegetableServiceImpl implements VegetableService {
	
	
	@Autowired
	private VegetableDao vr;

	@Override
	public Vegetable addVegetable(Vegetable veg) throws VegetableException {

		if(veg!=null) {
			Vegetable vegetable=vr.save(veg);
			System.out.println(vegetable);
			return vegetable;
		}
		else {
			throw new VegetableException("Input might be incorrect");
		}
		
	}

	@Override
	public Vegetable updateVegetable(Integer vid,Vegetable veg) throws VegetableException {
		// TODO Auto-generated method stub
		Optional<Vegetable> vegetable=vr.findById(vid);
		Vegetable update=vegetable.get();
		if(vegetable.isPresent()) {
			update.setPrice(veg.getPrice());
			update.setQuantity(veg.getQuantity());
			vr.save(update);
			//System.out.println("Price And Unit Update");
			return update;
		}else{
			throw new VegetableException("Not Valid Type");
		}
		

	}

	@Override
	public Vegetable deleteVegetable(Integer vid) throws VegetableException {
		// TODO Auto-generated method stub
		Optional<Vegetable> vegetable=vr.findById(vid);
		if(vegetable.isPresent()) {
			Vegetable veg=vegetable.get();
			vr.delete(veg);
			//System.out.println("Vegetable is Deleted!");
			return veg;
		}
		else
		{
			throw new VegetableException("not valid Vegetable id:"+vid);
		}
	}

	@Override
	public List<Vegetable> listOfVegetables() throws VegetableException {
		// TODO Auto-generated method stub
		
		List<Vegetable> listOfVegetables=vr.findAll();
		if(listOfVegetables.isEmpty()) {
			throw new VegetableException("There is no Vegetable.");
		}
		else {
			return listOfVegetables;
		}
	}

	@Override
	public List<Vegetable> getVegetableByName(String veg_name) throws VegetableException {
		// TODO Auto-generated method stub
		
		List<Vegetable> list=vr.findByName(veg_name);
		if(list!=null) {
			return list;
		}
		else {
			throw new VegetableException("Nat valid vegetable name");
		}
	}


}
