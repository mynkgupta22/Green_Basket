package com.masai.Services;

import java.util.List;

import com.masai.Exception.BillException;
import com.masai.Model.BillServiceModel;

public interface BillService {

	public BillServiceModel BillsAdded(BillServiceModel addBills) throws BillException;

	public List<BillServiceModel> getAllBill() throws BillException;

}
