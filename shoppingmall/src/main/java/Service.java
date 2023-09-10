
public class Service {
    private storedata stores[] ;//定义一个数组用来存放商品属性
    private int storeNums = 1;//记录当前有多少个商品信息
    private int idCounter = 1;//记录当前商品信息的id数


    public Service(int size) {
        //通过创建StoreService对象，指定数组大小
        stores = new storedata[size];
        //初始化商品属性
        stores[0] = new storedata(1,"苹果", "8元/斤", "A排1柜", 120, 100);
        stores[1] = new storedata(2,"薯片", "5元/袋", "B排1柜", 90, 200);
        stores[2] = new storedata(3,"卫龙", "2元/袋", "C排1柜", 180, 381);

    }

    public storedata findById(int findId){

        //遍历stores[]，看是否存在输入的编号存在则返回store对象 否则返回null
        for (int i = 0; i < storeNums; i++) {
            if(findId == stores[i].getId()){
                return stores[i];
            }
        }
        return null;
    }



    public boolean add(storedata newStore){
        //判断是否还可以继续添加
        if(storeNums == stores.length){
            System.out.println("商品已满，不能在添加了");
            return false;
        }
        stores[storeNums++] = newStore;
        newStore.setId(++idCounter);
        return true;//添加完成，返回true
    }


    public boolean del(int delId){
        int index = -1;//记录删除过程
        for (int i = 0; i < storeNums; i++) {
            if(delId  == stores[i].getId()){//如果在数组中找到要删除的id
                index = i;//把下标赋给index
            }
        }
        if(index == -1){//若index还是-1证明在数组中没找到要删除id的商品
            return false;
        }
        for (int i = index; i < storeNums - 1; i++) {
            stores[i] = stores[i+1];//把找到的商品去掉下标后面的商品前移
        }
        stores[--storeNums] = null;//去掉了一个元素，将原来的商品数组最后一个元素设为空
        return true;//删除完成
    }

    public storedata[] list(){
        return stores;
    }

}


