package com.revature.bookproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.revature.bookproject.model.DeliveryMan;
import com.revature.bookproject.model.Order;
import com.revature.bookproject.repository.DeliveryManJpaRepository;
import com.revature.bookproject.repository.OrderJpaRepository;
@Service
public class DeliveryManService {
	@Autowired
	private DeliveryManJpaRepository deliveryManJpaRepository;
	@Autowired
	private  OrderJpaRepository orderJpaRepository;
	@Autowired
	JavaMailSender jms; 
	SimpleMailMessage s =new SimpleMailMessage();
	public Order change(Integer oid)
	{
		 Order existing = orderJpaRepository.findById(oid).orElse(null);
	        existing.setStatus("delivered");
	        existing.setPaidStatus("paid");
	        String msg="Dear "+existing.getUser().getUserName()+","+"\n"+"Thank you for your shopping..."+"\n"+"Hope you Recieved the book "+", \n "+"Your payment is recieved"+". "+"\n"+"\n\n\n\n\n\n"+" Continue shopping with our app "+"\n"+"Regards,"+"\n"+"THE DREAM TEAM ONLINE BOOK STORE"+"\n"+"A Writer only begins a book, but the Reader Finishes it.....!!!!!";
			s=EmailService.sendEmail(existing.getUser().getEmail(),"ORDER DELIVERED",msg);
			jms.send(s);
	        return orderJpaRepository.save(existing);
	}
	public String login(Integer id,String pswd) {
	
		DeliveryMan d=deliveryManJpaRepository.findById(id).orElse(null);
		String apswd=d.getPassword();
		if(pswd.equals(apswd)) {
			return "true";
		}
		else {
			return "false";
		}
	}
	
	public String changePswd(String mailId,int id) {
		
		DeliveryMan d=deliveryManJpaRepository.findById(id).orElse(null);
		d.setPassword(d.getUserName()+"999");
		deliveryManJpaRepository.save(d);
		String msg="Dear "+d.getUserName()+","+"\n"+"Your new Password is : "+d.getPassword()+"\n"+"\n\n\n\n\n\n"+" Continue shopping with our app "+"\n"+"Regards,"+"\n"+"THE DREAM TEAM ONLINE BOOK STORE"+"\n"+"A Writer only begins a book, but the Reader Finishes it.....!!!!!";
		s=EmailService.sendEmail(d.getEmail(),"PASSWORD CHANGE",msg);
		jms.send(s);
		return "success";
	}
}


