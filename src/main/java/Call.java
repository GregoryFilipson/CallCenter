public class Call {
    private long maxValuePhoneNumber = 999999999;

    public String generatePhoneNumber() {
        return "+79" + (long) (Math.random() * ++maxValuePhoneNumber);
    }
}
