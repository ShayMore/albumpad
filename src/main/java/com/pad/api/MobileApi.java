package com.pad.api;

import com.pad.base.common.systemreturn.ReturnValue;
import com.pad.base.common.tools.JsonUtils;
import com.pad.mobile.user.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author myl
 * Created by Administrator on 2017/7/16 0016.
 */
@Controller
@RequestMapping("/mobile")
@SuppressWarnings("rawtypes")
public class MobileApi {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    UserService userServiceImpl;

    @RequestMapping("/user/getCode")
    @ResponseBody
    public Object getCode(@RequestParam("data") String data) {
        logger.info("[获取验证码] " + data);
        Map<String, Object> map = JsonUtils.jsonToMap(data);
        String account = String.valueOf(map.get("account"));
        String type = String.valueOf(map.get("type"));
        ReturnValue ret =  userServiceImpl.getCode(account,type);
        return ret;
    }

    @RequestMapping("/user/register")
    @ResponseBody
    public Object register(@RequestParam("data") String data) {
        logger.info("[用户注册] " + data);
        Map<String, Object> map = JsonUtils.jsonToMap(data);
        String account = String.valueOf(map.get("account"));
        String password = String.valueOf(map.get("password"));
        ReturnValue ret =  userServiceImpl.register(account,password);
        return ret;
    }

    @RequestMapping("/user/login")
    @ResponseBody
    public Object login(@RequestParam("data") String data) {
        logger.info("[用户登录] " + data);
        Map<String, Object> map = JsonUtils.jsonToMap(data);
        String account = String.valueOf(map.get("account"));
        String password = String.valueOf(map.get("password"));
        ReturnValue ret =  userServiceImpl.login(account,password);
        return ret;
    }

    @RequestMapping("/article")
    public Object article() {
        return null;
    }

    @RequestMapping("/device")
    public Object device() {
        return null;
    }
}
