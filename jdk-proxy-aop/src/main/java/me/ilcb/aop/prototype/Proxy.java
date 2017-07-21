package me.ilcb.aop.prototype;

/**
 * Created by Jasper on 2017/5/17.
 */
public class Proxy implements Greeting{
    private GreetingImpl greetingImpl;

    public Proxy(GreetingImpl greetingImpl) {
        this.greetingImpl = greetingImpl;
    }

    public void sayHello(String name) {
        before();
        greetingImpl.sayHello(name);
        after();
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
