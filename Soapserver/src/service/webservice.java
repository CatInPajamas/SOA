package service;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jws.WebMethod;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class webservice {

	
	private static final String ALIDM_SMTP_HOST = "smtpdm.aliyun.com";

    // �����˵��˺� �� ����
    private String user="wolfgang@email.huxiaogang.top";
    private String password="ABcd123456";
	
    private Session loadMailSession() {
        try {
            // ���÷����ʼ��Ļ�������
            final Properties props = new Properties();
            // ��ʾSMTP�����ʼ�����Ҫ���������֤
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", ALIDM_SMTP_HOST);
            // �����˵��˺�
            props.put("mail.user", user);
            // ����SMTP����ʱ��Ҫ�ṩ������
            props.put("mail.password", password);
            // ������Ȩ��Ϣ�����ڽ���SMTP���������֤
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // �û���������
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            // ʹ�û������Ժ���Ȩ��Ϣ�������ʼ��Ự
            return Session.getInstance(props, authenticator);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("mail session is null");
        }
        return null;
    }
    @WebMethod
	public void sendMail(String urls, String subject, String content) {
		Session session = loadMailSession();
        // �����ʼ���Ϣ
        MimeMessage message = new MimeMessage(session);
        try {
            // ���÷�����
            message.setFrom(new InternetAddress(user));
            Address[] a = new Address[1];
            a[0] = new InternetAddress(user);
            message.setReplyTo(a);
            // �����ռ���
            //InternetAddress to = new InternetAddress(toEmail);
            //message.setRecipient(MimeMessage.RecipientType.TO, to);
            String[] toEmails= urls.split(",");
            int n=toEmails.length;
            InternetAddress[] adds = new InternetAddress[n];
            for(int i=0;i<n;i++)
            {
            	adds[i] = new InternetAddress(toEmails[i]);
            }
            message.setRecipients(MimeMessage.RecipientType.TO, adds);


           
            // �����ʼ�����
            message.setSubject(subject);
            // �����ʼ���������
            message.setContent(content, "text/html;charset=UTF-8");
            // �����ʼ�
            Transport.send(message);
        } catch (MessagingException e) {
            String err = e.getMessage();
            // �����ﴦ��message���ݣ� ��ʽ�ǹ̶���
            System.out.println(err);
        }
	}
    
    @WebMethod
	public String validateEmailAddress(String _url) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}");  
	    Matcher m = p.matcher(_url);  
	    boolean b = m.matches();
	    String s=null;
		if(b) {
			s="�ʼ���ַ�Ϸ�";
			
		}else {
			s="�ʼ���ַ���Ϸ�";
		}
		return s;
	}
}
