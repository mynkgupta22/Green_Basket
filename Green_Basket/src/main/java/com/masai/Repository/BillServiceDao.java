package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.BillServiceModel;

@Repository
public interface BillserviceDao extends JpaRepository<BillServiceModel,Integer>{

}
