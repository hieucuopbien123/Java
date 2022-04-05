package Interview;

import java.io.Serializable;

public final class First implements Serializable {
    //từ khóa final xác định đây là implementation cuối cùng của class, method, var
    //Nên dùng để khai báo hso or 1 class mà k thể bị kế thừa bởi 1 class khác
    //1 immutable object là 1 object k thể đổi, ta có thể tạo ra bằng cách dùng private + final
    private void changeData(Integer a) {
        a = a + 1;
    }
    private void changeData2(int[] a) {
        a[0]++;
    }
    public static void main(String[] args){
        First first = new First();
        int b = 10;//hay Integer như nhau
        first.changeData(b);
        System.out.println(b);

        int[] c = {1,2,3};
        first.changeData2(c);
        System.out.println(c[0]);
        //giống hệt C++ về tham chiếu hay gì này nọ
    }
}
