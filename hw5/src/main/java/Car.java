import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private static int CAR_COUNT;
    private Race race;
    private int speed;
    private String name;
    private CountDownLatch countDownLatch;

    public Car(Race race, int speed, CountDownLatch cdl) {
        this.race = race;
        this.speed = speed;
        CAR_COUNT++;
        name = "Участник № " + CAR_COUNT;
        countDownLatch = cdl;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " готовиться");
            countDownLatch.countDown();

            System.out.println(name + " готов");
            countDownLatch.await();
            Thread.sleep(500 + (int) (Math.random() * 800));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
    }
}
