package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.Model.Vegetable;


@Repository
public interface VegetableDao extends JpaRepository<Vegetable, Integer> {


	public List<Vegetable> findByName(String Name);
	

	
}
