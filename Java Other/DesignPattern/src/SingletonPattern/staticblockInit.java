package SingletonPattern;

public class staticblockInit {
    private static staticblockInit instance;
    
    private staticblockInit(){}
    
    static{
        try{
            instance = new staticblockInit();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static staticblockInit getInstance(){
        return instance;
    }
}
//đã xử lý ngoại lệ nhưng vẫn tự động tạo dù có thể k cần dùng. Cục trong static{<>} sẽ thực hiện khi chạy tới