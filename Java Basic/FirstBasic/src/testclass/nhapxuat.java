package testclass;
//định nghĩa class nhapxuat nằm trong package testclass, package testclass phải là 1 thư mục 
//có các file class java bên trong

import java.util.Scanner;

public class nhapxuat {
    public static void main(String[] args) {
        String ten;
        Scanner scanner = new Scanner(System.in);//scanner sẽ xử lý input vì System.in là chuẩn
        //đầu vào java, còn System.out là chuẩn đầu ra, còn System.err dùng báo lỗi 
        System.out.println("Input your name: "); // hiển thị dòng thông báo và xuống dòng
        ten = scanner.nextLine();//input trong 1 dòng trên console
        scanner.close();
        System.out.println("\\Welcome " + ten);
    }
}