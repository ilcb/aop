package com.spring.aop;

import me.ilcb.aop.CglibProxy;
import me.ilcb.aop.IUserService;
import me.ilcb.aop.UserServiceImpl;
import org.junit.Test;

/**
 * Created by Jasper on 2017/4/11.
 */
public class CglibProxyTest {
    @Test
    public void test() {
        CglibProxy proxy = new CglibProxy();
        //通过java.lang.reflect.Proxy的getProxy()动态生成目标业务类的子类，即代理类，再由此得到代理实例
        //通过动态生成子类的方式创建代理类
        IUserService target = (IUserService) proxy.getProxy(UserServiceImpl.class);
        target.addUser();
        target.deleteUser();
    }
}