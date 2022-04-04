package String;

import java.util.Arrays;

public class First {
    public static void main(String[] args) {
        String str1 = "a::b::c::d:e";
        String result[] = str1.split("::");
        //1 là regexp tách ra, 2 là số lượng max con muốn tách, nếu k truyền 2 sẽ tách toàn bộ con
        System.out.println("Res: " + Arrays.toString(result));

        System.out.println(str1.contains("a::b"));
        System.out.println("Hello".toLowerCase());
        System.out.println("Hello".startsWith("He"));//endsWith
    }
}
