package me.ilcb.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Jasper on 2017/4/11.
 */
public class CglibProxy implements MethodInterceptor {
    //增强器，动态代码生成器
    private Enhancer enhancer = new Enhancer();

    /**
     * 创建代理对象
     * @param clazz
     * @return 返回代理对象
     */
    public Object getProxy(Class clazz) {
        //设置目标类(被代理的类)
        enhancer.setSuperclass(clazz);
        //设置回调(在调用父类方法是，回调this.intercept())
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例(动态扩展了UserServiceImpl类)
        return enhancer.create();
    }

    /**
     * 拦截方法：在代理实例上拦截并处理目标方法的调用，返回结果
     * target:目标对象代理的实例;
     * method:目标对象调用父类方法的method实例;
     * args:调用父类方法传递参数;
     * methodProxy:代理的方法去调用目标方法
     */
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("--------测试intercept方法的四个参数的含义-----------");
        System.out.println("----------测试intercept方法参数的含义-----------");
        System.out.println("obj:" + target.getClass());
        System.out.println("method:" + method.getName());
        System.out.println("methodProxy:" + methodProxy.getSuperName());
        if (args != null && args.length > 0) {
            for (Object value : args) {
                System.out.println("args:" + value);
            }
        }

        //目标方法之前执行
        System.out.println("do sth Before...");
        //目标方法调用
        //通过代理类实例调用父类的方法，即是目标业务类方法的调用
        Object result = methodProxy.invokeSuper(target, args);
        //目标方法之后执行
        System.out.println("do sth After...\n");
        return result;
    }
}
