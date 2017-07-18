package com.pad.base.common.tools;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

/**
 * 邮件发送工具
 * @author myl
 *
 */
public class SendMail {
	
	private static final Logger logger = Logger.getLogger(SendMail.class);
	
//	public static void main(String[] args) {
//		String to = "mo.yalan@segopet.com";
//		String copyto = "790171163@qq.com";
//		String bcc = "shaymoo@163.com";
//		String subject = "您 好我晕，你最美！";
//		String content = "哈哈，美丽的宝宝你好！";
//		SendMail.sendMail(to, copyto, bcc, subject, content);
//	}

    // 若开启独立密码（或授权码）,密码则使用独立密码（授权码）
    public static String sender = "1473605922@qq.com";
    public static String senderPassword = "pzyczkzvdsfpifae";

    // 发件人邮箱的 SMTP 服务器地址
    public static String mailHost = "smtp.qq.com";
    
    // smtp端口（开启SSL时）
    public static final String smtpPort_QQ = "465";
    
    // 收件人、抄送人、密送人
    private static Address[] receivers;
    private static Address[] copys;
    private static Address[] bccs;

    public static boolean sendMail(String to,String copyto,String bcc,String subject, String content) {
        // 配置用于连接邮件服务器的参数
        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", mailHost);   		// 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证

        // 开启SMTP的SSL, 需设置端口 (QQ:465或587)
        props.setProperty("mail.smtp.port", smtpPort_QQ);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort_QQ);
        
        logger.info("创建会话对象...");
        Session session = Session.getDefaultInstance(props);
        // 设置为debug模式, 可以查看详细的发送 log，生产过程中一般不设置
        session.setDebug(true);                                 

        boolean flag = false;
        try {
        	
        	logger.info("创建邮件对象...");
        	
        	// 设置收件人、抄送人、密送人
        	setReceivers(to);
        	setCopytos(copyto);
        	setBccs(bcc);
        	
	        MimeMessage message = createMimeMessage(session, subject, content);
	
	        logger.info("获取邮件传输对象...");
	        Transport transport = session.getTransport();
	
	        logger.info("创建邮件服务器连接...");
	        transport.connect(sender, senderPassword);
	
	        logger.info("正在发送邮件...");
	        transport.sendMessage(message, message.getAllRecipients());
	        // 7. 关闭连接
	        transport.close();
	        // 确认发送成功！
	        flag = true;
	        logger.info("邮件发送成功...");
        } catch (Exception e) {
        	logger.info("邮件发送异常" + e.getMessage());
        }
        return flag;
    }

    /**
     * 创建一封只包含文本的简单邮件
     *
     * @param session 和服务器交互的会话
     * @param sendMail 发件人邮箱
     * @param receiveMail 收件人邮箱
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session,String subject,String content) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人
        message.setFrom(new InternetAddress(sender, "莫莫", "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人 TO、抄送 CC、密送 BCC）
        if(receivers != null) {
        	message.setRecipients(MimeMessage.RecipientType.TO, receivers);
        }
        if(copys != null) {
        	message.setRecipients(MimeMessage.RecipientType.CC, copys);
        }
        if(bccs != null) {
        	message.setRecipients(MimeMessage.RecipientType.BCC, bccs);
        }

        // 4. Subject: 邮件主题
        message.setSubject(subject, "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent(content, "text/html;charset=UTF-8");

        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }
    
    /**
     * 设置收件人
     * @param to
     * @throws UnsupportedEncodingException
     */
    public static void setReceivers(String to) throws UnsupportedEncodingException {
    	if(StringHelper.isNotNull(to)) {
    		String[] str = to.split(",");
    		receivers = new InternetAddress[str.length];
    		for(int i = 0;i < str.length;i++) {
    			receivers[i] = new InternetAddress(str[i],"收件人","UTF-8");
    		}
    		
    	}
    }
    
    /**
     * 设置抄送人
     * @param copyto
     * @throws UnsupportedEncodingException
     */
    public static void setCopytos(String copyto) throws UnsupportedEncodingException{
    	if(StringHelper.isNotNull(copyto)) {
    		String[] str = copyto.split(",");
    		copys = new InternetAddress[str.length];
    		for(int i = 0;i < str.length;i++) {
    			copys[i] = new InternetAddress(str[i],"抄送人","UTF-8");
    		}
    	}
    }
    
    /**
     * 设置密送人
     * @param bcc
     * @throws UnsupportedEncodingException
     */
    public static void setBccs(String bcc) throws UnsupportedEncodingException{
    	if(StringHelper.isNotNull(bcc)) {
    		String[] str = bcc.split(",");
    		bccs = new InternetAddress[str.length];
    		for(int i = 0;i < str.length;i++) {
    			bccs[i] = new InternetAddress(str[i],"密送人","UTF-8");
    		}
    	}
    }

}