package multiThreading02;

public class WaitNotify {
    static public double bakiye = 0;
    public static void main(String[] args) {
        WaitNotify obj = new WaitNotify();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.paracekme(800);
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.parayatirma(2000);
            }
        });
        thread2.start();
    }
    public void paracekme(double miktar) {
        synchronized (this) {
            if (bakiye <= 0 || bakiye < miktar) {
                try {
                    System.out.println("hesaba para yatirilmasi gerekiyor...");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        bakiye = bakiye - miktar;
        System.out.println("Para cekme basarili.\n Guncel bakiyemiz: " + bakiye);
    }
    public void parayatirma(double miktar){
        bakiye = bakiye + miktar;
        System.out.println("Bakiyemiz guncellendi.\nGuncel bakiyemiz: " + bakiye);
        synchronized (this) {
            notify();
        }
    }
}