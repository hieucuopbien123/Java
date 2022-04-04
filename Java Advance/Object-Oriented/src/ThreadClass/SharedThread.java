package ThreadClass;

public class SharedThread implements Runnable {
    private int shareVariable = 0;//dùng chung thuộc tính giữa các luồng
    public int getShareVariable() {
        return shareVariable;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("ID:" + Thread.currentThread().getId() + 
                    ", Name: " + Thread.currentThread().getName()
                    + ", shareVariable = " + shareVariable);
            shareVariable += 2;
        }
    }

    public static void main(String[] args){
        SharedThread sharedThread = new SharedThread();
        Thread thread0 = new Thread(sharedThread);
        thread0.setName("Luong 1");
        thread0.start();

        Thread thread1 = new Thread(sharedThread);
        thread1.setName("Luong 2");
        thread1.start();

        System.out.println("Gia tri thuoc tinh shareVariable = " + sharedThread.getShareVariable());
    }
}