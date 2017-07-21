package me.ilcb.aop;

/**
 * Created by Jasper on 2017/4/11.
 */
public class UserServiceImpl implements IUserService {
    public void addUser() {
        System.out.println("新增一个用户");
    }
    public void deleteUser() {
        System.out.println("删除一个用户");
    }
}
