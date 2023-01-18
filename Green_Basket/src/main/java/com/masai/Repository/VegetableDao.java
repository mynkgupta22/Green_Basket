package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.Model.Vegetable;



public interface VegetableDao extends JpaRepository<Vegetable, Integer> {

	@Query("select v from Vegetable v where v.veg_name = ?1")
	public List<Vegetable> findByVeg_name(String veg_name);
	
//	@Query("select v from Vegetable v where v.veg_type = ?1")
//	public List<Vegetable> findByveg_type(String veg_type);
//	
//	@Query("select v from Vegetable v where v.seasonality = ?1")
//	public List<Vegetable> findBySeasonality(String seasonality);
	
}
