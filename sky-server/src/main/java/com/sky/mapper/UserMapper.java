package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserMapper {

    /*
    * 根据openid查询用户
    * */
    @Select("select * from user where openid = #{openid}")
    User getUserById(String openid);

    /*
    * 插入数据
    * */
    void install(User user);

    @Select("select * from user where id = #{userId}")
    User getById(Long userId);
    /*
    * 用户数量
    * */
    Integer countByMap(Map map);
}
