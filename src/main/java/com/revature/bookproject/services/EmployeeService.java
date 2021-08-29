package com.revature.bookproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.revature.bookproject.model.Employee;

import com.revature.bookproject.repository.EmployeeJpaRepository;

@Service
public class EmployeeService {

	@Autowired
	JavaMailSender jms; 
	SimpleMailMessage s =new SimpleMailMessage();
	@Autowired
	private  EmployeeJpaRepository employeeJpaRepository;
	
	public String login(Integer id,String pswd) {
		
		Employee e=employeeJpaRepository.findById(id).orElse(null);
		String apswd=e.getPassword();
		if(pswd.equals(apswd)) {
			return "true";
		}
		else {
			return "false";
		}
	}
	
	public String changePswd(String mailId,int id) {
		
		Employee d=employeeJpaRepository.findById(id).orElse(null);
		d.setPassword(d.getName()+"999");
		employeeJpaRepository.save(d);
		String msg="Dear "+d.getName()+","+"\n"+"Your new Password is : "+d.getPassword()+"\n"+"\n\n\n\n\n\n"+" Continue shopping with our app "+"\n"+"Regards,"+"\n"+"THE DREAM TEAM ONLINE BOOK STORE"+"\n"+"A Writer only begins a book, but the Reader Finishes it.....!!!!!";
		s=EmailService.sendEmail(d.getEmail(),"PASSWORD CHANGE",msg);
		jms.send(s);
		
		return "success";
	}
	
	
}
