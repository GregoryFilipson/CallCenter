import javax.xml.stream.events.DTD;

public class Call {
    private long maxValuePhoneNumber = 999999999;
    String phoneNumber;

    public Call() {
        phoneNumber = "+79" + (long) (Math.random() * ++maxValuePhoneNumber);
    }

    @Override
    public String toString() {
        return phoneNumber;
    }
}
