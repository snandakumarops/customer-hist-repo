package com.redhat.offermanagement;


import com.myspace.offermanagement.customerModel.PastHistoryModel;

public interface PastHistoryRepository {

	public void addPastHist(PastHistoryModel model);

	public PastHistoryModel getPastHist(String custId);

	public void deletePastHist(String custId);

}
