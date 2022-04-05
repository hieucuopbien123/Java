package SingletonPattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SerializedSingletonTest {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        SerializationAndSingleton instanceOne = SerializationAndSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));//write file nào
        //ObjectOutputStream xác định viết vào 1 output stream nào và ở đây là FileOutputStream
        out.writeObject(instanceOne);//write object vào stream nào. Write cái mẹ gì cx được, ở đây là global instance
        //1 class luôn
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        SerializationAndSingleton instanceTwo = (SerializationAndSingleton)in.readObject();
        //đọc từ file ra object mà ta vừa lưu global instance vào ấy
        in.close();
        //lưu object vào stream r lấy ra ez

        System.out.println("First hashCode: " + instanceOne.hashCode());
        System.out.println("Second hashCode: " + instanceTwo.hashCode());
        //đương nhiên vì nó tạo ra 1 class object mới mà chứ hashCode là địa chỉ vùng nhớ tức 2 biến phải cùng vùng
        //nhớ cơ
    }
}