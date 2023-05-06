package com.cuit.service.Impl;

import com.cuit.combine.DI;
import com.cuit.combine.OR;
import com.cuit.mapper.*;
import com.cuit.pojo.*;
import com.cuit.service.OrderService;
import com.cuit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ShopCarMapper shopCarMapper;

    @Autowired
    private DishesMapper dishesMapper;

    @Autowired
    private OSMapper osMapper;

    @Autowired
    private OUMapper ouMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ShopMapper shopMapper;

    @Override
    @Transactional
    public Integer addOrder(Integer uid) {
        //根据用户ID获取已勾选的菜品详情
        List<ShopCar> shopCars = shopCarMapper.queryShopCarByStatus(uid);
        //生成时间戳
        String time = String.valueOf(System.currentTimeMillis());
        //记录生成订单的数量
        Integer count = 0;
        //用以存储本轮循环中出现过的orderid以及sid的组合
        Map<String,Integer> map = new HashMap<>();
        //当前时间
        Date date = new Date();
        //遍历循环购物车中的菜品
        for(ShopCar shopCar:shopCars){
            //生成流水号
            String onumber = time;
            //生成订单号，订单号为店铺ID+时间戳+用户ID
            String u = shopCar.getUid().toString();
            String s = shopCar.getSid().toString();
            String orderid = s + time + u;
            //往map集合中插入订单与店铺id
            map.put(orderid,shopCar.getSid());
            //获取菜品对象进而获得菜品价格
            Dishes dishes = dishesMapper.queryDishesByDid(shopCar.getDid());
            //当前总金额
            Integer payment = shopCar.getCount() * dishes.getDprice();
            //生成order对象
            Order order = new Order(onumber,orderid,shopCar.getUid(),shopCar.getSid(),shopCar.getDid(),payment,shopCar.getCount(),date);
            //插入数据库
            Integer i = orderMapper.addOrder(order);
            //记录插入的数据条数
            count = count + i;
        }
        //生成订单的同时，将该用户勾选的购物车中的内容删除
        Integer j = shopCarMapper.Order(uid);
        //循环遍历map集合获取orderid与sid的一一对应关系
        Set<String> keySet = map.keySet();
        //循环遍历所有的key集合，往两张关系表中插入数据
        for(String key:keySet){
            //先生成一个用户订单对象
            //再往用户订单关系表中插入信息
            OU ou = new OU(key,uid,date);
            ouMapper.addOU(ou);
            //生成一个店铺订单关系
            //再往店铺订单关系表中插入数据
            OS os = new OS(key,map.get(key),date);
            osMapper.addOS(os);
        }
        return count;
    }

    @Override
    @Transactional
    public Integer insertOrder(Integer uid, Integer sid, Integer did,Integer count) {
        //生成时间戳
        String time = String.valueOf(System.currentTimeMillis());
        //记录生成订单的数量
        Integer i = 0;
        //生成流水号
        String onumber = time;
        //当前时间
        Date date = new Date();
        //生成订单号，订单号为店铺ID+时间戳+用户ID
        String u = uid.toString();
        String s = sid.toString();
        String orderid = s + time + u;
        //获取菜品对象进而获得菜品价格
        Dishes dishes = dishesMapper.queryDishesByDid(did);
        //当前总金额
        Integer payment = count * dishes.getDprice();
        //生成order对象
        Order order = new Order(onumber,orderid,uid,sid,did,payment,count,date);
        //生成os对象
        OS os = new OS(orderid,sid,date);
        //往关联表中添加关系
        osMapper.addOS(os);
        //生成ou对象
        OU ou = new OU(orderid,uid,date);
        //往关联表中添加关系
        ouMapper.addOU(ou);
        //将订单插入数据库
        i = orderMapper.addOrder(order);
        return i;
    }

    @Override
    @Transactional
    public List<OR> queryOrderByUid(Integer uid,Integer page,Integer pagesize) {
        //首先根据uid分页获取与当前用户的关系
        List<OU> ous = ouMapper.queryOU(uid,page,pagesize);
        //获取用户信息
        User user = userMapper.queryUserById(uid);
        //然后将关系中的订单信息封装到列表中
        List<OR> ors = new ArrayList<>();
        //循环遍历关系列表
        for(OU ou : ous){
            //根据orderid查询出当前订单的详情
            List<Order> orders = orderMapper.queryOrderByOrderid(ou.getOrderid());
            //存储菜品详情的列表
            List<DI> dis = new ArrayList<>();
            //计算当前订单的总金额
            Integer total = 0;
            //flag用于记录当前订单完成的状态
            Integer flag = 0;
            //循环遍历菜品列表，取到菜品详情列表
            for(Order order:orders){
                //获取菜品的名字
                Dishes dishes = dishesMapper.queryDishesByDid(order.getDid());
                DI di = new DI(dishes.getDid(),dishes.getDname(),dishes.getDprice(),order.getQuantity(),order.getPayment());
                //往列表中添加数据
                dis.add(di);
                total = total + order.getPayment();
                //如果当前订单未完成，则将flag往上加个一
                if(order.getOstatus() == 1){
                    flag = flag + 1;
                }
            }
            //订单状态
            Integer status = 2;
            //用于判断当前订单的状况0为全部完成，1为部分完成，2位全部未完成
            if(flag == 0){
                //订单全部完成
                status = 0;
            }else if(flag == orders.size()){
                //订单全部未完成
                status = 2;
            } else {
                //订单部分完成
                status = 1;
            }
            OR or = new OR(ou.getOrderid(),user.getUname(),dis,total,ou.getDate(),status);
            //往列表中添加数据
            ors.add(or);
        }
        return ors;
    }

    @Override
    @Transactional
    public List<OR> queryOrderBySid(Integer sid,Integer page,Integer pagesize) {
        List<OS> oss = osMapper.queryOS(sid,page,pagesize);
        Shop shop = shopMapper.queryShopBySid(sid);
        List<OR> ors = new ArrayList<>();
        for(OS os : oss){
            List<Order> orders = orderMapper.queryOrderByOrderid(os.getOrderid());
            List<DI> dis = new ArrayList<>();
            Integer total = 0;
            Integer flag = 0;
            for(Order order:orders){
                Dishes dishes = dishesMapper.queryDishesByDid(order.getDid());
                DI di = new DI(dishes.getDid(),dishes.getDname(),dishes.getDprice(),order.getQuantity(),order.getPayment());
                dis.add(di);
                total = total + order.getPayment();
                if(order.getOstatus() == 1){
                    flag = flag + 1;
                }
            }
            Integer status = 2;
            if(flag == 0){
                status = 0;
            }else if(flag == orders.size()){
                status = 2;
            } else {
                status = 1;
            }
            OR or = new OR(os.getOrderid(),shop.getSname(),dis,total,os.getDate(),status);
            //往列表中添加数据
            ors.add(or);
        }
        return ors;
    }

    @Override
    public Integer changeOrderStatus(Integer did,String orderid) {
        Integer i = orderMapper.changeOrderStatus(did,orderid);
        return i;
    }
}
