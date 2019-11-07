package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Path("/webservice")
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
     
    @GET
    @Path("/validateEmailAddress")
    @Produces(MediaType.TEXT_PLAIN)
	public String validateEmailAddress(@QueryParam("url")String url) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}");  
	    Matcher m = p.matcher(url);  
	    boolean b = m.matches();
	    String s=null;
		if(b) {
			s="Legal email address";
			
		}else {
			s="Illegal email address";
		}
		return s;
	}
    
    @javax.ws.rs.POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String sendMail(@FormParam("urls")String urls, @FormParam("subject")String subject, @FormParam("content")String content) {
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
            return "fail!";
        }
        return "success!";
	}

}
