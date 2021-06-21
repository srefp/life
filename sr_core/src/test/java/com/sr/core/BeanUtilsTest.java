package com.sr.core;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

/**
 * @author lkj
 * @date 2021/5/15
 */
// @RunWith(SpringRunner.class)
// @SpringBootTest
public class BeanUtilsTest {

    @Test
    public void test() {
        User user = new User();
        user.setName("小明");
        user.setAge(18);
        user.setHobby("篮球");

        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user, sysUser);

        System.out.println(user);
        System.out.println(sysUser);
    }

}

@Data
class User {
    private String name;
    private Integer age;
    private String hobby;
}

@Data
class SysUser {
    private String name;
    private String password;
    private Integer age;
}
