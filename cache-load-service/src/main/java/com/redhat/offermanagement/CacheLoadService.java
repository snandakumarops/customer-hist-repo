package com.redhat.offermanagement;


import com.myspace.offermanagement.customerModel.CustomerModel;
import com.myspace.offermanagement.customerModel.PastHistoryModel;
import com.redhat.offerManagement.JdgCustomerRepository;
import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;



import java.util.logging.Logger;

public class CacheLoadService extends AbstractVerticle {

	private static final Logger LOGGER = Logger.getLogger(CacheLoadService.class.getName());

	private CustomerRepository customerRepository = new JdgCustomerRepository();
	private PastHistoryRepository pastHistoryRepository = new JdgPastHistRepository();


	@Override
	public void start() {
		Router router = Router.router(vertx);
		router.route().handler(BodyHandler.create());



		router.get("/*").handler(StaticHandler.create());

		vertx.createHttpServer().requestHandler(router::accept).listen(8080);
		LOGGER.info("THE HTTP APPLICATION HAS STARTED");

		// Populate test payees in the cache, for purposes of the reference example
		CustomerModel customerModel1 = new CustomerModel();
		customerModel1.setCustId("CUST898920");
		customerModel1.setAge(25.0);
		customerModel1.setCustomerClass("PLATINUM");
		customerModel1.setIncome(200.00);

		CustomerModel customerModel2 = new CustomerModel();
		customerModel2.setCustId("CUST898976");
		customerModel2.setAge(42.0);
		customerModel2.setCustomerClass("SILVER");
		customerModel2.setIncome(100.00);

		CustomerModel customerModel3 = new CustomerModel();
		customerModel3.setCustId("CUST898700");
		customerModel3.setAge(65.0);
		customerModel3.setCustomerClass("GOLD");
		customerModel3.setIncome(55.00);

		CustomerModel customerModel4 = new CustomerModel();
		customerModel4.setCustId("CUST898990");
		customerModel4.setAge(22.0);
		customerModel4.setCustomerClass("GOLD");
		customerModel4.setIncome(300.00);

		CustomerModel customerModel5 = new CustomerModel();
		customerModel5.setCustId("CUST892220");
		customerModel5.setAge(34.0);
		customerModel5.setCustomerClass("GOLD");
		customerModel5.setIncome(200.00);

		CustomerModel customerModel6 = new CustomerModel();
		customerModel6.setCustId("CUST898656");
		customerModel6.setAge(55.0);
		customerModel6.setCustomerClass("SILVER");
		customerModel6.setIncome(100.00);

		CustomerModel customerModel7 = new CustomerModel();
		customerModel7.setCustId("CUST894320");
		customerModel7.setAge(55.0);
		customerModel7.setCustomerClass("PLATINUM");
		customerModel7.setIncome(200.00);


		customerRepository.addCustomer(customerModel1);
		customerRepository.addCustomer(customerModel2);
		customerRepository.addCustomer(customerModel3);
		customerRepository.addCustomer(customerModel4);
		customerRepository.addCustomer(customerModel5);
		customerRepository.addCustomer(customerModel6);
		customerRepository.addCustomer(customerModel7);

		LOGGER.info("JDG CACHE: " + customerRepository.getCustomer("CUST894320"));

		PastHistoryModel pastHistoryModel1 = new PastHistoryModel();
		pastHistoryModel1.setCustId("CUST898920");
		pastHistoryModel1.setLastOfferResponse(0);
		pastHistoryModel1.setQualifiedPurchases("AIRLINES");

		PastHistoryModel pastHistoryModel2 = new PastHistoryModel();
		pastHistoryModel2.setCustId("CUST898976");
		pastHistoryModel2.setLastOfferResponse(1);
		pastHistoryModel2.setQualifiedPurchases("HOTEL");

		PastHistoryModel pastHistoryModel3 = new PastHistoryModel();
		pastHistoryModel3.setCustId("CUST898700");
		pastHistoryModel3.setLastOfferResponse(1);
		pastHistoryModel3.setQualifiedPurchases("MERCHANDISE");

		PastHistoryModel pastHistoryModel4 = new PastHistoryModel();
		pastHistoryModel4.setCustId("CUST898990");
		pastHistoryModel4.setLastOfferResponse(0);
		pastHistoryModel4.setQualifiedPurchases("MERCHANDISE");

		PastHistoryModel pastHistoryModel5 = new PastHistoryModel();
		pastHistoryModel5.setCustId("CUST892220");
		pastHistoryModel5.setLastOfferResponse(1);
		pastHistoryModel5.setQualifiedPurchases("HOTEL");

		PastHistoryModel pastHistoryModel6 = new PastHistoryModel();
		pastHistoryModel6.setCustId("CUST898656");
		pastHistoryModel6.setLastOfferResponse(1);
		pastHistoryModel6.setQualifiedPurchases("AIRLINES");

		PastHistoryModel pastHistoryModel7 = new PastHistoryModel();
		pastHistoryModel7.setCustId("CUST894320");
		pastHistoryModel7.setLastOfferResponse(0);
		pastHistoryModel7.setQualifiedPurchases("AIRLINES");


		pastHistoryRepository.addPastHist(pastHistoryModel1);
		pastHistoryRepository.addPastHist(pastHistoryModel2);
		pastHistoryRepository.addPastHist(pastHistoryModel3);
		pastHistoryRepository.addPastHist(pastHistoryModel4);
		pastHistoryRepository.addPastHist(pastHistoryModel5);
		pastHistoryRepository.addPastHist(pastHistoryModel6);
		pastHistoryRepository.addPastHist(pastHistoryModel7);

		LOGGER.info("JDG CACHE: " + pastHistoryRepository.getPastHist("CUST894320"));








	}


}
