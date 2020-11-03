import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class AtsThread extends Thread {

    private Queue<Call> callQueue = new LinkedBlockingQueue<>();
    private final int NUMBER_CALLS = 5;
    private final int LIMIT_CALLS = 10;
    private final int TIME_LOADING_ATS = 3000;


    public Queue<Call> getCallQueue() {
        return callQueue;
    }

    @Override
    public void run() {
        while (callQueue.size() < LIMIT_CALLS) {
            try {
                Thread.sleep(TIME_LOADING_ATS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < NUMBER_CALLS; i++) {
                Call call = new Call();
                callQueue.offer(call);
                System.out.println("Поступил новый звонок от " + call.generatePhoneNumber());
            }
        }
        System.out.println("Очередь заполнена... Пойду позову еще операторов...");
    }
}
