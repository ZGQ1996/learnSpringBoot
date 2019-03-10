package com.example.zgq.api;

import com.example.zgq.domain.User;

/**
 * @ Author     ：Zgq
 * @ Date       ：Created in 12:16 2019/3/10
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public interface UserDubboService {

    User findByUserNameAndPassword(String name, String password);

}
