package com.mx.bbva.config.test;

import com.mx.bbva.config.test.UserInfo;

import java.util.List;

public interface UserInfoDAO {

    public UserInfo findUserInfo(String userName);

    // [USER,AMIN,..]
    public List<String> getUserRoles(String userName);

}