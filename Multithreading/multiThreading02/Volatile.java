package multiThreading02;

// Volatile durumunda thread'in objeye bağımlılığı söz konusudur.
public class Volatile {
    volatile public static int flag = 0;
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (flag == 0) {
                        System.out.println("thread1 calisir durumda...");
                    } else {
                        break;
                    }
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = 1;
                System.out.println("flag variable inin degeri guncellendi");
            }
        });
        thread2.start();
    }
}

