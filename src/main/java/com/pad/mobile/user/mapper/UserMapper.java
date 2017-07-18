package com.pad.mobile.user.mapper;

import com.pad.mobile.user.model.Sip;
import com.pad.mobile.user.model.UserInfo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author myl
 * Created by Administrator on 2017/7/6 0006.
 */
@Repository
public interface UserMapper {

    /**
     * 检验此手机号码是否注册
     * @param account
     * @return
     */
    public int checkPhoneNumber(@Param("account")String account, @Param("phone") String phone);

    public int addUser(UserInfo userInfo);

    public String loginCheck(String account);

    public int isBinding(String userId);

    public UserInfo queryUserInfo(@Param("path")String path,@Param("userId")String userId);

    public Sip getSipNo();

    public int checkSipNoCount();

    public int updateSipStatus(String nid);

}
