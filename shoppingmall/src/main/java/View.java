import javax.sound.midi.VoiceStatus;



public class View {

    private int key;//存储选项
    private boolean loop = true;//定义界面循环参数,当loop=false时，退出循环。
    private Service storeService = new Service(5);


    public void mainMenu() {//因为菜单界面至少出现一次，所以我们选择dowhile循环
        do {//主菜单栏的编写
            System.out.println("***********商店商品管理系统***********");
            System.out.println("\t\t\t1 商品列表");
            System.out.println("\t\t\t2 查找商品");
            System.out.println("\t\t\t3 添加商品");
            System.out.println("\t\t\t4 删除商品");
            System.out.println("\t\t\t5 修改商品属性");
            System.out.println("\t\t\t6 退出系统");
            System.out.println("***********************************");
            System.out.print("请输入选项(1-6): ");
            key = Utils.readInt();
            switch (key) {//因为选择的选项不多也可以使用多重if语句，这里我选择使用switch语句
                case 1:
                    listStore();
                    break;
                case 2:
                    findStore();
                    break;
                case 3:
                    addStore();
                    break;
                case 4:
                    delStore();
                    break;
                case 5:
                    upDate();
                    break;
                case 6:
                    exit();
                    break;
                default:
                    System.out.println("您的选择有误，请重新选择\n");
                    break;

            }

        } while (loop);
    }

    //为了代码的可阅读性，我们这里将每个功能的实现都写在不同的方法里面
    //商品列表
    public void listStore() {
        System.out.println("............商品信息............");
        System.out.println("编号\t\t名称\t\t价格\t\t\t位置\t\t\t条码\t\t库存");
        storedata[] stores= storeService.list();
        for(int i = 0; i < stores.length; i++) {
            if (stores[i] == null) {
                break;
            }
            System.out.println(stores[i]);
        }
        System.out.println("........商品信息显示完毕........\n");
    }
    //根据id查找商品
    public void findStore() {
        System.out.println("..........查找商品信息..........");
        System.out.print("请输入要查找的id: ");
        int findId = Utils.readInt();

        storedata store = storeService.findById(findId);
        if(store != null){
            System.out.println(store);
        }else{
            System.out.println("......此编号的商品不存在......\n");
        }
    }
    //添加商品
    public void addStore() {
        System.out.println("........添加商品信息........");
        System.out.println("名称: ");
        String name = Utils.readString(8);
        System.out.println("价格: ");
        String price = Utils.readString(10);
        System.out.println("位置: ");
        String address = Utils.readString(14);
        System.out.println("条码: ");
        int date = Utils.readInt(6);
        System.out.println("库存: ");
        int stock = Utils.readInt(5);
        storedata newStore = new storedata(0, name, price, address, date, stock);
        if(storeService.add(newStore)){
            System.out.println("........添加商品成功........\n");
        }
        else {
            System.out.println("........添加商品失败........\n");
        }
    }
    //删除商品
    public void delStore () {
        System.out.println("........删除商品信息........");
        System.out.print("请输入待删除的商品编号(-1退出): ");
        int delId = Utils.readInt();
        if(delId == -1){
            System.out.println("........退出删除商品........\n");
            return;
        }
        char choose = Utils.readConfirmSelection();
        if(choose == 'Y'){
            if(storeService.del(delId)){
                System.out.println("........删除商品成功........\n");
            }
            else {
                System.out.println("........商品id不存在........\n");
            }
        }else{
            System.out.println("退出删除商品\n");
        }

    }
    //修改商品属性
    public void upDate () {
        System.out.println("........修改商品信息........");
        System.out.print("请输入待修改的商品编号(-1退出): ");
        int updateId = Utils.readInt();
        if(updateId == -1){
            System.out.println("退出修改商品");
            return;
        }
        //因为之前查找商品id的时候编写过findById发法，可以直接调用
        storedata store = storeService.findById(updateId);
        if(store == null){
            System.out.println("........修改商品id不存在........");
            return;
        }
        System.out.println("名称(" + store.getName() + "): ");
        String name = Utils.readString(8, "");
        //若不修改，则保持原始数据
        if(!"".equals(name)){
            store.setName(name);
        }//修改商品名称

        System.out.println("价格(" + store.getPrice() + "): ");
        String price  = Utils.readString(10, "");
        //若不修改，则保持原始数据
        if(!"".equals(price)){
            store.setPrice(price);
        }

        System.out.println("位置(" + store.getAddress() + "): ");
        String address = Utils.readString(14, "");
        //若不修改，则保持原始数据
        if(!"".equals(address)){
            store.setAddress(address);
        }//修改商品名称

        System.out.println("条码(" + store.getDate() + "): ");
        int date= Utils.readInt(-1);
        //若不修改，则保持原始数据
        if(date != -1){
            store.setDate(date);
        }

        System.out.println("库存(" + store.getStock() + "): ");
        int stock  = Utils.readInt(-1);
        //若不修改，则保持原始数据
        if(stock != -1){
            store.setStock(stock);
        }
        System.out.println("........修改商品信息成功........\n");

    }
    public void buyDate () {
        System.out.println("........购买商品信息........");
        System.out.print("请输入待购买的商品编号(-1退出): ");
        int updateId = Utils.readInt();
        if(updateId == -1){
            System.out.println("退出购买商品");
            return;
        }
        //因为之前查找商品id的时候编写过findById发法，可以直接调用
        storedata store = storeService.findById(updateId);
        if(store == null){
            System.out.println("........购买商品id不存在........");
            return;
        }
        System.out.println("名称(" + store.getName() + "): ");
        String name = Utils.readString(8, "");
        //若不修改，则保持原始数据
        if(!"".equals(name)){
            store.setName(name);
        }//修改商品名称

        System.out.println("价格(" + store.getPrice() + "): ");
        String price  = Utils.readString(10, "");
        //若不修改，则保持原始数据
        if(!"".equals(price)){
            store.setPrice(price);
        }

        System.out.println("位置(" + store.getAddress() + "): ");
        String address = Utils.readString(14, "");
        //若不修改，则保持原始数据
        if(!"".equals(address)){
            store.setAddress(address);
        }//修改商品名称

        System.out.println("条码(" + store.getDate() + "): ");
        int date= Utils.readInt(-1);
        //若不修改，则保持原始数据
        if(date != -1){
            store.setDate(date);
        }

        System.out.println("库存(" + store.getStock() + "): ");
        int stock  = Utils.readInt(-1);
        //若不修改，则保持原始数据
        if(stock != -1){
            store.setStock(stock);
        }
        System.out.println("........购买商品信息成功........\n");

    }
    //退出系统
    public void exit () {
        //当用户需要退出系统的时候，我们可以给一个确认退出指令，直接调用工具类utils里的方法
        char choose = Utils.readConfirmSelection();//该方法输出的结果为Y或者N
        if (choose == 'Y') {
            loop = false;//当loop = false时退出菜单循环
        }
    }
}

