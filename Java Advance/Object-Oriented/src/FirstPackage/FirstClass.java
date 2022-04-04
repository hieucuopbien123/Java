package FirstPackage;

public class FirstClass {
    private String name;
    //hàm tạo mặc định có trong Java, nhưng nếu ta định nghĩa bất kỳ 1 loại hàm tạo nào trong
    //class thì hàm tạo mặc định sẽ k tự được tạo ra nx mà ta phải tự code nó nếu vẫn muốn có hàm tạo mặc dịnh
    public FirstClass() { }
    public FirstClass(String name) {
        System.out.println("Your name: " + name);
    }
    public static void nhapCoDoiSo(String str) {//gọi trong main phải có static vì gọi đến hàm chính nó
        System.out.println(str);
    }
    public static int tinhTong(int a, int b) {
        return a + b;
    }
    
    public static void main(String[] args) {
        FirstClass firstClass = new FirstClass("Hieu");//main của lớp khởi tạo lớp luôn
        int c = tinhTong(3, 5);
        nhapCoDoiSo(String.valueOf(c));
    }
}