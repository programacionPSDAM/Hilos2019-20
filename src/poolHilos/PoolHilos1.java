package poolHilos;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PoolHilos1 {
    public static void main(String[] args) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(cores);
        for (int i = 0; i < 30 ; i++) {
            pool.submit(new HilosPool());
        }
      //  Thread.sleep(3_000);
      //  pool.shutdownNow();
        pool.shutdown();

        System.out.println("FIN DE PROGRAMA ################");
    }
}

class HilosPool implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(2));
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
