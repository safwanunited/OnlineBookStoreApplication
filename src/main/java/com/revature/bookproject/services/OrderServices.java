package com.revature.bookproject.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.revature.bookproject.model.Books;
import com.revature.bookproject.model.Order;
import com.revature.bookproject.model.OrderDetails;
import com.revature.bookproject.model.User;
import com.revature.bookproject.repository.BookJpaRepository;
import com.revature.bookproject.repository.OrderDetailsJpaRepository;
import com.revature.bookproject.repository.OrderJpaRepository;
import com.revature.bookproject.repository.UserJpaRepository;

@Service
public class OrderServices {
	@Autowired
	private  BookServices services;
	@Autowired
	private  OrderJpaRepository orderJpaRepository;
	@Autowired
	private  OrderDetailsJpaRepository orderDetailsJpaRepository;
	@Autowired
	private  BookJpaRepository bookJpaRepository;
	@Autowired
	private  UserJpaRepository userJpaRepository;
	@Autowired
	JavaMailSender jms; 
	SimpleMailMessage s =new SimpleMailMessage();
	public String insertOrder(Order o)
	{
		orderJpaRepository.save(o);
		return "Ordered taken for "+o.getOrderId();
	}
	/*public String registerOrder(long bid1[],int uid)
	{
		Books[] b=new Books[bid1.length];
		User u=userJpaRepository.findById(uid).orElse(null);
		for(int i=0;i<bid1.length;i++)
		{
			b[i]=bookJpaRepository.findById(bid1[i]).orElse(null);
		}
		Order order=new Order(new Date(),"booked",u);
		Order o=orderJpaRepository.save(order);
		return o.getOrderId()+" is taken";
	}*/
	public int insertOrderBook(List<Long> o,int id)
	{
		int len=o.size();
		long quantity[]=new long[len/2];
		Books[] b=new Books[len/2];
		List<OrderDetails> ol=new ArrayList<OrderDetails>();
		OrderDetails[] ob=new OrderDetails[len/2];
		//Order order=null;
		User u=userJpaRepository.findById(id).orElse(null);
		if(id==0) {
			return 0;
		}
		if(u==null) {
			return 0;
		}
		
		System.out.println("hii");
		int j=0;
		double amnt=0;
		for(int i=0;i<len;i=i+2)
		{
			b[j]=bookJpaRepository.findById(o.get(i)).orElse(null);
			quantity[j]=o.get(i+1);
			amnt+=(b[j].getBookPrice()*quantity[j]);
			j++;
			
		}	
		Order order=new Order(new Date(),"ordered","not paid",amnt,u);
		double p=0.0;
		for(int i=0;i<len/2;i++)
		{
			p=(double)b[i].getBookPrice()*(double)quantity[i];
			ob[i]=new OrderDetails(b[i],order,quantity[i],p);
			ol.add(ob[i]);
			b[i].addOrderDetail(ob[i]);
			orderDetailsJpaRepository.save(ob[i]);
		}
        
		order.addOrderDetail(ol);
		orderJpaRepository.save(order);
		String msg="Dear "+u.getUserName()+","+"\n"+"Thank you for your shopping..."+"\n"+"Your order Id is :"+order.getOrderId()+", \n "+"Amount to be paid :"+amnt+". "+"\n"+"\n\n\n\n\n\n"+" Continue shopping with our app "+"\n"+"Regards,"+"\n"+"THE DREAM TEAM ONLINE BOOK STORE"+"\n"+"A Writer only begins a book, but the Reader Finishes it.....!!!!!";
		s=EmailService.sendEmail(u.getEmail(),"ORDER PLACED",msg);
		jms.send(s);
		
		return order.getOrderId();
	}
	public List<Order>displayOrders(int uid){
        User u=userJpaRepository.findAllById(uid).orElse(null);
        return orderJpaRepository.findByUser(u);
    }
}
