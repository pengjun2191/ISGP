package com.example.isgpspring.mapper;


import com.example.isgpspring.entity.PSysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PSysUserMapper {
//    查询所有用户
    @Select("select * from p_sys_user order by user_id")
    @Results(id="psysuser",value={
            @Result(column="user_id",property = "userId"),
            @Result(column="user_name",property = "userName"),
            @Result(column="user",property = "user"),
            @Result(column="user_password",property = "userPw"),
            @Result(column="user_salt",property = "userSalt"),
            @Result(column="user_phone",property = "userPhone"),
            @Result(column="user_address",property = "userAddr"),
            @Result(column="user_email",property = "userEmail"),
            @Result(column="user_auth_type",property = "userAuthType"),
            @Result(column="user_auth_number",property = "userAuthNum"),
            @Result(column="user_age",property = "userAge"),
            @Result(column="user_create_date",property = "userCreateDate")
})
    List<PSysUser> findAll();
//    根据用户id查询用户
    @Select("select * from p_sys_user where user_id=#{userId}")
    @ResultMap(value={"psysuser"})
    PSysUser findByUserId(Integer userId);
//    根据用户名查询用户
    @Select("select * from p_sys_user where user_name=#{username}")
    PSysUser findByUsername(String username);
//    根据用户名、用户密码查询用户
    @Select("select * from p_sys_user where user_name=#{username} and user_password=#{password}")
    PSysUser getByUsernameAndPassword(String username,String password);
//    根据用户id删除用户
    @Delete("delete from p_sys_user where user_id=#{userId}")
    Integer deleteByUserId(Integer userId);
//    插入用户
    @Options(useGeneratedKeys = true,keyProperty = "userId")
    @Insert("Insert into p_sys_user() values()")
    Integer insertPSysUser(PSysUser pSysUser);

    @Update("update p_sys_user set user_password=#{userPw} where user_id=#{userId}")
    Integer updatePSysUser(PSysUser pSysUser);
}
