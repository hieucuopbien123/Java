package testinterface;

//từ khóa public ở đây xác định interface này dùng được public mọi package, nếu k khai báo nó sẽ chỉ được 
//dùng bên trong package chứa nó
public interface InterfaceCha {
    //các thuộc tính mặc định là hằng số mà k cần khai báo static final
    Double PI = 3.14;

    //các phương thức mặc định là public mà k cần viết từ khóa public
    void createAbstractMethod();
}
