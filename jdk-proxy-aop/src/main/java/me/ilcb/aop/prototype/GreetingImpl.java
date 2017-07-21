package me.ilcb.aop.prototype;

public class GreetingImpl implements Greeting{
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}
