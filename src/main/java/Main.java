public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtsThread atsThread = new AtsThread();
        SpecialistThread specialistThread = new SpecialistThread("Семен", atsThread.getCallQueue());
        SpecialistThread specialistThread2 = new SpecialistThread("Иван", atsThread.getCallQueue());
        SpecialistThread specialistThread3 = new SpecialistThread("Артем", atsThread.getCallQueue());

        atsThread.start();

        specialistThread.start();
        specialistThread2.start();
        specialistThread3.start();

        specialistThread.join();
        specialistThread2.join();
        specialistThread3.join();

        atsThread.interrupt();
    }
}
