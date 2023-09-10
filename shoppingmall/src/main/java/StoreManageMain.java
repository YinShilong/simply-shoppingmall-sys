import java.util.Scanner;

public class StoreManageMain {
    public static void main(String[] args) {
        System.out.println("选择你的职业,1为管理,2为客户");
        Scanner sc = new Scanner (System.in);
       int i=i=sc.nextInt();
        if (i == 1) {
            System.out.println("\t\t\t后台管理系统");
            new View().mainMenu();
            System.out.println("\n已退出商品管理系统");
        }
        if (i ==2){
            System.out.println("\t\t\t购物系统");
            new View().listStore();
            new View().buyDate();
            new View().exit();
            System.out.println("\n已退出购买系统");
        }
    }
}

