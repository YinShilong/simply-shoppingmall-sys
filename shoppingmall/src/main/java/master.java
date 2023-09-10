import java.util.ArrayList;
import java.util.Scanner;

public class master {
    Scanner sc = new Scanner(System.in);
    String name = "yushe123";
    String password = "123456";
    boolean flag;

    public boolean login() {
        String a;
        String b;
        boolean flag = false;
        System.out.println("请输入你的账号");
        a = sc.next();
        System.out.println("请输入你的密码");
        b = sc.next();
        if (a.equals(name) && b.equals(password))
            flag = true;
        else
            flag = false;

        if (flag) {
            System.out.println("恭喜你登录成功!");
        } else {
            System.out.println("密码错误");
        }
        return flag;
    }

    public void changemyself() {
        System.out.println("输入新密码");
        password = sc.next();
    }

    public void list(servant s) {
        s.visit();
    }

    public void changeservant(servant s) {
        s.password = "null";
        System.out.println("密码已重置");
    }
    public void close()
    {
        System.out.println("退出登录");
        System.exit(0);
    }
}
