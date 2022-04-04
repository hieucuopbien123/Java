package Exception;

class MyException extends Exception{
    String str1;
    MyException(String str2) {
        str1 = str2;
    }
    public String toString(){ 
        return ("MyException Occurred: " + str1) ;
    }
    // Or dùng: public MyException(String s){ super(s); } cx ok
}

class SecondClass{//package k cần thiết trùng tên
    void check(int weight) throws MyException {
        if(weight < 100) {
            throw new MyException("Invalid Weight");//khi throw mà k có handle thì phải thêm throws ở hàm
            //tức khi dùng throw ở 1 hàm riêng như này ấy
        }
    }
    public static void main(String args[]){
        SecondClass secondClass = new SecondClass();
        try{
            secondClass.check(19);
            throw new MyException("This is My error Message");
        }
        catch(MyException exp){
            System.out.println(exp);//tự gọi toString
        }
    }
    //ArrayIndexOutOfBoundsException là lỗi truy xuất phần tử ngoài phạm vi của mảng
    //NumberFormatException nếu ép kiểu string sang kiểu số nào đó k thể ép đươc. VD: Integer.parseInt("XY");
    //NullPointerException khi tham chiếu đến Object nhưng lại k có vị trí nào trên bộ nhớ(null)
    /*try{
		String str=null;
		System.out.println(str.length());
	}catch(NullPointerException e){
		System.out.println("NullPointerException");
	} */
}