import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Road extends Stage {
    private CyclicBarrier cyclicBarrier;
    AtomicInteger atomicInteger;

    public Road(int length, CyclicBarrier cb, AtomicInteger aI) {
        this.length = length;
        description = "Дорога " + length + " метров";
        cyclicBarrier = cb;
        atomicInteger = aI;
    }

    @Override
    public void go(Car car) {
        try {
            System.out.println(car.getName() + " начал этап: " + description);
            Thread.sleep(length / car.getSpeed() * 1000);
            System.out.println(car.getName() + " закончил этап: " + description);
            if (atomicInteger.get() == 4) {
                System.out.println(car.getName() + " WIN !!!");
            }
            atomicInteger.incrementAndGet();
            if (cyclicBarrier != null) {
                cyclicBarrier.await();
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
