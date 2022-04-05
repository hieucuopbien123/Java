package SingletonPattern;

public enum EnumSingleton {
    INSTANCE;
    
    public static void doSomething(){
        //do something
    }
}
//Enum đảm bảo chỉ được khởi tạo 1 lần trong 1 chương trình java và các giá trị của nó luôn là global
//Nhưng nó k linh hoạt. Vd k cho phép khởi tạo eager init