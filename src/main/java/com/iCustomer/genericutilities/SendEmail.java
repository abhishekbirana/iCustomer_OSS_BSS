package com.iCustomer.genericutilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * This class consists how to send mail.
 * @author abhishek.birana
 */
public class SendEmail {

	public void sendingEmail(String to, String cc, String body, String subject) throws IOException {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.office365.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.socketFactory.port", "587");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("cats4u@in2ittech.com", "Support@202022");
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("cats4u@in2ittech.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
			message.setSubject(subject);

			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(body, "text/html");

			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);

			MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			attachmentBodyPart.attachFile(new File(".\\test-output\\emailable-report.html"));
			multipart.addBodyPart(attachmentBodyPart);
			
			MimeBodyPart attachmentBodyPart2 = new MimeBodyPart();
			attachmentBodyPart2.attachFile(new File(".\\ExtentReports\\"+Container.webMap.get("REPORT_NAME")));
			multipart.addBodyPart(attachmentBodyPart2);
			
			message.setContent(multipart);
			
			
			Transport.send(message);

			System.out.println(" =====> Mail successfully sent.. <===== ");
			
			

		} catch (MessagingException e) {
			System.out.println("MessagingException: " + e);
			e.printStackTrace();
		}
	}
	
	
	
	public void deleteDirectory(String directoryPath) throws IOException {
        Path path = Paths.get(directoryPath);
        if (!Files.exists(path) || !Files.isDirectory(path) || !Files.list(path).findFirst().isPresent()) {
            System.out.println("Directory is empty. No deletion necessary.");
            return;
        }
        Files.walk(path)
             .sorted((p1, p2) -> -p1.compareTo(p2)) // Reverse order to delete files first
             .forEach(p -> {
                 try {
                     Files.delete(p);
                 } catch (IOException e) {
                     System.err.println("Failed to delete: " + p);
                     e.printStackTrace();
                 }
             });
    }

}
