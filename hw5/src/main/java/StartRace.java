import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class StartRace {
    public static final int COUNT_CARS = 4;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!");
        Semaphore semaphore = new Semaphore(COUNT_CARS / 2);
        CyclicBarrier finishCB = new CyclicBarrier(COUNT_CARS + 1);
        AtomicInteger aI = new AtomicInteger(0);
        Race race = new Race(new Road(60, null, aI), new Tunnel(semaphore), new Road(40, finishCB, aI));
        CountDownLatch countDownLatch = new CountDownLatch(COUNT_CARS + 1);
        countDownLatch.countDown();
        Car[] cars = new Car[COUNT_CARS];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), countDownLatch);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            Thread.sleep(500);
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась !!!");
        try {

            finishCB.await();
            Thread.sleep(1000);
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась !!!");
    }
}
