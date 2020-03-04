package poolHilos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class HilosPool2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Future<List<Integer>> lista1 =
                pool.submit(new HilosCallable(100, 300));
        Future<List<Integer>> lista2 =
                pool.submit(new HilosCallable(300, 500));
        Future<List<Integer>> lista3 =
                pool.submit(new HilosCallable(500, 700));
        Future<List<Integer>> lista4 =
                pool.submit(new HilosCallable(700, 900));
        Future<List<Integer>> lista5 =
                pool.submit(new HilosCallable(900, 1100));
        lista1.get().forEach(System.out::println);
        lista2.get().forEach(System.out::println);
        lista3.get().forEach(System.out::println);
        lista4.get().forEach(System.out::println);
        lista5.get().forEach(System.out::println);
        pool.shutdown();

    }
}
class HilosCallable implements Callable {
    private int menor;
    private int mayor;

    public HilosCallable(int menor, int mayor) {
        this.menor = menor;
        this.mayor = mayor;
    }

    @Override
    public List<Integer> call() throws Exception {
        List<Integer> listaMultiplos7 = new ArrayList<>();
        for (int i = menor; i < mayor; i++) {
            if (i % 7 == 0)
                listaMultiplos7.add(i);
        }
        return listaMultiplos7;
    }
}