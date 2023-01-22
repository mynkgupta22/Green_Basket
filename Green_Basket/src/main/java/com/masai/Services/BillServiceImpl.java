package com.masai.Services;

import com.masai.Exception.BillException;
import com.masai.Exception.OrderException;
import com.masai.Model.BillDetails;
import com.masai.Model.Order;
import com.masai.Repository.BillserviceDao;
import com.masai.Repository.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillserviceDao repo;

//    @Autowired
//    private OrderDao orderDao;

    @Override
    public BillDetails BillsAdded(BillDetails addBills) throws BillException {

        if(addBills == null){
            throw new BillException("Bill Can't be Null");
        }
        BillDetails f1=repo.save(addBills);
        return f1;
    }

    @Override
    public List<BillDetails> getAllBill() throws BillException{

        return repo.findAll();
    }

}
