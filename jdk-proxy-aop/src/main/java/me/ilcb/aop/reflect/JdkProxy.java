package me.ilcb.aop.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Jasper on 2017/4/11.
 */
public class JdkProxy implements InvocationHandler {
    //被代理对象
    private Object target;

    //传递代理目标的实例
    public JdkProxy(Object target) {
        this.target = target;
    }

    /**
     * 覆盖java.lang.reflect.InvocationHandler的方法invoke()进行织入(增强)的操作。
     * 参数说明：
     * proxy是生成的代理对象，method是代理的方法，args是方法接收的参数
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //目标方法之前执行
        System.out.println("do something before");
        Object result = method.invoke(target, args);
        //目标方法之后执行
        System.out.println("do something after");
        return result;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
