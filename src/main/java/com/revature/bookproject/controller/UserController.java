package com.revature.bookproject.controller;

/*import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.bookproject.model.Email;
import com.revature.bookproject.model.Order;
import com.revature.bookproject.model.OrderedBook;
import com.revature.bookproject.model.User;
import com.revature.bookproject.model.login;
import com.revature.bookproject.model.status;
import com.revature.bookproject.services.DeliveryManService;
import com.revature.bookproject.services.EmployeeService;
import com.revature.bookproject.services.OrderServices;
import com.revature.bookproject.services.UserServices;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ucontroller")
public class UserController {
	@Autowired
	private UserServices uservice;
	
	@Autowired
	private OrderServices oservice;
	
	@Autowired
	private EmployeeService eservice;
	
	@Autowired
	private DeliveryManService dservice;
	@PostMapping(value="/register")
	public String insertUser(@RequestBody User u){
		return uservice.addUser(u);
		
	}
	@PostMapping(value="/addingOrder")
	public int takeOrder(@RequestBody OrderedBook ob){
		int count=0;
		List<Integer> b=new ArrayList<Integer>();
		for(int i=0;i<ob.getBookid().size();i++) {
			
		}
		
		
		
		return oservice.insertOrderBook(ob);
		
	}
	@PostMapping(value="/addOrder")
	public String takeOrders(@RequestBody Order o){
		
		return oservice.insertOrder(o);
		
	}
	@PostMapping(value="/addOrders")
	public String takeOrders1(long[] bid1,int uid){
		return null;
		
		//return oservice.registerOrder(bid1,uid);	
	}
	@PostMapping("/login")
	public status checkLogin(@RequestBody login l) 
	{
		if(l.getRole().equals("employee")) {
			return eservice.login(l.getId(),l.getPswd());
		}
		else if(l.getRole().equals("user")) {
		    return uservice.login(l.getId(),l.getPswd());
	    }
		else if(l.getRole().equals("deliveryman")) {
			return dservice.login(l.getId(),l.getPswd());
		}
		return null;
	}
	
	@PutMapping("/changePassword")
	public status changePassword(@RequestBody Email e) 
	{
		if(e.getRole().equals("employee")) {
			return eservice.changePswd(e.getEmailId(),e.getId());
		}
		else if(e.getRole().equals("user")) {
		    return uservice.changePswd(e.getEmailId(),e.getId());
	    }
		else if(e.getRole().equals("deliveryman")) {
			return dservice.changePswd(e.getEmailId(),e.getId());
		}
		return null;
	}
}*/
