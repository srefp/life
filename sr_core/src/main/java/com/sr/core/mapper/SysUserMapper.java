package com.sr.core.mapper;

import com.sr.core.pojo.SysUser;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author lkj
 * @date 2021/05/14
 */
public interface SysUserMapper {

    /**
     * 根据参数进行分页查询
     *
     * @param params 参数
     * @param offset 偏移量
     * @param pageSize 页面大小
     * @return 查询的数据
     */
    List<SysUser> selectByParams(
            @Param("params") Map<String, Object> params,
            @Param("offset") Integer offset,
            @Param("pageSize") Integer pageSize
    );

    /**
     * 获取参数条件下的记录数
     *
     * @param params 参数
     * @return 记录数
     */
    int count(@Param("params") Map<String, Object> params);

    /**
     * 批量增加SysUser
     *
     * @param sysUsers SysUser数组
     * @return 是否批量增加成功
     */
    int insertBatch(List<SysUser> sysUsers);

    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return 用户
     */
    SysUser getUser(String username);

    /**
     * 保存用户
     *
     * @param sysUser 用户
     * @return 插入的行数
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(SysUser sysUser);

    /**
     * 删除用户的所有角色
     *
     * @param userId 用户ID
     * @return 删除的行数
     */
    int deleteUserRole(Long userId);

    /**
     * 保存用户的角色
     *
     * @param userId  用户ID
     * @param roleIds 角色ID
     * @return 插入的行数
     */
    int saveUserRoles(Long userId, List<Long> roleIds);

    /**
     * 通过ID获取用户
     *
     * @param id 用户ID
     * @return 用户
     */
    @Select("select * from sys_user t where t.id = #{id}")
    SysUser getById(Long id);

    /**
     * 修改密码
     *
     * @param id       用户ID
     * @param password 用户密码
     * @return 修改的行数
     */
    @Update("update sys_user t set t.password = #{password} where t.id = #{id}")
    int changePassword(@Param("id") Long id, @Param("password") String password);

    /**
     * 更新用户
     *
     * @param user 用户
     * @return 修改的行数
     */
    int update(SysUser user);
}
