package com.aequalis.scintilla;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aequalis.blockchainapi.WebAPICall;
import com.aequalis.model.Transaction;
import com.aequalis.model.Type;
import com.aequalis.model.User;
import com.aequalis.service.TransactionService;
import com.aequalis.service.TypeService;
import com.aequalis.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	TypeService typeService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired(required = true)
	public HttpServletRequest request;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registrationScreen(Model model) {
		List<Type> types = typeService.findAllType();
		model.addAttribute("types", types);
	    return "registration";
	}
	
	
	@RequestMapping(value = "/sendCurreny", method = RequestMethod.POST)
	public ModelAndView sendCurreny(Model model, HttpServletRequest httpServletRequest) {

		HttpSession session = getSession();
		Object userId = session.getAttribute("loginUser");
		
		if(userId != null) {
			String userid = httpServletRequest.getParameter("userid");
			String amount = httpServletRequest.getParameter("amount");
			String toaddress = httpServletRequest.getParameter("toaddress");
			String description = httpServletRequest.getParameter("description");
			User user = userService.findByUserid(Long.parseLong(userid));
			Transaction transaction = new Transaction();
			transaction.setUser(user);
			transaction.setCutomeraddress(toaddress);
			transaction.setTransactionamount(amount);
			transaction.setTransactiondate(new Date());
			transaction.setTransactiondescription(description);
			transaction.setTransactionaddress(WebAPICall.sendCryptoCurrency(user.getBcaddress(), toaddress, amount, user.getPassword()));
			transactionService.addTransaction(transaction);
			
			return new ModelAndView("redirect:/shop");	
		}
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(Model model, HttpServletRequest httpServletRequest) {
		
		String typeid = httpServletRequest.getParameter("userType");
		String userName = httpServletRequest.getParameter("userName");
		String password = httpServletRequest.getParameter("password");
		//String confirmPassword = httpServletRequest.getParameter("confirmPassword");
		String fullName = httpServletRequest.getParameter("fullName");
		String address = httpServletRequest.getParameter("address");
		String contactNumber = httpServletRequest.getParameter("contactNumber");
		String email = httpServletRequest.getParameter("email");
		String website = httpServletRequest.getParameter("website");
		
		
		User availableUser = userService.findByUsername(userName);
		if (availableUser == null) {
			User user = new User();
			user.setUsername(userName);
			user.setPassword(password);
			user.setFullname(fullName);
			user.setAddress(address);
			user.setContactnumber(contactNumber);
			user.setEmail(email);
			user.setWebsite(website);
			Type type = typeService.findByTypeid(Long.parseLong(typeid));
			user.setType(type);
			String bcAddress = WebAPICall.registerNewUser(password);
			user.setBcaddress(bcAddress);
			userService.addUser(user);
			List<Type> types = typeService.findAllType();
			model.addAttribute("types", types);
			model.addAttribute("registered", "You have successfully registered...!");
		} else {
			List<Type> types = typeService.findAllType();
			model.addAttribute("types", types);
			model.addAttribute("registered", "Username is not available, Please try again!");
		}
		
		return "registration";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginScreen(Model model) {
	    return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutScreen(Model model) {
		HttpSession session = getSession();
		session.removeAttribute("loginUser");
	    return "home";
	}
	
	public HttpSession getSession() {
		if (request != null) {
			return request.getSession();
		}
		return null;
	}
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public ModelAndView loginUser(Model model, HttpServletRequest httpServletRequest) {
		Date loginTime = new Date();
		String userName = httpServletRequest.getParameter("userName");
		String password = httpServletRequest.getParameter("password");
		
		User user = userService.loginUser(userName, password);
		if (user != null) {
			
			if (user.getUnlocked() == null || !user.getUnlocked()) {
				Boolean status = WebAPICall.unlockUser(user.getBcaddress(), password);
				user.setUnlocked(status);
			}
			user.setLastLogin(user.getCurrentLogin());
			user.setCurrentLogin(loginTime);
			userService.addUser(user);

			HttpSession session = getSession();
			session.setAttribute("loginUser", user.getUserid());
			
			return new ModelAndView("redirect:/shop");
		} 
		
		model.addAttribute("errormsg", "Invalid user name or password. Please try again.");
		return new ModelAndView("redirect:/login");	
		
	}
	
	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String transactionListScreen(Model model) {
	    
		HttpSession session = getSession();
		Object userId = session.getAttribute("loginUser");
		
		if(userId != null) {
			User user = userService.findByUserid(Long.parseLong(userId.toString()));
			user.setBalance(WebAPICall.getBalance(user.getBcaddress()));
			List<Transaction> transactions = transactionService.findByUser(user);
			model.addAttribute("myTransactions", transactions);
			model.addAttribute("currentUser", user);
			return "shop";
		}
		
		return "login";
	}
}
