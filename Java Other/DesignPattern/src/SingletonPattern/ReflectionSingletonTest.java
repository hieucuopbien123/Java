package SingletonPattern;

import java.lang.reflect.Constructor;

public class ReflectionSingletonTest {
    public static void main(String[] args) {
        eagerInitialization instanceOne = eagerInitialization.getInstance();
        eagerInitialization instanceTwo = null;
        try {
            Constructor[] constructors = eagerInitialization.class.getDeclaredConstructors();
            System.out.println(constructors.length);
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                instanceTwo = (eagerInitialization) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());//hash code khác nhau
        //Ở đây ta implement là instanceOne là global instance. Xong duyệt tất cả các hàm constructor của class và 
        //khởi tạo instanceTwo là theo tất cả các kiểu constructor của nó. Tức nó là local instance thôi
    }
}
//Cách này ý bảo là 1 class chuyên dùng cho singleton mà lại có thể tạo instance cho nó thế là k đúng ý, họ
//nghĩ thêm 1 cách nx dùng class chỉ cho singleton mà k thể tọa instance cơ -> Enum