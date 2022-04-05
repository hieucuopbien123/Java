package SingletonPattern;

public class lazyInit {
    private static lazyInit instance;
    
    private lazyInit(){}
    
    public static lazyInit getInstance(){
        if(instance == null){
            instance = new lazyInit();
        }
        return instance;
    }
}
//dùng tốt trong môi trường đơn luồng nhưng nếu đa luồng sẽ có sự kế nếu nhiều luồng gặp
//if 1 lúc thì sẽ phá huy mẫu singleton