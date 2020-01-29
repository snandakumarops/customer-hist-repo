package com.redhat.offermanagement;


import com.myspace.offermanagement.customerModel.CustomerModel;

public interface CustomerRepository {

	public void addCustomer(CustomerModel account);

	public CustomerModel getCustomer(String custId);

	public void deleteCustomer(String custId);

}
