/**
 * 
 */
package com.aequalis.blockchainapi;

/**
 * @author leoanbarasanm
 *
 */
public interface WEBAPI {
	static String BASE = "http://54.243.26.75:8545/";
	
	static String REGISTER = "registerNewEntity";
	
	static String REGISTER_DATA = "{ \"id\":\"1\", \"jsonrpc\":\"2.0\", \"method\": \"personal_newAccount\", \"params\": [\"PARAM1\"] }";
	
	static String UNLOCK = "unlockEntity";
	
	static String UNLOCK_DATA = "{\"id\":\"1\", \"jsonrpc\":\"2.0\", \"method\": \"personal_unlockAccount\", \"params\":  [ \"PARAM1\", \"PARAM2\", 0 ] }";
	
	static String BALANCE = "getEntityBalance";
	
	static String BALANCE_DATA = "{ \"jsonrpc\":\"2.0\", \"method\":\"eth_getBalance\", \"params\":[\"PARAM1\", \"latest\"] , \"id\":1 }";
	
	static String SENDAMOUNT = "sendCryptoCurrency";
	
	static String SENDAMOUNT_DATA = "{ \"id\": \"1\", \"method\": \"personal_sendTransaction\", \"params\":  [ { \"from\": \"PARAM1\", \"to\": \"PARAM2\", \"value\": \"0xPARAM3\" }, \"PARAM4\" ] }";
}
