package com.example.zgq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZgqApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;


	@Test
	public void contextLoads() {
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

}
