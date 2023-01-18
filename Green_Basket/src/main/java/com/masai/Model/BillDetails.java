package com.masai.Model;

import javax.persistence.*;
import java.util.Date;


@Entity
public class BillDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int BillingId;
    private int orderId;
    private String TransactionMode;
    private Date TransactionDate ;
    private String TransactionStatus;
    @Embedded
    private Address address;


    public BillDetails() {
    }

    public BillDetails(int billingId, int orderId, String transactionMode, Date transactionDate, String transactionStatus, Address address) {
        BillingId = billingId;
        this.orderId = orderId;
        TransactionMode = transactionMode;
        TransactionDate = transactionDate;
        TransactionStatus = transactionStatus;
        this.address = address;
    }

    public int getBillingId() {
        return BillingId;
    }

    public void setBillingId(int billingId) {
        BillingId = billingId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getTransactionMode() {
        return TransactionMode;
    }

    public void setTransactionMode(String transactionMode) {
        TransactionMode = transactionMode;
    }

    public Date getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        TransactionDate = transactionDate;
    }

    public String getTransactionStatus() {
        return TransactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        TransactionStatus = transactionStatus;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
