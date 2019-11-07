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
            return "fail!";
        }
        return "success!";
	}

}
