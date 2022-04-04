package FIleHandling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;

public class First {
    public static void main(String[] args) {
        //mở và ghi
        FileOutputStream fos = null;
        File file = new File("./file.txt");
        String mycontent = "This is my Data which needs to be written into the file";
        try {
            file = new File("./file.txt");
            fos = new FileOutputStream(file);
            if (!file.exists()) {
                //file đc tạo ra bởi createnewFile thì return true, ngược lại file có sẵn sẽ trả ra false
                boolean fvar = file.createNewFile();
                if (fvar)
                    System.out.println("File has been created successfully");
                else{
                    System.out.println("File already present at the specified location");
                    return;
                }
            }
            //phải convert sang byte để gọi write của FileOutputStream
            byte[] bytesArray = mycontent.getBytes();
            fos.write(bytesArray);//xóa mọi thứ và ghi lại từ đầu
            fos.flush();
            System.out.println("File Written Successfully");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if(fos != null) 
                    fos.close();
            } catch (IOException ioe) {
                System.out.println("Error in closing the Stream");//cái éo gì với file cũng check
            }
        }
        //createNewFile trả ra IOException nếu có lỗi input/output trong quá trình tạo file
        //trả SecurityException nếu 1 trình bảo mật nào đó tồn tại và method SecurityManager.checkWrite(java.lang.String)
        //của nó từ chối quyền truy cập ghi vào file của chương trình này

        //ghi thêm
        try{
            String content = "This is my content which would be appended at the end of the specified file";
            FileWriter fw = new FileWriter(file, true);//tham số 2 là boolean append true thì append
            BufferedWriter bw = new BufferedWriter(fw);//dùng thêm BufferedWriter để ghi file tốc độ nhanh hơn
            bw.write(content);
            bw.close();//Closing BufferedWriter Stream
            System.out.println("Data successfully appended at the end of file");
        }catch(IOException ioe){
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }

        //cách tốt nhất để ghi thêm
        try{
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);//mọi thứ ghi vào PrintWriter sẽ ghi vào file
            pw.println("");//ghi 1 lần xuống dòng vào PrintWriter
            pw.println("This is first line");//ghi thêm 3 dòng
            pw.println("This is the second line");
            pw.println("This is third line");
            pw.close(); 
            System.out.println("Data successfully appended at the end of file");
        }catch(IOException ioe){
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }

        //đọc
        BufferedInputStream bis = null;
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(file);//FileInputStream to read the file

            //truyền FileInputStream vào BufferedInputStream để đọc nhanh bằng buffer array
            bis = new BufferedInputStream(fis);
            
            //available trả ra 0 nếu k còn byte nào trong file để đọc tiếp
            while( bis.available() > 0 ){             	
                System.out.print((char)bis.read());
            }
        }catch(FileNotFoundException fnfe){
            System.out.println("The specified file not found " + fnfe);
        }
        catch(IOException ioe){
            System.out.println("I/O Exception: " + ioe); 
        }finally{
            try{
                if(bis != null && fis!=null){
                    fis.close();
                    bis.close();
                }      
            }catch(IOException ioe){
                System.out.println("Error in InputStream close(): " + ioe);
            }
        }

        //xóa
        try{
            //xóa thành công return true, thất bại return false
            if(file.delete()){
                System.out.println(file.getName() + " is deleted!");
            }else{
                System.out.println("Delete failed: File didn't delete");
            }
        }catch(Exception e){
            System.out.println("Exception occurred");
            e.printStackTrace();
        }
    }
}
