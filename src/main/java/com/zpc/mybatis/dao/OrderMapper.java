package com.zpc.mybatis.dao;

import com.zpc.mybatis.pojo.Order;
import com.zpc.mybatis.pojo.OrderUser;
import com.zpc.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 */
public interface OrderMapper {

    List<OrderUser> queryOrderUserByOrderNumber(@Param("number") String number);
//      List<OrderUser> queryOrderUserByOrderNumber() throws Exception;
    /**
     * 根据订单号查询订单用户的信息
     * @param number
     * @return
     */
    List<Order> queryOrderWithUserByOrderNumber(@Param("number") String number);
    /**
     * 根据订单号查询订单用户的信息及订单详情
     * @param number
     * @return
     */
    List<Order> queryOrderWithUserAndDetailByOrderNumber() throws Exception;
    /**
     * 根据订单号查询订单用户的信息及订单详情及订单详情对应的商品信息
     * @param number
     * @return
     */
    List<Order> queryOrderWithUserAndDetailItemByOrderNumber() throws Exception;

    List<User> queryOrderWithUserAndDetailItemByOrderNumber1() throws Exception;

    User queryUserById(@Param("id") int id) throws Exception;

    List<Order> findOrderUserLazyLoading() throws Exception;
}
