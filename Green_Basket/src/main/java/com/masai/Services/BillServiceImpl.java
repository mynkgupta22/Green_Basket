package com.masai.Services;

import java.util.List;

import com.masai.Exception.BillException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.BillserviceDao;
import com.masai.Model.BillServiceModel;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillserviceDao repo;

	@Override
	public BillServiceModel BillsAdded(BillServiceModel addBills) throws BillException {

		if (addBills == null) {
			throw new BillException("Bill Can't be Null");
		}
		BillServiceModel f1 = repo.save(addBills);
		return f1;
	}

	@Override
	public List<BillServiceModel> getAllBill() throws BillException {

		return repo.findAll();
	}

}
