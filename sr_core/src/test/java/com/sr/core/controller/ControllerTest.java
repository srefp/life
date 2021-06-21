package com.sr.core.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sr.core.pojo.Task;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * 使用MockMvc进行controller层的测试
 *
 * @author lkj
 * @date 2021/5/17
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("1. 新建一个任务放在收集箱中")
    @Test
    public void test2() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/task/collection/new-task")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("2. 修改任务")
    @Test
    public void test3() throws Exception {
        Task task = new Task();
        task.setContent("good");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(task);
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.put("/task/collection/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("3. 查看任务列表")
    @Test
    public void test4() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/task/collection")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("2. 新建Task")
    @Disabled
    @Test
    public void test5() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/plan/task")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("1. 重定向到认证页面")
    @Disabled
    @Test
    public void test6() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/oauth/authorize")
                        .param("scope", "")
                        .param("client_id", "")
                        .param("state", "")
                        .param("redirect_uri", "")
                        .param("response_type", "")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("1. 保存用户")
    @Test
    public void test7() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/user")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("2. 修改用户")
    @Test
    public void test8() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.put("/user")


        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("3. 修改头像")
    @Test
    public void test9() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.put("/user")
                        .param("headImgUrl", "")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("4. 修改密码")
    @Test
    public void test10() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.put("/user/tom")
                        .param("oldPassword", "123456")
                        .param("newPassword", "123456")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("5. 用户列表")
    @Test
    public void test11() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/user")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("6. 获取当前登录用户")
    @Test
    public void test12() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/user/current")


        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("7. 根据用户ID获取用户")
    @Test
    public void test13() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/user/1")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("1. 检验sql，并返回sql返回的数量")
    @Test
    public void test14() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/excel/sql-count")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("2. 根据sql导出excel")
    @Test
    public void test15() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/excel")

        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("1. 添加定时任务")
    @Test
    public void test16() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/job")


        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("2. 修改定时任务")
    @Test
    public void test17() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.put("/job")


        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("3. 删除定时任务")
    @Test
    public void test18() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.delete("/job/1")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("4. 根据id获取定时任务")
    @Test
    public void test19() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/job/1")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("5. 定时任务列表")
    @Test
    public void test20() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/job")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("6. 检验cron表达式")
    @Test
    public void test21() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/job")
                        .param("cron", "")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("1. 保存邮件")
    @Test
    public void test22() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/mail")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("1. 获取日志列表")
    @Test
    public void test23() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/log")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("1. 文件上传")
    @Test
    public void test24() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/file")


        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("2. layui富文本文件自定义上传")
    @Test
    public void test25() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/file/layui")


        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("3. 文件查询")
    @Test
    public void test26() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/file")


        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("4. 文件删除")
    @Test
    public void test27() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.delete("/file/1")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("1. 获取当前登录用户拥有的权限")
    @Test
    public void test28() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/perm/current")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("2. 获取权限列表")
    @Test
    public void test29() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/perm")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("3. 获取所有权限")
    @Test
    public void test30() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/perm/all")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("4. 一级菜单")
    @Test
    public void test31() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/perm/parents")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("5. 根据角色ID获取权限")
    @Test
    public void test32() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/perm")
                        .param("roleId", "")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("6. 保存菜单")
    @Test
    public void test33() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/perm")


        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("7. 根据菜单ID获取菜单")
    @Test
    public void test34() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/perm/1")


        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("8. 修改菜单")
    @Test
    public void test35() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.put("/perm")


        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("9. 校验当前用户的权限")
    @Test
    public void test36() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/perm/owns")


        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("10. 删除菜单")
    @Test
    public void test37() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.delete("/perm/1")


        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("1. 保存角色")
    @Test
    public void test38() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/role")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("2. 角色列表")
    @Test
    public void test39() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/role")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("3. 根据ID获取角色")
    @Test
    public void test40() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/role/1")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("4. 获取所有角色")
    @Test
    public void test41() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/role/all")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("5. 根据用户ID获取拥有的角色")
    @Test
    public void test42() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/role")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @DisplayName("6. 删除角色")
    @Test
    public void test43() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.delete("/role/1")
        ).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }


}
