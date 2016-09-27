package com.yuwei.adsense.util;

import com.yuwei.adsense.common.Global;
import com.yuwei.adsense.core.UserUtils;
import com.yuwei.adsense.core.entity.User;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;


/**
 * 发送邮件工具类
 *
 * @author huangf
 */
public class MailUtil {
    private static final Logger logger = Logger.getLogger(MailUtil.class);
    private static final MailUtil instance = new MailUtil();

    private MailUtil() {

    }

    public static MailUtil getInstance() {
        return instance;
    }

    // 开始发送信件的方法
    public boolean startSend(String to, String emailTitle, String emailContent) {
        if (StringUtils.isBlank(emailContent)) {
            logger.error("邮件内容不能为空！");
            return false;
        }

        String from = Global.getStringVal("mail.account");
        String password = Global.getStringVal("mail.password");
        String smtpServer = Global.getStringVal("mail.smtp.server");
        try {
            if (StringUtils.isBlank(emailContent)) {
                throw new NullPointerException("发送的内容不能为空！");
            }
            // 创建Properties对象
            Properties props = System.getProperties();
            // 创建信件服务器
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", smtpServer);
            props.put("mail.smtp.password", "0");
            // 得到默认的对话对象
            Session session = Session.getInstance(props, new PopupAuthenticator(from, password));

            // 创建一个消息，并初始化该消息的各项元素
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(emailTitle);

            // 后面的BodyPart将加入到此处创建的Multipart中
            Multipart mp = new MimeMultipart("subtype");

            //添加HTML正文
            BodyPart htmlBody = new MimeBodyPart();
            MimeMultipart htmlContent = new MimeMultipart("related");
            BodyPart msgContent = new MimeBodyPart();
            htmlContent.addBodyPart(msgContent);
            msgContent.setContent(emailContent, "text/html;charset=utf-8");
            htmlBody.setContent(htmlContent);
            mp.addBodyPart(htmlBody);

		/*	// 利用枚举器方便的遍历集合
            Enumeration efile = file.elements();
			// 检查序列中是否还有更多的对象
			while (efile.hasMoreElements()) {
				MimeBodyPart mbp = new MimeBodyPart();
				// 选择出每一个附件名
				filename = efile.nextElement().toString();
				// 得到数据源
				FileDataSource fds = new FileDataSource(filename);
				// 得到附件本身并至入BodyPart
				mbp.setDataHandler(new DataHandler(fds));
				// 得到文件名同样至入BodyPart
				mbp.setFileName(fds.getName());
				mp.addBodyPart(mbp);
			}
			// 移走集合中的所有元素
			file.removeAllElements();*/
            // Multipart加入到信件
            msg.setContent(mp);
            // 设置信件头的发送日期
            msg.setSentDate(new Date());
            // 发送信件
            Transport.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    class PopupAuthenticator extends Authenticator {
        String username = null;
        String password = null;

        public PopupAuthenticator(String user, String pass) {
            username = user;
            password = pass;
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    }

    /**
     * 忘记密码的HTML
     *
     * @return
     */
    public static String getForgetHtml() {
        User user = new User();
        user.setLoginName("loginName");
        user.setId(123454L);
        StringBuilder buff = new StringBuilder();
        //buff.append("test");
        buff.append("http://www.happy-ad.cn/admin/toResetPassword?token=" + UserUtils.generateRestPasswordToken(user) + "&identity=" + UserUtils.generateIdentityForResetPassword(user));

        return buff.toString();
    }

    public static void main(String[] args) {
        MailUtil.getInstance().startSend("753036576@qq.com", "快乐网-密码重置", MailUtil.getForgetHtml());
    }
}

