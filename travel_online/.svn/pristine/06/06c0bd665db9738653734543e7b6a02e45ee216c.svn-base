package com.regino.travel.service;

import com.regino.travel.domain.ResultInfo;
import com.regino.travel.domain.User;

public interface UserService {
    ResultInfo register(User param);

    User findByUsername(String username);

    User findByTelephone(String telephone);

    ResultInfo sendSms(String telephone, String smsCode);

    ResultInfo pwdLogin(User param);

    void updateInfo(User param);

    User findByUid(int uid);
}
