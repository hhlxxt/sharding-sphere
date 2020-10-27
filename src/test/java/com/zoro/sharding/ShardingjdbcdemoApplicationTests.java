package com.zoro.sharding;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zoro.sharding.entity.Course;
import com.zoro.sharding.entity.Udict;
import com.zoro.sharding.entity.User;
import com.zoro.sharding.mapper.CourseMapper;
import com.zoro.sharding.mapper.UdictMapper;
import com.zoro.sharding.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingjdbcdemoApplicationTests {

    //注入mapper
    @Autowired
    private CourseMapper courseMapper;

    //注入user的mapper
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UdictMapper udictMapper;

    //======================测试水平分表 start 修改application.properties 为dev =====================
    //添加操作
    @Test
    public void addCourseDb() {
        for (int i = 0; i < 10 ; i++) {
            Course course = new Course();
            course.setCname("javademo1");
            course.setUserId(112L);
            course.setCstatus("Normal1");
            courseMapper.insert(course);
        }
    }

    //查询操作
    @Test
    public void findCourseDb() {
        QueryWrapper<Course>  wrapper = new QueryWrapper<>();
        //设置userid值
        wrapper.eq("user_id",100L);
        //设置cid值
        wrapper.eq("cid",465162909769531393L);
        Course course = courseMapper.selectOne(wrapper);
        System.out.println(course);
    }
    //======================测试水平分表 end =====================

    //=======================测试水平分库、分表 start  修改application.properties 为test ===================
    //添加课程的方法
    @Test
    public void addCourse() {
        for(int i=1;i<=10;i++) {
            Course course = new Course();
            course.setCname("java"+i);
            course.setUserId(100L);//db1
            course.setUserId(101L);//db2
            course.setCstatus("Normal"+i);
            courseMapper.insert(course);
        }
    }
    //查询课程的方法
    @Test
    public void findCourse() {
        QueryWrapper<Course>  wrapper = new QueryWrapper<>();
        wrapper.eq("userId",101);
        List<Map<String, Object>> maps = courseMapper.selectMaps(wrapper);
        System.out.println(maps);
    }
    //=======================测试水平分库、分表 end===================


    //======================测试 单库单表 start  修改application.properties 为pro==================
    //添加操作
    @Test
    public void addUserDb() {
        User user = new User();
        user.setUsername("lucymary");
        user.setUstatus("a");
        userMapper.insert(user);
    }

    //查询操作
    @Test
    public void findUserDb() {
        QueryWrapper<User>  wrapper = new QueryWrapper<>();
        //设置userid值
        wrapper.eq("user_id",465508031619137537L);
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

//======================测试 单库单表 end==================


    //======================测试公共表 start  修改application.properties 为common 配置的库会同时保存相同的数据===================
    //添加操作
    @Test
    public void addDict() {
        Udict udict = new Udict();
        udict.setUstatus("Y");
        udict.setUvalue("是");
        udictMapper.insert(udict);
    }

    //删除操作
    @Test
    public void deleteDict() {
        QueryWrapper<Udict>  wrapper = new QueryWrapper<>();
        //设置userid值
        wrapper.eq("dictid",527966916107567105L);
        udictMapper.delete(wrapper);
    }

    //======================测试公共表 end  ===================
}
