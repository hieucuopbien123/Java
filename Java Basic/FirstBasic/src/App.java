import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello\n World!");//sysout

        String result;
        result = JOptionPane.showInputDialog("Please enter your name: ");
        JOptionPane.showMessageDialog(null, "Hello " + result + "\n");

        String strNum1;
        String strNum2;
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number", "Input a number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number", "Input a number", JOptionPane.INFORMATION_MESSAGE);
        double d1 = Double.parseDouble(strNum1);
        double d2 = Double.parseDouble(strNum2);
        JOptionPane.showMessageDialog(null, "Show difference: " + ((d1 > d2) ? (d1 - d2) : (d2 - d1)), "Show cal"
            , JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
// tên package nen viết thường còn tên class bắt đầu bằng chữ viết hoa