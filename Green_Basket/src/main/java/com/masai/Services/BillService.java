package com.masai.Services;

import java.util.List;

import com.masai.Exception.BillException;
import com.masai.Model.BillDetails;

public interface BillService {

	public BillDetails addBill(BillDetails addBill)throws BillException;

	public BillDetails updateBill(BillDetails updBill)throws BillException;

	public List<BillDetails> viewBill()throws BillException ;

}
