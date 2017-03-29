/**
 * 
 */
package com.aequalis.blockchainapi;

/**
 * @author leoanbarasanm
 *
 */
public interface WEBAPI {
	static String BASE = "http://54.243.26.75:3001/";
	
	// REGISTER ENTITY
	static String REGISTER = "http://54.243.26.75:8545/registerNewEntity";
	
	static String REGISTER_DATA = "{ \"id\":\"1\", \"jsonrpc\":\"2.0\", \"method\": \"personal_newAccount\", \"params\": [\"PARAM1\"] }";
	
	//static String UNLOCK = "unlockEntity";
	
	//static String UNLOCK_DATA = "{\"id\":\"1\", \"jsonrpc\":\"2.0\", \"method\": \"personal_unlockAccount\", \"params\":  [ \"PARAM1\", \"PARAM2\", 0 ] }";
	
	//static String BALANCE = "getEntityBalance";
	
	//static String BALANCE_DATA = "{ \"jsonrpc\":\"2.0\", \"method\":\"eth_getBalance\", \"params\":[\"PARAM1\", \"latest\"] , \"id\":1 }";
	
	//static String SENDAMOUNT = "sendCryptoCurrency";
	
	//static String SENDAMOUNT_DATA = "{ \"id\": \"1\", \"method\": \"personal_sendTransaction\", \"params\":  [ { \"from\": \"PARAM1\", \"to\": \"PARAM2\", \"value\": \"0xPARAM3\" }, \"PARAM4\" ] }";

	// ON BOARD CUSTOMER, STORE AND VENDOR
	static String ONBOARDCUSTOMER = "onBoardCustomer";
	
	static String ONBOARDCUSTOMER_DATA = "{ \"_name\": \"PARAM1\", \"_customerAccount\": \"PARAM2\", \"_description\": \"PARAM3\", \"_identifier\": \"PARAM4\", \"_balance\":PARAM5 }";
	
	static String ONBOARDSTORE = "onBoardStore";
	
	static String ONBOARDSTORE_DATA = "{ \"_name\": \"PARAM1\", \"_storeAccount\": \"PARAM2\", \"_description\": \"PARAM3\", \"_storeNumber\": \"PARAM4\", \"_balance\":PARAM5 }";
	
	static String ONBOARDVENDOR = "onBoardVendor";
	
	static String ONBOARDVENDOR_DATA = "{ \"_name\": \"PARAM1\", \"_vendorAccount\": \"PARAM2\", \"_description\": \"PARAM3\", \"_vendorCharge\":PARAM4, \"_balance\":PARAM5 }";

	// ASSOCIATE VENDOR WITH CUSTOMER AND STORE
	static String ASSOCIATEVENDOR = "associateVendor";
	
	static String ASSOCIATEVENDOR_DATA = "{ \"_vendorAccount\": \"PARAM1\", \"_account\": \"PARAM2\" }";
	
	// GET BALANCE OF CUSTOMER, STORE AND VENDOR
	static String CUSTOMERBALANCE = "getCustomerBalance";
	
	static String CUSTOMERBALANCE_DATA = "{ \"_customerAccount\":\"PARAM1\" }";
	
	static String STOREBALANCE = "getStoreBalance";
	
	static String STOREBALANCE_DATA = "{ \"_storeAccount\":\"PARAM1\" }";
	
	static String VENDORBALANCE = "getVendorBalance";
	
	static String VENDORBALANCE_DATA = "{ \"_vendorAccount\":\"PARAM1\" }";
	
	// PAY TO STORE FROM CUSTOMER
	static String PAYSTORE = "payStore";
	
	static String PAYSTORE_DATA = "{ \"_customerAccount\":\"PARAM1\", \"_storeAccount\":\"PARAM2\", \"_paymentAmount\":PARAM3}";
}