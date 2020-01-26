package com.redhat.offermanagement;

import com.myspace.offermanagement.customerModel.PastHistoryModel;
import org.infinispan.commons.api.BasicCache;



public class JdgPastHistRepository implements PastHistoryRepository{

	private static final String JDG_CACHE_NAME = "pastTransactionCache";

	private CacheContainerProvider containerProvider = new CacheContainerProvider();
	private BasicCache<String, Object> pastHistCache;

	public JdgPastHistRepository() {
		pastHistCache = containerProvider.getBasicCacheContainer().getCache(JDG_CACHE_NAME);
	}

	@Override
	public void addPastHist(PastHistoryModel model) {
		pastHistCache.put(PastHistManager.encode(model.getCustId()), model);
	}

	@Override
	public PastHistoryModel getPastHist(String custId) {
		PastHistoryModel retrievedAccount = (PastHistoryModel) pastHistCache.get(PastHistManager.encode(custId));
		return retrievedAccount;
	}



	@Override
	public void deletePastHist(String custId) {
		pastHistCache.remove(custId);
	}

}
