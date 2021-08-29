package com.revature.bookproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.bookproject.model.Books;
import com.revature.bookproject.model.Email;
import com.revature.bookproject.model.Order;
import com.revature.bookproject.model.User;
import com.revature.bookproject.model.login;
import com.revature.bookproject.services.BookServices;
import com.revature.bookproject.services.DeliveryManService;
import com.revature.bookproject.services.EmployeeService;
import com.revature.bookproject.services.OrderServices;
import com.revature.bookproject.services.UserServices;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/controller")
public class MyController {
	public static int sessionId=0; 
	@Autowired
	private UserServices uservice;
	
	@Autowired
	private OrderServices oservice;
	
	@Autowired
	private EmployeeService eservice;
	
	@Autowired
	private DeliveryManService dservice;
	
	
	@Autowired
	private  BookServices services;
	@Autowired
	private  DeliveryManService dservices;
	
	@GetMapping(value="/displayAll")
	public List<Books> display(){
		return services.displayBooks();
		
	}
	@GetMapping(value="/orderdetails")
    public List<Order> displayOrder(){
        return oservice.displayOrders(sessionId);
       
    }
	
	@GetMapping(value="/displayPat/{pattern}")
	public List<Books> displayByPattern(@PathVariable String pattern){
		System.out.println(pattern);
		return services.displayBooksPattern(pattern);
		
	}
	
	
	@GetMapping(value="/displayAsc")
	public List<Books> displayInAplbhetical(){
		return services.sortBooks();
		
	}
	
	@GetMapping(value="/books/bname/{name}")
	public Books displayName(@PathVariable String name){
		return services.displayBookByName(name);                 //bookJpaRepository.findByName(b.getBookName())
		
	}
	

	@GetMapping(value="/displayGenre/{genre}")
	public List<Books> displayNameByGenre(@PathVariable String genre){
		return services.displayBooksByGenre(genre);                 //bookJpaRepository.findByName(b.getBookName())
		
	}
	
	@PostMapping(value="/insert")
	public String insertBook(@RequestBody Books b){
		return services.saveBook(b);
		
	}

	@GetMapping(value="/books/{id}")
	public Books showId(@PathVariable(value="id") Long id){
		return services.displayBookById(id);                
		
	}
	
	@GetMapping(value="/books/author/{name}")
	public List<Books> displayBookName(@PathVariable String name){
		
		return services.displayBooksByAuthorName(name);//bookJpaRepository.findByName(b.getBookName())
		
	}
	
	@GetMapping(value="/books/from/{range}")
	public List<Books> displayBookRange(@PathVariable(value="range") int range){
		
		return services.displayBooksByRange(range);//bookJpaRepository.findByName(b.getBookName())
		
	}

	
	@PutMapping(value="/stock/{id}/{quantity}")
	public Books updateStockDec(@PathVariable(value="id") Long id,@PathVariable(value="quantity") int quantity)
	{
		return services.reduceStock(id,quantity);
	}
	@PutMapping(value="/add/stock/{id}/{quantity}")
	public Books updateStockInc(@PathVariable(value="id") Long id,@PathVariable(value="quantity") int quantity)
	{
		return services.addStock(id,quantity);
	}
	
	@PutMapping(value="/delivery/{id}")
	public Order updateStockDec(@PathVariable(value="id") Integer id)
	{
		return dservices.change(id);
	}
	
	@DeleteMapping(value="books/delete/{id}")
	public String deleteBook(@PathVariable Long id)
	{
		 return services.deleteBookById(id);
		
	}
	
	
	@PostMapping(value="/register")
	public String insertUser(@RequestBody User u){
		return uservice.addUser(u);
		
	}
	@PostMapping(value="/addingOrder")
	public int takeOrder(@RequestBody List<Long> ab){
		System.out.println(ab);
		int count=1;
		List<Long> b=new ArrayList<Long>();
		for(int i=0;i<ab.size();i++) {
			for(int j=i+1;j<ab.size();j++) {
				if(ab.get(i)==ab.get(j) ) {
					count++;
					ab.remove(j);
				}
			}
			  b.add(ab.get(i));
			  b.add((long) count); 
			  count=1;	
		   }
		System.out.println(b);
		
		return oservice.insertOrderBook(b,sessionId);
		
	}
	@PostMapping("/login")
	public String checkLogin(@RequestBody login l) 
	{
		sessionId=l.getId();
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
	public String changePassword(@RequestBody Email e) 
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
	@GetMapping("/logout")
	public void logout() 
	{
		sessionId=0;
	}
	

	
}
