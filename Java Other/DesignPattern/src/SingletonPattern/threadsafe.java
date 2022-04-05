package SingletonPattern;

public class threadsafe {
    private static threadsafe instance;
    
    private threadsafe(){}

    // public static synchronized threadsafe getInstance(){
    //     if(instance == null){
    //         instance = new threadsafe();
    //     }
    //     return instance;
    // }

    public static threadsafe getInstanceUsingDoubleLocking(){
        if(instance == null){
            synchronized (threadsafe.class) {
                if(instance == null){
                    instance = new threadsafe();
                }
            }
        }
        return instance;
    }

}
//khắc phục lỗi nhưng nó chậm và tốn hiệu năng
//Nó cải tiến bằng cách dùng synchronized cho đoạn code cần thiết thôi chứ kp cả hàm để tăng hiệu năng. VD ban 
//đầu 2 thread cùng gọi getInstance dù 1 cái instance==null, 1 cái instance!=null sẽ phải chờ. Bh 2 thread cùng gọi và
//cùng chạy 1 lúc luôn => chỉ dùng thread safe cho đoạn code quan trọng
//cú pháp: synchronized(<class nào>){<code chỉ được chạy bởi 1 thread trong class đó>}