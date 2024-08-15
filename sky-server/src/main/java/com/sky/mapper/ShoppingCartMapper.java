package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {

    /*
    * 动态查询sql
    * */
    List<ShoppingCart> list (ShoppingCart shoppingCart);

    /*
    * 根据id更新数据
    * */
    @Update("update shopping_cart set number = #{number} where id = #{id}")
    void updateNumberById (ShoppingCart shoppingCart);

    /*
    * 插入购物车数据
    * */
    @Insert("insert into shopping_cart (name, image, user_id, dish_id, setmeal_id, dish_flavor, amount, create_time,number) value " +
            "(#{name},#{image},#{userId},#{dishId},#{setmealId},#{dishFlavor},#{amount},#{createTime},#{number})")
    void install(ShoppingCart shoppingCart);
    /**
     * 根据id删除购物车数据
     * @param id
     */
    @Delete("delete from shopping_cart where id = #{id}")
    void deleteById(Long id);

    /*
    *根据userid删除
    * */
    @Delete("delete from shopping_cart where user_id = #{userId}")
    void deleteByUserId(Long userId);
}
