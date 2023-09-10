
public class storedata {
    //定义变量
    public int id;//编号
    public String name;//名称
    public String price;//价格
    public String address;//位置
    public int date;//条码
    public int stock;//库存



    public storedata(int id, String name, String price, String address, int date, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.address = address;
        this.date = date;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //重写toString方法便于输出对象信息
    //编号  名称  价格  位置  条码  库存
    @Override
    public String toString(){
        return id + "\t\t" + name + "\t\t" + price + "\t\t" + address + "\t\t" + date + "\t\t" + stock;
    }
}
