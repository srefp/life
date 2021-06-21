package com.sr.core;

import com.sr.core.mapper.SysPermMapper;
import com.sr.core.pojo.SysPerm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

/**
 * @author lkj
 * @date 2021/5/14
 */
@SpringBootTest
public class MyBatisTest {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private SysPermMapper sysPermMapper;

    @Test
    public void test() {
        String password = passwordEncoder.encode("123456");
        System.out.println(password);
        System.out.println(password.length());
    }

    @Test
    public void sysPermMapperTest() {
        List<SysPerm> sysPerms = sysPermMapper.listByUserId(1L);
        for (SysPerm sysPerm : sysPerms) {
            System.out.println(sysPerm);
        }
    }
}
