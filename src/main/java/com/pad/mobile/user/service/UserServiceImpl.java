package com.pad.mobile.user.service;

import com.pad.base.common.Constants;
import com.pad.base.common.systemreturn.ReturnCode;
import com.pad.base.common.systemreturn.ReturnDesc;
import com.pad.base.common.systemreturn.ReturnValue;
import com.pad.base.common.tools.Randnum;
import com.pad.base.common.tools.SendMail;
import com.pad.base.common.tools.StringHelper;
import com.pad.base.generate.IdentifierMapper;
import com.pad.mobile.user.mapper.UserMapper;
import com.pad.mobile.user.model.Sip;
import com.pad.mobile.user.model.UserInfo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author myl
 * Created by Administrator on 2017/7/6 0006.
 */
@Service
@SuppressWarnings("rawtypes")
public class UserServiceImpl implements UserService {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    UserMapper userMapper;

    @Autowired
    IdentifierMapper identifierMapper;

    /**
     * 获取验证码
     * @param account
     * @param type：register 注册/modifyPassword 忘记密码
     * @return
     */
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.SUPPORTS)
    public ReturnValue getCode(String account, String type) {
        int count = userMapper.checkPhoneNumber(account,"");
        ReturnValue<Map<String,String>> ret = new ReturnValue<Map<String,String>>();

        boolean flag = false;
        if("register".equals(type)) {
            if (count > 0) {
                logger.info("[获取验证码 注册] 账户已注册过！");
                ret.setRetCode(ReturnCode.FAIL);
                ret.setRetDesc(ReturnDesc.GETCODE_FAIL);
            } else {
            	
                // 生成随机验证码
                int code = Randnum.getRandomNumber(6);
                Map<String,String> map = new HashMap<String,String>();
                map.put("account",account);
                map.put("code",String.valueOf(code));
                
                if(account.contains("@")) {
                    flag = sendCodeMail(account, code);
                    if (flag) {
                        logger.info("[获取验证码 注册] 验证码发送成功！");
                        ret.setRetVal(map);
                        ret.setRetCode(ReturnCode.SUCCESS);
                        ret.setRetDesc(ReturnDesc.GETCODE_SUCCESS);
                        
                    } else {
                        logger.info("[获取验证码 注册] 验证码发送失败！");
                        ret.setRetCode(ReturnCode.FAIL);
                        ret.setRetDesc(ReturnDesc.GETCODE_FAIL);
                    }
                }  
            }
        } else if("modifyPassword".equals(type)) {
            if(count > 0) {
            	
                // 生成随机验证码
                int code = Randnum.getRandomNumber(6);

                Map<String,String> map = new HashMap<String,String>();
                map.put("account",account);
                map.put("code",String.valueOf(code));
               
                if(account.contains("@")) {
                    flag = sendCodeMail(account, code);
                    if (flag) {
                        logger.info("[获取验证码 忘记密码] 验证码发送成功！");
                        ret.setRetVal(map);
                        ret.setRetCode(ReturnCode.SUCCESS);
                        ret.setRetDesc(ReturnDesc.GETCODE_SUCCESS);
                        
                    } else {
                        logger.info("[获取验证码 忘记密码] 验证码发送失败！");
                        ret.setRetCode(ReturnCode.FAIL);
                        ret.setRetDesc(ReturnDesc.GETCODE_FAIL);
                    }
                } 
            } else {
                logger.info("[获取验证码 忘记密码] 用户未注册！");
                ret.setRetCode(ReturnCode.FAIL);
                ret.setRetDesc(ReturnDesc.GETCODE_FAIL);
            }
        }
        return ret;
    }

    /**
     * 用户注册
     * @param account
     * @param password
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public ReturnValue register(String account, String password) {
        ReturnValue ret = new ReturnValue();
        logger.info("[用户注册] 开始注册...");

        // 获取SIP号
        Sip sip = getSipNo();
        if (sip != null) {

            logger.info("[用户注册] 获取Sip号成功！" + sip);
            // 默认情况下，账号为手机号，若是邮箱注册则自动生成6位包含大写字母或数字的账号。
            String diyPhone = account;
            if(account.contains("@")) {
                logger.info("[用户注册] 邮箱注册");
                while(true){
                    diyPhone = Randnum.getRandomAccountnumber(6);
                    int a = userMapper.checkPhoneNumber("",diyPhone);
                    if(a == 0) {
                        break;
                    }
                }
            }

            logger.info("[用户注册] 开始生成标识.... ");
            String id = identifierMapper.getId("I", "U");
            logger.info("[用户注册] 生成标识成功 userid = " + id);
            String headPortrait = Constants.DEFAULT_PIC;

            UserInfo user = new UserInfo();
            user.setUserid(id);
            user.setAccountnumber(account);
            user.setPassword(password);
            user.setNickname(account);
            user.setPhone(diyPhone);
            user.setSipno(sip.getSipNo());
            user.setSippw(sip.getSipPw());
            user.setHeadportrait(headPortrait);
            int count = userMapper.addUser(user);

            ret = new ReturnValue<Object>();

            if (count > 0) {
                logger.info("[用户注册] 注册成功！");
                ret.setRetCode(ReturnCode.SUCCESS);
                ret.setRetDesc(ReturnDesc.REGISTER_SUCCESS);
            } else {
                logger.info("[用户注册] 注册失败！用户信息添加失败！");
                ret.setRetCode(ReturnCode.FAIL);
                ret.setRetDesc(ReturnDesc.REGISTER_FAIL);
            }

        }
        return ret;
    }

    /**
     * 用户登录
     * @param account
     * @param password
     * @return
     */
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.SUPPORTS)
    public ReturnValue login(String account, String password) {
        ReturnValue<Object> ret = new ReturnValue<Object>();
        String str = userMapper.loginCheck(account);
        if(StringHelper.isNotNull(str)) {
            String[] accountInfo = str.split(",");
            if(accountInfo[1].equals(password)) {
                logger.info("[用户登录] 登录成功！");
                String userId = accountInfo[0];
                int bind = userMapper.isBinding(userId);
                if(bind > 0) {
                    ret.setContent("yes");
                } else {
                    ret.setContent("no");
                }

                UserInfo userInfo = userMapper.queryUserInfo(Constants.FILE_NETWORK_PATH,userId);
                ret.setRetVal(userInfo);
                ret.setRetCode(ReturnCode.SUCCESS);
                ret.setRetDesc(ReturnDesc.LOGIN_SUCCESS);

            } else {
                logger.info("[用户登录] 密码错误！");
                ret.setRetCode(ReturnCode.U_ACCOUNT_PASSWORD_WRONG);
            }
        } else {
            logger.info("[用户登录] 账号不存在！");
            ret.setRetCode(ReturnCode.U_ACCOUNT_PASSWORD_WRONG);
        }
        return ret;
    }

    /**
     * 获取sip号
     * @return
     */
    public Sip getSipNo(){
        Sip sip = userMapper.getSipNo();
        int count = userMapper.checkSipNoCount();
        if (count <= 10) {
            SendMail.sendMail("1473605922@qq.com", "", "", "[Photolink]注册时可用Sip号已不足10个，请尽快添加！", "");
            logger.info("[用户注册] 可用sip号不超过10个");
        }
        int update = userMapper.updateSipStatus(sip.getNid());
        if(update > 0) {
            return sip;
        }
        return null;
    }

    /**
     * 邮件发送
     * @param account
     * @param code
     * @return
     */
    public boolean sendCodeMail(String account, int code){
        String to = account;
        String copyTo = "";
        String bcc = "";
        String subject = "Welcome To Photolink!";

        StringBuffer content = new StringBuffer();
        content.append(
                "<!DOCTYPE html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
        content.append(
                "<meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0\">");
        content.append(
                "<title>Welcome To SegoPet</title><style type=\"text/css\">body {font-size: 14px;font-family: \"Microsoft YaHei\" ! important;}");
        content.append("</style></head><body>");
        content.append("<div style=\"width: 100%;\"><span>Welcome to Photolink!</span><br/><br/>");
        content.append(
                "<span>Thank you for signing up for a Photolink account. Your verifaction code is </span><br/><br/>");
        content.append("<span>"+code+"<br/><br/><br/><br/>");
        content.append(
                "<span style=\"font-size: 12px;\">SegoPet 2017. All rights reserved.</span><br/><br/>");
        content.append("</div></body></html>");
        boolean flag =  SendMail.sendMail(to,copyTo,bcc,subject,content.toString());
        return flag;
    }

}
