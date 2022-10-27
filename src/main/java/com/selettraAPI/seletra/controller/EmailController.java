/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.selettraAPI.seletra.controller;

/**
 *
 * @author amilt
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EmailController {
	@Autowired 
        private JavaMailSender javaMailSender;
	
        @CrossOrigin
        @PostMapping({"/enviaremail"})
	void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("amiltongomes2301@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }
    
}
