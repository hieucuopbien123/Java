package public_accessmodifier;

import person.Person;

public class Student {
    void hienThiTenLop() {
        System.out.println("Default access modifier only be called from same package");
    }
    private int pivVar = 10;
    public static void main(String[] args) {
        // Do ClassOfStudent thuộc cùng package mà public nên truy cập được ở mọi lớp, nhưng nếu ClassOfStudent
        //mà thuộc 1 package khác thì dù public ta cx phải import class đó vào class này để dùng
        Person person = new Person();
        person.showInformation();

        ClassOfStudent classOfStudent = new ClassOfStudent();
        classOfStudent.inputYourClass();
        classOfStudent.showInformation();

        Student stu = new Student();
        stu.hienThiTenLop();
        System.out.println(stu.pivVar);
    }
}
//hàm main nó như kiểu 1 hàm tách rời cùng package ấy chứ éo phải 1 phương thức của class.Class nào cx có hàm main đc
//Nhưng gọi hàm main lại giống như gọi phương thức nên truy cập vào private được
