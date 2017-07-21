package me.ilcb.aop;

import me.ilcb.aop.reflect.IUserService;
import me.ilcb.aop.reflect.JdkProxy;
import me.ilcb.aop.reflect.UserServiceImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by Jasper on 2017/4/11.
 */
public class JdkProxyTest {
    @Test
    public void test(){
        //创建目标对象
        IUserService target = new UserServiceImpl();
        //将目标类和横切类编织在一起
        JdkProxy handler = new JdkProxy(target);

        //创建代理实例，它可以看作是目标对象增加了横切代码(方法)的一个子类
        //创建代理实例(使用Proxy类和自定义的调用处理逻辑(handler)来生成一个代理对象)
        IUserService proxy = (IUserService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), //目标对象的类加载器
                target.getClass().getInterfaces(), //方法
                handler
        );

        proxy.addUser();
        proxy.deleteUser();
    }
}