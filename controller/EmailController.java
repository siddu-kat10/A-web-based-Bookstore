package com.online.book.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online.book.store.service.EmailService;

import jakarta.mail.MessagingException;

@CrossOrigin(origins = "*")
@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;

	// This method serves the email page
    @GetMapping("/email")
    public String showEmailPage() {
        return "email"; // This will return the email.html page
    }


	@PostMapping("/emailsend")
	public String sendEmail(@RequestParam("to") String to, @RequestParam("subject") String subject,
			@RequestParam("body") String body) {
		try {
			System.out.println("To: " + to);
			System.out.println("Subject: " + subject);
			System.out.println("Body: " + body);

			emailService.sendEmail(to, subject, body);
			return "Email sent successfully!";
		} catch (MessagingException e) {
			return "Error while sending email: " + e.getMessage();
		}
	}
}
