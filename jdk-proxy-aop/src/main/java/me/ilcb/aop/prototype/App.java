package me.ilcb.aop.prototype;

/**
 * Created by Jasper on 2017/5/17.
 */
public class App {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new GreetingImpl());
        proxy.sayHello("aaa");
    }
}
