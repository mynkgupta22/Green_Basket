package com.masai.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.Exception.BillException;
import com.masai.Model.BillDetails;
import com.masai.Repository.BillServiceDao;

public class BillServiceImpl implements BillService{
	
	@Autowired
	private BillServiceDao serv;

	@Override
	public BillDetails addBill(BillDetails addBill) throws BillException {
		if(addBill==null)
			throw new BillException("Bill Can't be Null");
		
		return serv.save(addBill);
	}

	@Override
	public BillDetails updateBill(BillDetails updBill) throws BillException {
       Optional<BillDetails> upt = serv.findById(updBill.getBillingId());
		
		if(upt.isPresent()) {
			return serv.save(upt.get());
		}else
			throw new BillException("Bill Not Exist to Update ");
	}

	@Override
	public List<BillDetails> viewBill() throws BillException {
		return serv.findAll();
	}

	
}
