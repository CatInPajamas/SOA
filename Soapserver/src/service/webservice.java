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

    // 发件人的账号 和 密码
    private String user="wolfgang@email.huxiaogang.top";
    private String password="ABcd123456";
	
    private Session loadMailSession() {
        try {
            // 配置发送邮件的环境属性
            final Properties props = new Properties();
            // 表示SMTP发送邮件，需要进行身份验证
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", ALIDM_SMTP_HOST);
            // 发件人的账号
            props.put("mail.user", user);
            // 访问SMTP服务时需要提供的密码
            props.put("mail.password", password);
            // 构建授权信息，用于进行SMTP进行身份验证
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            // 使用环境属性和授权信息，创建邮件会话
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
        // 创建邮件消息
        MimeMessage message = new MimeMessage(session);
        try {
            // 设置发件人
            message.setFrom(new InternetAddress(user));
            Address[] a = new Address[1];
            a[0] = new InternetAddress(user);
            message.setReplyTo(a);
            // 设置收件人
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


           
            // 设置邮件标题
            message.setSubject(subject);
            // 设置邮件的内容体
            message.setContent(content, "text/html;charset=UTF-8");
            // 发送邮件
            Transport.send(message);
        } catch (MessagingException e) {
            String err = e.getMessage();
            // 在这里处理message内容， 格式是固定的
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
			s="邮件地址合法";
			
		}else {
			s="邮件地址不合法";
		}
		return s;
	}
}
