/**
 * 
 */
package com.aequalis.blockchainapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.json.JSONObject;

/**
 * @author leoanbarasanm
 *
 */
public class WebAPICall {
	
	public static String registerNewUser(String passcode) {
		String bcAddress = "0x123";
		try {
			URL url = new URL(WEBAPI.BASE + WEBAPI.REGISTER);
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("POST");
			httpCon.setRequestProperty("Content-Type","application/json");
			OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
			String data = WEBAPI.REGISTER_DATA.replace("PARAM1", passcode);
			out.write(data);
			out.close();
		  
			BufferedReader br;
			if (200 <= httpCon.getResponseCode() && httpCon.getResponseCode() <= 299) {
				br = new BufferedReader(new InputStreamReader((httpCon.getInputStream())));
				StringBuilder sb = new StringBuilder();
				String output;
				while ((output = br.readLine()) != null) {
					sb.append(output);
				}
				
				JSONObject json = new JSONObject(sb.toString());
				if(json.has("result"))
					bcAddress = json.getString("result");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bcAddress;
	}
	
	public static Boolean unlockUser(String bcAddress, String passcode) {
		Boolean result = false;
		try {
			URL url = new URL(WEBAPI.BASE + WEBAPI.UNLOCK);
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("POST");
			httpCon.setRequestProperty("Content-Type","application/json");
			OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
			String data = WEBAPI.UNLOCK_DATA.replace("PARAM1", bcAddress).replace("PARAM2", passcode);
			out.write(data);
			out.close();
		  
			BufferedReader br;
			if (200 <= httpCon.getResponseCode() && httpCon.getResponseCode() <= 299) {
				br = new BufferedReader(new InputStreamReader((httpCon.getInputStream())));
				StringBuilder sb = new StringBuilder();
				String output;
				while ((output = br.readLine()) != null) {
					sb.append(output);
				}
				
				JSONObject json = new JSONObject(sb.toString());
				if(json.has("result"))
					result = json.getBoolean("result");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private long parseUnsignedHex(String text) {
        if (text.length() == 16) {
            return (parseUnsignedHex(text.substring(0, 1)) << 60)
                    | parseUnsignedHex(text.substring(1));
        }
        return Long.parseLong(text, 16);
    }
	
	public static String getBalance(String bcAddress) {
		String result = "0";
		try {
			URL url = new URL(WEBAPI.BASE + WEBAPI.BALANCE);
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("POST");
			httpCon.setRequestProperty("Content-Type","application/json");
			OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
			String data = WEBAPI.BALANCE_DATA.replace("PARAM1", bcAddress);
			out.write(data);
			out.close();
		  
			BufferedReader br;
			if (200 <= httpCon.getResponseCode() && httpCon.getResponseCode() <= 299) {
				br = new BufferedReader(new InputStreamReader((httpCon.getInputStream())));
				StringBuilder sb = new StringBuilder();
				String output;
				while ((output = br.readLine()) != null) {
					sb.append(output);
				}
				
				JSONObject json = new JSONObject(sb.toString());
				if (json.has("result")) {
					String balance = json.getString("result");
					if (balance != null && !balance.equals("0x0")) {
						balance = balance.substring(2);
				        
						/*long weiValue = new BigInteger(balance, 16).longValue();
						Double ethValue = weiValue / 1000000000000000000D;
						DecimalFormat formatter = new DecimalFormat("#.#######", DecimalFormatSymbols.getInstance( Locale.ENGLISH ));
						formatter.setRoundingMode( RoundingMode.DOWN );
						result = formatter.format(ethValue);*/
						result = balance;
					}
				}
				
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String sendCryptoCurrency(String from, String to, String value, String passcode) {
		String transactionAddress = "0x123";
		try {
			URL url = new URL(WEBAPI.BASE + WEBAPI.SENDAMOUNT);
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("POST");
			httpCon.setRequestProperty("Content-Type","application/json");
			OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
			String data = WEBAPI.SENDAMOUNT_DATA.replace("PARAM1", from).replace("PARAM2", to).replace("PARAM3", value /*Long.toHexString(Long.parseLong(value))*/).replace("PARAM4", passcode);
			out.write(data);
			out.close();
		  
			BufferedReader br;
			if (200 <= httpCon.getResponseCode() && httpCon.getResponseCode() <= 299) {
				br = new BufferedReader(new InputStreamReader((httpCon.getInputStream())));
				StringBuilder sb = new StringBuilder();
				String output;
				while ((output = br.readLine()) != null) {
					sb.append(output);
				}
				
				JSONObject json = new JSONObject(sb.toString());
				if (json.has("result"))
					transactionAddress = json.getString("result");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return transactionAddress;
	}
}
