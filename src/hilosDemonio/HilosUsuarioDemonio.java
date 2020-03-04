package hilosDemonio;

import java.util.Random;

public class HilosUsuarioDemonio {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            new HilosDU().start();
         /*   Thread t = new HilosDU();
            t.setDaemon(true);
            t.start();*/
        }
        Thread.sleep(3_000);
        System.out.println("FIN DE PROGRAMA ###################");
    }
}

class HilosDU extends Thread {
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(new Random().nextInt(2_000));
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}