package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	private static final String from = "phpmaster.dungken.dev@gmail.com";
	private static final String password = "rvez ukqp qcsq ceef";

	public static boolean sendMail(String to, String subject, String content) {
		// Properties: declare attributes
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
		props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		// Create authentication
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		};

		// Create session
		Session session = Session.getInstance(props, auth);

		// Create message
		MimeMessage msg = new MimeMessage(session);

		try {
			// Create content type
			msg.setHeader("Content-type", "text/HTML; charset=UTF-8");

			// Sender
			msg.setFrom(from);

			// Receiver
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

			// Subject mail
			msg.setSubject(subject);

			// Specify the sending date
			msg.setSentDate(new Date());

			// Rules for receiving email responses
			// msg.setReplyTo(InternetAddress.parse(from, false));

			// Content
			msg.setContent(content, "text/HTML; charset=UTF-8");

			// Sent Mail
			Transport.send(msg);
			System.out.println("Gửi email thành công");
			return true;

		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("Gửi email không thành công");
			return false;
		}

	}

	public static void main(String[] args) {
		String to = "brave2112love@gmail.com";
		String subject = "Test send mail with JSP/Servlet Java";
		String content = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<body>\r\n" + "\r\n" + "<h1>My First Heading</h1>\r\n"
				+ "<p>My first paragraph.</p>\r\n" + "\r\n" + "</body>\r\n" + "</html>";
		for (int i = 0; i < 5; i++) {
			sendMail(to, subject, content);
		}
	}
}
