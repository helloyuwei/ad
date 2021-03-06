package com.yuwei.adsense.controller.admin;

import com.yuwei.adsense.common.Global;
import com.yuwei.adsense.controller.BaseWebController;
import com.yuwei.adsense.core.UserUtils;
import com.yuwei.adsense.core.entity.Site;
import com.yuwei.adsense.core.entity.User;
import com.yuwei.adsense.freemarker.impl.ResetPasswordEmailTemplateService;
import com.yuwei.adsense.jms.MessageProducer;
import com.yuwei.adsense.jms.model.EmailModel;
import com.yuwei.adsense.services.UserService;
import com.yuwei.adsense.util.RequestUtils;
import com.yuwei.adsense.util.SpringContextUtils;
import com.yuwei.adsense.util.VerifyCodeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by YuWei on 2016/9/23.
 */
@Controller
@RequestMapping("/admin")
public class LoginController extends BaseWebController<User> {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private MessageProducer messageProducer;


    /**
     * 用户登出
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String forLogin(HttpServletRequest request) {
        return RequestUtils.getAdminUrl("/login");
    }

    /**
     * 获取验证码图片和文本(验证码文本会保存在HttpSession中)
     */
    @RequestMapping("/getVerifyCodeImage")
    public void getVerifyCodeImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置页面不缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 4, null);
        //将验证码放到HttpSession里面
        request.getSession().setAttribute(RequestUtils.CAPTCHA_PARAM, verifyCode);
        logger.debug("本次生成的验证码为[" + verifyCode + "],已存放到HttpSession中");
        //设置输出的内容的类型为JPEG图像
        response.setContentType("image/jpeg");
        BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, Color.BLACK, null);
        //写给浏览器
        ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
    }

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, User eUser) {

        String username = eUser.getLoginName();
        String password = eUser.getPassword();
        boolean isCaptcha = Global.getBooleanVal("web.view.captcha.enable");
        request.setAttribute("isCaptcha", isCaptcha);
        if (isCaptcha) {
            //获取HttpSession中的验证码
            String verifyCode = (String) request.getSession().getAttribute(RequestUtils.CAPTCHA_PARAM);
            //获取用户请求表单中输入的验证码
            String submitCode = RequestUtils.getCaptcha();
            logger.debug("用户[" + username + "]登录时输入的验证码为[" + submitCode + "],HttpSession中的验证码为[" + verifyCode + "]");
            if (StringUtils.isEmpty(submitCode) || !StringUtils.equals(verifyCode, submitCode.toLowerCase())) {
                RequestUtils.setErrorMessage("验证码不正确");
                return RequestUtils.getForwardAdminUrl("/");
            }
        }
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(RequestUtils.isRememberMe());
        logger.debug("为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        boolean isLogined = false;
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            logger.debug("对用户[" + username + "]进行登录验证..验证开始");
            currentUser.login(token);
            token.clear();
            User user = (User) currentUser.getSession().getAttribute("currentUser");
            request.getSession(false).setAttribute("currentUser", user);
            isLogined = true;
            logger.debug("对用户[" + username + "]进行登录验证..验证通过");
        } catch (UnknownAccountException uae) {
            logger.debug("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
            RequestUtils.setErrorMessage("未知账户");
        } catch (IncorrectCredentialsException ice) {
            logger.debug("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
            RequestUtils.setErrorMessage("密码不正确");
        } catch (LockedAccountException lae) {
            logger.debug("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
            RequestUtils.setErrorMessage("账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            logger.debug("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
            RequestUtils.setErrorMessage("用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.debug("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
            RequestUtils.setErrorMessage("用户名或密码不正确");
        }
        //验证是否登录成功
        if (currentUser.isAuthenticated()) {
            logger.debug("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
        } else {
            token.clear();
        }
        if (isLogined) {
            return RequestUtils.getRedirectAdminUrl("main");
        } else {
            return RequestUtils.getAdminUrl("login");
        }
    }

    /**
     * 用户登出
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        SecurityUtils.getSubject().logout();
        request.getSession(false).removeAttribute("currentUser");
        return RequestUtils.getAdminUrl("/login");
    }


    /**
     * 忘记密码
     */
    @RequestMapping("/forgotPassword")
    public String forgotPassword(HttpServletRequest request) {
        return RequestUtils.getAdminUrl("/forgetPassword");
    }

    @RequestMapping("/sendResetPassword")
    public void sendResetPassword(HttpServletRequest request) {
        String toEmail = request.getParameter("email");
        String loginName = request.getParameter("loginName");
        Site currentSite = SpringContextUtils.getCurrentSite();
        String emailContent = new ResetPasswordEmailTemplateService().getString(userService.getByUsername(loginName));
        logger.info("重置密码内容：" + emailContent);
        EmailModel emailModel = new EmailModel(toEmail, currentSite.getSiteName() + "-重置账号密码", emailContent);
        messageProducer.send(emailModel);
    }

    @RequestMapping("/toResetPassword")
    public String toResetPassword(HttpServletRequest request) {
        String token = request.getParameter("token");
        String identity = request.getParameter("identity");
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(identity)) {
            RequestUtils.setErrorMessage("参数错误");
            return RequestUtils.getAdminUrl("/login");
        }

        Long userId = UserUtils.getUserIdFromIdentity(identity);
        if (userId == 0) {
            RequestUtils.setErrorMessage("参数错误");
            return RequestUtils.getAdminUrl("/login");
        }
        User user = userService.get(userId);
        if (user == null) {
            RequestUtils.setErrorMessage("用户不存在.");
            return RequestUtils.getAdminUrl("/login");
        }
        if (!UserUtils.verifyResetToken(user, token)) {
            RequestUtils.setErrorMessage("链接已失效，请重新获取重置密码链接.");
            return RequestUtils.getAdminUrl("/login");
        }
        return RequestUtils.getAdminUrl("/resetPassword");
    }

    @RequestMapping("/resetPassword")
    public String resetPassword(HttpServletRequest request) {
        User user = userService.get(getEntity().getId());
        if (user == null) {
            return RequestUtils.getAdminUrl("/login");
        }
        user.setPassword(getEntity().getPassword());
        userService.saveOrUpdate(user);
        RequestUtils.setInfoMessage("密码重置成功，请使用新密码登陆!");
        return RequestUtils.getAdminUrl("/login");
    }
}
