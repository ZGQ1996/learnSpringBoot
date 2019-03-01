package com.example.zgq;

import com.example.zgq.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                user.setId(rs.getInt("id"));
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
        List<Map<String,Object>> result = jdbcTemplate.queryForList("select * from test");
        System.out.println("query result is = "+result.size());
        System.out.printf("result="+result);
        System.out.printf("success");
    }

    @Test
    public void testUpdate(){
        jdbcTemplate.execute("update test set name='周国庆' where id=1");

        System.out.printf("success");
    }

    @Test
    public void testInsert(){
        jdbcTemplate.execute("INSERT INTO test(name) VALUES ('孙标')");

        System.out.printf("success");
    }

    @Test
    public void testDel(){
        jdbcTemplate.execute("DELETE from test where name='孙标'");
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

}
