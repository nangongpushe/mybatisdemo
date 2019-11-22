package com.zpc.mybatis.Test;

import com.zpc.mybatis.dao.OrderMapper;
import com.zpc.mybatis.dao.UserMapper;
import com.zpc.mybatis.pojo.Order;
import com.zpc.mybatis.pojo.OrderDetail;
import com.zpc.mybatis.pojo.OrderUser;
import com.zpc.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class OrderMapperTest {

    public OrderMapper orderMapper;
    @Before
    public void setUp() throws Exception {
        // 指定配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 1. 映射文件的命名空间（namespace）必须是mapper接口的全路径
        // 2. 映射文件的statement的id必须和mapper接口的方法名保持一致
        // 3. Statement的resultType必须和mapper接口方法的返回类型一致
        // 4. statement的parameterType必须和mapper接口方法的参数类型一致（不一定）
        this.orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void queryOrderUserByOrderNumber() throws Exception {
        /**
         * 这里从数据库查出来的数据不止一条，是要用List集合进行接收的，在List集合中泛型定义为实体类OrderUser
         * 相应的在对应的xml文件中的返回值resultType也为实体类OrderUser的全路径，不能写成java.util.List
         */
        List<OrderUser> list = orderMapper.queryOrderUserByOrderNumber("201807010001");
//        List<OrderUser> list = orderMapper.queryOrderUserByOrderNumber();
        for(OrderUser orderUser : list) {
            System.out.println(orderUser);
        }
    }

    @Test
    public void queryOrderWithUserByOrderNumber() throws Exception {
        List<Order> list = orderMapper.queryOrderWithUserByOrderNumber("201807010001");
        for(Order order : list) {
            System.out.println(order);
        }
    }

    @Test
    public void queryOrderWithUserAndDetailByOrderNumber() throws Exception {
        List<Order> orderList = orderMapper.queryOrderWithUserAndDetailByOrderNumber();
        for (Order order : orderList) {
            System.out.println(order.getUser());
            List<OrderDetail> orderDetailList = order.getDetailList();
            for(OrderDetail orderDetail : orderDetailList){
                System.out.println(orderDetail);
            }
        }
    }
    @Test
    public void queryOrderWithUserAndDetailItemByOrderNumber() throws Exception {
        List<Order> orderList = orderMapper.queryOrderWithUserAndDetailItemByOrderNumber();
        for (Order order : orderList) {
            System.out.println(order.getUser());
            List<OrderDetail> orderDetailList = order.getDetailList();
            for (OrderDetail orderDetail : orderDetailList) {
                System.out.println(orderDetail);
                System.out.println(orderDetail.getItem());
            }
        }
    }

    @Test
    public void queryOrderWithUserAndDetailItemByOrderNumber1() throws Exception {
        List<User> userList = orderMapper.queryOrderWithUserAndDetailItemByOrderNumber1();
        for (User user : userList) {
            System.out.println(user);
           List<Order> orderList = user.getOrderList();
           for(Order order : orderList) {
               System.out.println(order);
               List<OrderDetail> orderDetailList = order.getDetailList();
               for (OrderDetail orderDetail : orderDetailList) {
                   System.out.println(orderDetail);
                   System.out.println(orderDetail.getItem());
               }
           }
        }
    }

    //查询订单，关联查询用户，用户信息延迟加载
    @Test
    public void testFindOrderUserLazyLoading() throws Exception {
       List<Order> list = orderMapper.findOrderUserLazyLoading();
       for (Order order : list) {
           System.out.println(order.getUser());
       }
    }
}