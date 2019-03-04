package com.example.zgq.service.imp;

import com.example.zgq.model.test.User;
import com.example.zgq.repository.test.UserRepository;
import com.example.zgq.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @ Author     ：Zgq
 * @ Date       ：Created in 10:14 2019/3/4
 * @ Description：实现类
 * @ Modified By：
 * @Version: $
 */

//@Transactional
@Service
public class UserServiceImp implements UserService {

    @Resource
    private UserRepository userRepository;


    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    //@Transactional
    @Override
    public User save(User User) {
        User user =userRepository.save(User);
        String error=null;
        error.split("/");

        return user;
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }


    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public List<User> findByName(String name){
        return userRepository.findByName(name);
    }

    @Override
    public List<User> findByNameLike(String name) {
        return userRepository.findByNameLike(name);
    }

    @Override
    public List<User> findByIdIn(Collection<String> ids){
        return userRepository.findByIdIn(ids);
    }

}
