package com.example.zgq.security;

import com.example.zgq.error.BusinessException;
import com.example.zgq.model.test.User;
import com.example.zgq.model.test.UserRoleRel;
import com.example.zgq.service.RoleService;
import com.example.zgq.service.UserRoleRelService;
import com.example.zgq.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：Zgq
 * @ Date       ：Created in 22:45 2019/3/9
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Service
public class CustomuserService implements UserDetailsService {

    @Resource
    private UserService userService;

    @Resource
    private UserRoleRelService userRoleRelService;

    @Resource
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user=userService.findByUserName(name);
        if(user == null){
            throw new BusinessException("用户不存在");
        }
        //获取用户所有的关联角色
        List<UserRoleRel> ayRoleList = userRoleRelService.findByUserId(user.getId());
        List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
        if(ayRoleList != null && ayRoleList.size() > 0){
            for(UserRoleRel rel:ayRoleList){
                //获取用户关联角色名称
                String roleName = roleService.find(rel.getRoleId()).getName();
                authorityList.add(new SimpleGrantedAuthority(roleName));
            }
        }
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorityList);
    }

}
