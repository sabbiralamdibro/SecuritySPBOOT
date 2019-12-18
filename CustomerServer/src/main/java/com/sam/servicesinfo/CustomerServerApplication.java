package com.sam.servicesinfo;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.sam.servicesinfo.domain.User;
import com.sam.servicesinfo.domain.security.Role;
import com.sam.servicesinfo.domain.security.UserRole;
import com.sam.servicesinfo.service.UserService;
import com.sam.servicesinfo.utility.SecurityUtility;

@SpringBootApplication
public class CustomerServerApplication  implements CommandLineRunner {

	// implements CommandLineRunner 
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerServerApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setFirstName("a");
		user1.setLastName("a");
		user1.setUsername("a");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("a"));
		user1.setEmail("sabbir.mojumder@zaberp.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1= new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
	}
	
//	@Bean
//	public JavaMailSender getJavaMailSender() {
//	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//	    mailSender.setHost("smtp.gmail.com");
//	    mailSender.setPort(587);
//	      
//	    mailSender.setUsername("my.gmail@gmail.com");
//	    mailSender.setPassword("password");
//	      
//	    Properties props = mailSender.getJavaMailProperties();
//	    props.put("mail.transport.protocol", "smtp");
//	    props.put("mail.smtp.auth", "true");
//	    props.put("mail.smtp.starttls.enable", "true");
//	    props.put("mail.debug", "true");
//	      
//	    return mailSender;
//	}
	
//	@Bean
//	public JavaMailSender getJavaMailSender() {
//	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//	    mailSender.setHost("smtp.gmail.com");
//	    mailSender.setPort(587);
//	      
//	    mailSender.setUsername("sabbiralamdibro@gmail.com");
//	    mailSender.setPassword("sam84742@@@1178");
//	      
//	    Properties props = mailSender.getJavaMailProperties();
//	    props.put("mail.transport.protocol", "smtp");
//	    props.put("mail.smtp.auth", "true");
//	    props.put("mail.smtp.starttls.enable", "true");
//	    props.put("mail.debug", "true");
//	      
//	    return mailSender;
//	}	

}
