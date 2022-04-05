package SingletonPattern;

public class BillPughSingleton {
    private BillPughSingleton(){
        System.out.println("Call constructor");
    }
    
    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
        //khi gọi getInstance thì BillPughSingleton() mới được gọi
    }
    
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
//Khi có quá nhiều luồng lấy data thì các cách tiếp cận trước không tốt cho hiệu năng 
//BillPugh tạo singleton băng cách sử dụng 1 lớp trợ tĩnh bên trong
//Cũng giống như ta tạo ra 1 static class SingletonHelper dùng global chỉ ở trong phạm vi class này 
//xong bên trong SingletonHelper có 1 biến Instance là khởi tạo của class. Để tăng hiệu suất rất đơn giản
//ta chỉ cần khiến cho mỗi khi gọi getInstance thì biến mới được tạo ra khi mới gọi lần đầu tiên. Còn các lần
//sau lấy cái đã từng tạo ra sẵn kèm với 1 điều kiện là mọi luồng truy cập được thoải mái

//Tại sao cách này thỏa mãn: bản chất các thứ static được khai báo khi ta chủ ý khai báo nó hoặc dùng nó lần đầu
//tiên, còn các lần sau nó tự dùng lại cái cũ. Nếu ta k dùng thì dù class là static và ta import vào nó vẫn k tự 
//tạo ra global instance. Ta lợi dụng điều này. Ở đây khi ta k dùng thì k có gì, khi ta dùng thì gọi vào
//setInstance thì gọi SingletonHelper lần đầu sẽ khởi tạo 1 instance của nó có biến INSTANCE. Các lần sau sẽ dùng tiếp
//và nó là biến global của BillPughSingleton do nó là static trong class này, thông qua getInstance nó lại thành global
//của chương trình dùng BillPughSingleton nên ok.