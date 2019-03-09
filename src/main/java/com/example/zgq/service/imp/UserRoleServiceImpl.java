package com.example.zgq.service.imp;

import com.example.zgq.model.test.UserRoleRel;
import com.example.zgq.repository.test.UserRoleRelRepository;
import com.example.zgq.service.UserRoleRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：用户角色关联Service
 * @author   zgq
 * @date     2017/12/10.
 */
@Service
public class UserRoleServiceImpl implements UserRoleRelService {

    @Resource
    private UserRoleRelRepository UserRoleRelRepository;

    @Override
    public List<UserRoleRel> findByUserId(String userId) {
        return UserRoleRelRepository.findByUserId(userId);
    }
}
