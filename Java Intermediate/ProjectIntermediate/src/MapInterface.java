import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapInterface {
    //HashMap thì thứ tự các phần tựu k dựa theo thứ tự lúc thêm vào
    //LinkedHashMap thì thứ tự phần tự dựa theo thứ tự lúc thêm vào
    //TreeMap thì sắp xếp tăng dần key
    //key của Map k bao h bị trùng nên có thể lưu key bằng 1 Set
        
    public static void main(String[] args){
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(0, "Zero");
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(2, "Two");
        System.out.println(treeMap);

        //chuyển Map sang Set lưu dạng Entry
        Set<Map.Entry<Integer, String>> setLanguages = treeMap.entrySet();
        System.out.println(setLanguages);
        //nếu ta: import java.util.Map.Entry; thì có thể dùng luôn Entry<Integer,String> mà k cần Map.Entry<>
        
        //Tuy nhiên kể từ Java8 thì ta có thể lấy toàn bộ các entry trong Map bằng forEach
        treeMap.forEach(
            (valueInt, valueStr) -> {
                System.out.println("Key = " + valueInt + ", value = " + valueStr);
            }//bỏ {;} nếu chỉ có 1 hàm như này
        );
        for (Integer key : treeMap.keySet()) {//chỉ lấy key
            System.out.println("Key = " + key);
        }
        for (String value: treeMap.values()) {
            System.out.println("Value = " + value);
        }

        //Iterator thì vẫn thông qua vc chuyển sang Set với entrySet, keySet. 
        //Còn values trả ra hẳn 1 Collection tùy kiểm là gì. Có thể 1 key gắn với 1 ArrayList cx được
        Iterator<Map.Entry<Integer, String>> iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println("Data: " + entry);
            System.out.println("Key-Val: " + entry.getKey() + "-" + entry.getValue());
            //gọi iterator.next() là con trỏ move đến vị trí next luôn k làm gì đc nx
            //Chú ý là iterator có thể lấy được giá trị key, value bằng cách lấy Map.Entry tùy ý chứ k chỉ duyệt k
        }
        Iterator<Integer> iterator1 = treeMap.keySet().iterator();
        Iterator<String> iterator2 = treeMap.values().iterator();

        System.out.println(hashMap.get(1));
        System.out.println(hashMap.containsValue("Zero"));//containsKey
        System.out.println(hashMap.remove(1));//trả ra value của key xóa or null nếu k có

        System.out.println(linkedHashMap.replace(0, "ZeroNine"));//trả ra value cũ của key
        System.out.println(linkedHashMap.replace(0, "ZeroNine", "Zero Nine"));//trả ra true false thành công không

        Map<Integer, String> mapCityCopy = new TreeMap<>();
        System.out.println(mapCityCopy.size());
        mapCityCopy.putAll(linkedHashMap);

        //str->char[]
        String str = "Hello world";
        char[] charStr = str.toCharArray();
        System.out.println(charStr);
    }
}
