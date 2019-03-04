package com.example.zgq;

import com.example.zgq.model.test.User;
import com.example.zgq.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZgqApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private UserService userService;


	@Test
	public void contextLoads() {
	}


	@Test
    public  void mysqlTest(){
	    String sql="select * from user";
	    List<User> userList =jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user=new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });

        System.out.printf("查询成功:");
        for (User u: userList) {
            System.out.printf("[id]:"+u.getId()+"[name]:"+u.getName());
        }

    }

	@Test
    public void testSelect(){
        List<Map<String,Object>> result = jdbcTemplate.queryForList("select * from user");
        System.out.println("query result is = "+result.size());
        System.out.printf("result="+result);
        System.out.printf("success");
    }

    @Test
    public void testUpdate(){
        jdbcTemplate.execute("update user set name='周国庆' where id=1");

        System.out.printf("success");
    }

    @Test
    public void testInsert(){
        jdbcTemplate.execute("INSERT INTO user(name) VALUES ('孙标')");

        System.out.printf("success");
    }

    @Test
    public void testDel(){
        jdbcTemplate.execute("DELETE from user where name='孙标'");
        System.out.printf("success");
    }




    @Test
    public void testRedis(){
        //增 key：name，value：ay
        redisTemplate.opsForValue().set("name","ay");
        String name = (String)redisTemplate.opsForValue().get("name");
        System.out.println(name);
        //删除
        redisTemplate.delete("name");
        //更新
        redisTemplate.opsForValue().set("name","al");
        //查询
        name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);
    }



    @Test
    public void testRepository() {
        //查询所有数据
        List<User> userList = userService.findAll();
        System.out.println("findAll() :" + userList.size());
        //通过name查询数据
        List<User> userList2 = userService.findByName("周国庆");
        System.out.println("findByName() :" + userList2.size());
        Assert.isTrue(userList2.get(0).getName().equals("周国庆"), "data error!");
        //通过name模糊查询数据
        List<User> userList3 = userService.findByNameLike("%国%");
        System.out.println("findByNameLike() :" + userList3.size());
        Assert.isTrue(userList3.get(0).getName().equals("周国庆"), "data error!");
        //通过id列表查询数据
        List<String> ids = new ArrayList<String>();
        ids.add("1");
        ids.add("2");
        List<User> userList4 = userService.findByIdIn(ids);
        System.out.println("findByIdIn() :" + userList4.size());
        //分页查询数据
        PageRequest pageRequest = new PageRequest(0, 10);
        Page<User> userList5 = userService.findAll(pageRequest);
        System.out.println("page findAll():" + userList5.getTotalPages() + "/" + userList5.getSize());
        //新增数据
        User User = new User();
        User.setId("3");
        User.setName("test");
        User.setPassword("123");
        userService.save(User);
        //删除数据
        userService.delete("3");

    }

    @Test
    public void testTransaction() {
        User User = new User();
        User.setId("2");
        User.setName("阿华");
        User.setPassword("123");
        userService.save(User);
    }


}
