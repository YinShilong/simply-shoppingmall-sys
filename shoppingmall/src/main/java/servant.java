import java.util.ArrayList;
import java.util.Scanner;
public class servant {
    Scanner sc=new Scanner(System.in);
    String name;
    String password;
    String grade;
    String data;
    int money=0;
    public void visit()
    {
        System.out.println("账号"+name);
        System.out.println("密码"+password);
        System.out.println("用户等级"+grade);
        System.out.println("注册日期"+data);
    }
    public void changepassword()
    {
        System.out.println("新密码");
        password=sc.next();
    }

    public void close()
    {
        System.out.println("已退出");
        System.exit(0);
    }
}