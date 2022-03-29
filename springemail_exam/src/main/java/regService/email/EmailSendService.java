package regService.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailSendService {

	private JavaMailSenderImpl mailSender;
	private int size;
	
	public EmailSendService(){
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", true);

		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.starttls.required", true);
		properties.put("mail.debug", true);
		
		mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("aswll.kr@gmail.com"); //이메일 주소
		mailSender.setPassword("****"); //이메일 비밀번호
		mailSender.setDefaultEncoding("utf-8");
		mailSender.setJavaMailProperties(properties);
		
		//System.out.println("EmailConfiguration : " + mailSender);
		
	}

	// 인증키 생성
	private String getKey(int size) {
		this.size = size;
		return getAuthCode();
	}

	// 인증 난수 생성
	private String getAuthCode() {
		// TODO Auto-generated method stub
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		int num = 0;

		while (buffer.length() < size) {
			num = random.nextInt(10);
			buffer.append(num);

		}

		return buffer.toString();
	}

	// 인증 메일 보내기
	public String sendAuthMail(String email) {
		System.out.println("mailSender : " +mailSender);
		// 난수
		String auth = getKey(6);

		// 인증메일 보내기

		try {

			MailUtils sendMail = new MailUtils(mailSender);
			System.out.println(mailSender.getHost());
			sendMail.setSubject("회원가입 이메일 인증");
			sendMail.setText(new StringBuffer().append("<h1>[이메일 인증]</h1>").append("<p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>")
					.append("<a href='http://localhost:8080/springemail_exam/member/signUpConfirm?email=").append(email)
					.append("&auth=").append(auth).append("' target='_blank'>이메일 인증 확인</a>").toString());
			sendMail.setFrom("aswll.kr@gmail.com", "관리자");
			sendMail.setTo(email);
			sendMail.send();

		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return auth;
	}
	
	
	// 임시 비밀번호 메일 보내기
	public String sendPwdMail(String email) {

		// 난수
		String auth = getKey(6);

		// 인증메일 보내기

		try {

			MailUtils sendMail = new MailUtils(mailSender);
			System.out.println(mailSender.getHost());
			sendMail.setSubject("임시 비밀번호 발급");
			sendMail.setText(new StringBuffer().append("<h1>[임시 비밀번호]</h1>").append("<p>임시 비밀번호 : </p>")
						.append(auth).toString());
			sendMail.setFrom("aswll.kr@gmail.com", "관리자");
			sendMail.setTo(email);
			sendMail.send();

		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return auth;
	}

}
