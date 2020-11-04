import java.util.concurrent.BlockingQueue;

public class SpecialistThread extends Thread {

    BlockingQueue queue;
    private final int WAIT_TIME = 5000;
    private final int PROCESSING_TIME = 4000;

    public SpecialistThread(String name, BlockingQueue queue) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " онлайн...");

        while (true) {
            if (queue.isEmpty()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " ждет звонка...");
                    Thread.sleep(WAIT_TIME);
                    if (queue.isEmpty()) {
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    System.out.println(Thread.currentThread().getName() + " взял запрос в работу..." + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    Thread.sleep(PROCESSING_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " обработал запрос!");
            }
        }
        System.out.println(Thread.currentThread().getName() + " на сегодня закончил...");
    }
}