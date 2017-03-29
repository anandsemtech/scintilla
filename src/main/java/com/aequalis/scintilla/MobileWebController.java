/**
 * 
 */
package com.aequalis.scintilla;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aequalis.blockchainapi.WebAPICall;
import com.aequalis.dto.UserDTO;
import com.aequalis.model.QRCode;
import com.aequalis.model.Transaction;
import com.aequalis.model.Type;
import com.aequalis.model.User;
import com.aequalis.service.QRCodeService;
import com.aequalis.service.TransactionService;
import com.aequalis.service.TypeService;
import com.aequalis.service.UserService;

/**
 * @author leoanbarasanm
 *
 */
@RestController
@RequestMapping(value = "/mobile/restApi")
public class MobileWebController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	TypeService typeService;
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	QRCodeService qrCodeService;

	@RequestMapping(value = "user/registeration", method = RequestMethod.POST)
	public String registerationDevice(@RequestBody UserDTO user) {
		JSONObject json = new JSONObject();
		User availableUser = userService.findByUsername(user.getUsername());
		if (availableUser == null) {
			User newUser = new User();
			newUser.setUsername(user.getUsername());
			newUser.setPassword(user.getPassword());
			newUser.setFullname(user.getFullname());
			newUser.setAddress(user.getAddress());
			newUser.setContactnumber(user.getContactnumber());
			newUser.setEmail(user.getEmail());
			newUser.setWebsite(user.getWebsite());
			Type type = typeService.findByName(user.getType());
			if (type == null) {
				json.put("result", false);
				json.put("msg", "Type is not found, Please provide valid type name!");
				return json.toString();
			}
			newUser.setType(type);
			String bcAddress = WebAPICall.registerNewUser(user.getPassword());
			newUser.setBcaddress(bcAddress);
			userService.addUser(newUser);
			
			byte[] qrCode = QRCodeProcessor.generateQRCode(bcAddress);
			QRCode code = new QRCode();
			code.setUser(userService.findByUsername(user.getUsername()));
			code.setCode(qrCode);
			qrCodeService.addQRCode(code);
			
			json.put("result", true);
			json.put("msg", "You have successfully registered...!");
		} else {
			json.put("result", false);
			json.put("msg", "Username is not available, Please try again!");
		}
		return json.toString();
	}
	
	@RequestMapping(value = "user/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		JSONObject json = new JSONObject();
		Date loginTime = new Date();
		User user = userService.loginUser(username, password);
		if (user != null) {
			
			/*if (user.getUnlocked() == null || !user.getUnlocked()) {
				Boolean status = WebAPICall.unlockUser(user.getBcaddress(), password);
				user.setUnlocked(status);
			}*/
			user.setLastLogin(user.getCurrentLogin());
			user.setCurrentLogin(loginTime);
			userService.addUser(user);
			json.put("result", true);
			json.put("msg", "Login successful...!");
			json.put("userid", user.getUserid());
			json.put("balance", WebAPICall.getCustomerBalance(user.getBcaddress()));
			json.put("bcaddress", user.getBcaddress());
			json.put("fullname", user.getFullname());
			json.put("lastlogin", user.getLastLogin());
		} else {
			json.put("result", false);
			json.put("msg", "Invalid user name or password. Please try again.");
		}
		
		return json.toString();
	}
	
	@RequestMapping(value = "user/sendcurrency", method = RequestMethod.POST)
	public String sendCurrency(@RequestParam("userid") Long userid, @RequestParam("toaddress") String toaddress, @RequestParam("amount") String amount, @RequestParam("description") String description) {
		JSONObject json = new JSONObject();
		
		User user = userService.findByUserid(userid);
		Transaction transaction = new Transaction();
		transaction.setUser(user);
		transaction.setCutomeraddress(toaddress);
		transaction.setTransactionamount(amount);
		transaction.setTransactiondate(new Date());
		transaction.setTransactiondescription(description);
		String transactionAddress = WebAPICall.payToStore(user.getBcaddress(), toaddress, amount);
		if (!transactionAddress.equals("0x123")) {
			transaction.setTransactionaddress(transactionAddress);
			transactionService.addTransaction(transaction);
			
			json.put("result", true);
			json.put("msg", "Transaction successful...!");
		} else {
			json.put("result", false);
			json.put("msg", "Transaction failed, Please try again...!");
		}
		
		
		return json.toString();
	}
	
	@RequestMapping(value = "user/mytransactions", method = RequestMethod.GET)
	public String login(@RequestParam("userid") Long userid) {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		User user = userService.findByUserid(userid);
		List<Transaction> transactions = transactionService.findByUser(user);
		for (Transaction transaction : transactions) {
			JSONObject transactionObject = new JSONObject();
			transactionObject.put("id", transaction.getTransactionid());
			transactionObject.put("date", transaction.getTransactiondate());
			transactionObject.put("cutomeraddress", transaction.getCutomeraddress());
			transactionObject.put("amount", transaction.getTransactionamount());
			transactionObject.put("description", transaction.getTransactiondescription());
			jsonArray.put(transactionObject);
		}
		if (jsonArray.length() > 0) {
			jsonObject.put("result", true);
			jsonObject.put("transactions", jsonArray);
		} else {
			jsonObject.put("result", false);
			jsonObject.put("msg", "No transactions...!");
		}
		
		return jsonObject.toString();
	}
	
	@RequestMapping(value = "user/qrcode", method = RequestMethod.GET)
	public String getQRCode(@RequestParam("userid") Long userid) {
		JSONObject json = new JSONObject();
		User user = userService.findByUserid(userid);
		if (user != null) {
			QRCode qrCode = qrCodeService.findByUser(user);
			if (qrCode != null) {
				json.put("result", true);
				StringBuilder sb = new StringBuilder();
				sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(qrCode.getCode(), false)));
				json.put("qrcode", sb.toString());
			} else {
				json.put("result", false);
				json.put("msg", "QRCode is not available...!");
			}
		} else {
			json.put("result", false);
			json.put("msg", "User is not available...!");
		}
		
		return json.toString();
	}
}
