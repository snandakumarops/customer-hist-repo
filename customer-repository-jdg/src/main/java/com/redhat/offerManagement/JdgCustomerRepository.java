package com.redhat.offerManagement;

import com.myspace.offermanagement.customerModel.CustomerModel;
import com.redhat.offermanagement.CustomerRepository;

import org.infinispan.commons.api.BasicCache;



public class JdgCustomerRepository implements CustomerRepository {

	private static final String JDG_CACHE_NAME = "customerCache";

	private CacheContainerProvider containerProvider = new CacheContainerProvider();
	private BasicCache<String, Object> accountCache;

	public JdgCustomerRepository() {
		accountCache = containerProvider.getBasicCacheContainer().getCache(JDG_CACHE_NAME);
	}

	@Override
	public void addCustomer(CustomerModel customer) {
		System.out.println("added customer"+customer.getCustId()+customer.getCustomerClass());
		accountCache.put(CustomerManager.encode(customer.getCustId()), customer);
	}

	@Override
	public CustomerModel getCustomer(String custId) {
		CustomerModel retrievedAccount = (CustomerModel) accountCache.get(CustomerManager.encode(custId));
		return retrievedAccount;
	}

	@Override
	public void deleteCustomer(String custId) {
		accountCache.remove(custId);
	}

}
