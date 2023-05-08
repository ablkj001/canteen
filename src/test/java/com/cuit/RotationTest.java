package com.cuit;

import com.cuit.mapper.RotationMapper;
import com.cuit.pojo.Dishes;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
public class RotationTest {
    @Autowired
    DataSource dataSource;

    @Autowired
    RotationMapper rotationMapper;

    @Test
    public void test() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        connection.close();
    }

    /**
     *测试晋升
     */
    @Test
    public void testA() {

        int id = 1;
        rotationMapper.updateRotationPromote(id);

        id = 6;
        rotationMapper.updateRotationPromote(id);

        id = 7;
        rotationMapper.updateRotationPromote(id);
    }

    /**
     * 测试查询
     */
    @Test
    public void testB() {

        int page = 1;
        String dname = null;
        System.out.println(rotationMapper.queryFirstGrade(dname,page));
        System.out.println(rotationMapper.querySecondGrade(dname,page));
    }

    /**
     * 测试降级
     */
    @Test
    public void testC() {
        rotationMapper.updateRotationReduce(1);
    }

}
