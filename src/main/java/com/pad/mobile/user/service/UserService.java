package com.pad.mobile.user.service;

import com.pad.base.common.systemreturn.ReturnValue;

/**
 * @author myl
 * Created by Administrator on 2017/7/6 0006.
 */
@SuppressWarnings("rawtypes")
public interface UserService {

    public ReturnValue getCode(String account, String type);

    public ReturnValue register(String account, String password);

    public ReturnValue login(String account, String password);
}
