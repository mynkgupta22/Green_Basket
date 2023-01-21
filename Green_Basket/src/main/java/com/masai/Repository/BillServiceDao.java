package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.BillDetails;

public interface BillServiceDao extends JpaRepository<BillDetails, Integer>{


}
