package com.revature.bookproject.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.revature.bookproject.model.User;

import com.revature.bookproject.repository.UserJpaRepository;

@Service
public class UserServices {
	@Autowired 
private  UserJpaRepository userJpaRepository;
	@Autowired
	JavaMailSender jms; 
	SimpleMailMessage s =new SimpleMailMessage();	
	
	/*public String saveBook(Books b)
	{
		bookJpaRepository.save(b);
		return "Inserted"+b.getBookName();
	}

	
	public List<Books> displayBooks()
	{
		return bookJpaRepository.findAll();
	}
	
	public Books displayBookByName(String name)
	{
		return bookJpaRepository.findByBookName(name);
	}

	
	public List<Books> displayBooksByAuthorName(String author)
	{
	   List<Books> list=  bookJpaRepository.findAllByAuthorName(author);  
	   return list;
	}
	
	public Books displayBookById(Long id)
	{
		return bookJpaRepository.findById(id).orElse(null);
		
	}
	
	public Books reduceStock(Long id,int quantity)
	{
		//Books book=displayBookById(id);
		 Books existingProduct = bookJpaRepository.findById(id).orElse(null);
	        existingProduct.setStock( existingProduct.getStock()-quantity);
	       
	        return bookJpaRepository.save(existingProduct);
	}*/
	public String addUser(User u)
	{
		userJpaRepository.save(u);
		return "Hi "+u.getUserName() +" ,you have been registered in our book store successfully";
	}
	public String login(Integer id,String pswd) {
		
		User u=userJpaRepository.findById(id).orElse(null);
		String apswd=u.getPassword();
		if(pswd.equals(apswd)) {
			return "true";
		}
		else {
			return "false";
		}
	}
	public String changePswd(String mailId,int id) {
	
		User d=userJpaRepository.findById(id).orElse(null);
		d.setPassword(d.getUserName()+"999");
		userJpaRepository.save(d);
		String msg="Dear "+d.getUserName()+","+"\n"+"Your new Password is : "+d.getPassword()+"\n"+"\n\n\n\n\n\n"+" Continue shopping with our app "+"\n"+"Regards,"+"\n"+"THE DREAM TEAM ONLINE BOOK STORE"+"\n"+"A Writer only begins a book, but the Reader Finishes it.....!!!!!";
		s=EmailService.sendEmail(d.getEmail(),"PASSWORD CHANGE",msg);
		jms.send(s);
		
		return "success";
	}
	/*public String deleteBookById(Long id)-----> if stock goes to zero 
	{
		 bookJpaRepository.deleteById(id);
		 return "Book id"+id+" is removed";
	}*/
	

}
