import java.util.ArrayList;
import java.util.Scanner;
public class loginservant {
    Scanner s = new Scanner(System.in);
    public int login(servant st[]) {
        boolean flag = false;
        int i=0;
        String a;
        String b;
        System.out.println("欢迎进入登录页面");
        System.out.println("请输入你的账号");
        a = s.next();
        System.out.println("请输入你的密码");
        b = s.next();
        while(i<5)
        {
            if(a.equals(st[i].name)&&b.equals(st[i].password))
            {
                flag=true;
                break;
            }
            i++;
        }
        if (flag)
        {
            System.out.println("恭喜你登录成功!");
        } else
        {
            System.out.println("密码错误，请重新进行登录!");
            return 6;
        }
        return i;
    }
    public void sign(servant st[]) {
        System.out.println("开始注册");
        System.out.println("输入账号");
        String m = s.next();
        System.out.println("输入密码");
        String n = s.next();
        servant s=new servant();
        int i = 0;
        s.name=m;
        s.password=n;
        if (st[i] != null)
            i++;
        st[i] = s;
        //System.out.println(i);
        System.out.println("恭喜你注册成功!");

    }
    public void changepassword(servant s)
    {
        s.changepassword();
    }
}
