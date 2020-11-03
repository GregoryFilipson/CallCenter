import java.util.Queue;

public class SpecialistThread extends Thread {

    Queue queue;
    private final int DRINK_COFFEE = 4000;
    private final int PROCESSING_TIME = 4000;

    public SpecialistThread(String name, Queue queue) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " онлайн...");
        try {
            Thread.sleep(DRINK_COFFEE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            if (!queue.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + " взял запрос в работу...");
                try {
                    Thread.sleep(PROCESSING_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.poll();
                System.out.println(Thread.currentThread().getName() + " обработал запрос!");
            } else {
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " на сегодня закончил...");
    }
}
