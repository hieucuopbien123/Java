package person;

public class hsLopLy extends Male {
    //k được ghi đè static, constructor hay final. tên và params các thứ phải như nhau. access_modifier của
    //con phải có khả năng truy cập >= cha. VD cha là default thì con phải là default or public -> overriding
    //nên có @Override ở đầu khi chủ đích muốn override
    @Override
    public void learn(){
        System.out.println("Hoc Ly nào");
    }
}
