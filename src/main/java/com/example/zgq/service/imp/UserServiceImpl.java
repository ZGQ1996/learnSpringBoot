package com.example.zgq.service.imp;

import com.example.zgq.dao.UserDao;
import com.example.zgq.model.test.User;
import com.example.zgq.repository.test.UserRepository;
import com.example.zgq.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @ Author     ：Zgq
 * @ Date       ：Created in 22:24 2019/3/9
 * @ Description：用户service层实现类
 * @ Modified By：
 * @Version: $
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserDao userDao;

    Logger logger = LogManager.getLogger(this.getClass());


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

        logger.info("userId"+id+"被删除了");
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


    @Override
    public User findByNameAndPassword(String name, String password) {
        return userDao.findByNameAndPassword(name,password);
    }

    @Override
    public User findByUserName(String name) {
        return userDao.findByUserName(name);
    }
}
