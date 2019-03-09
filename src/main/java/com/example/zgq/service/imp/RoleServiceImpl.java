package com.example.zgq.service.imp;

import com.example.zgq.model.test.Role;
import com.example.zgq.repository.test.RoleRepository;
import com.example.zgq.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 描述：用户角色Service
 * @author 周国庆
 * @date   2017/12/2
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleRepository RoleRepository;

    @Override
    public Role find(String id){
        return RoleRepository.findById(id).get();
    }
}
