package task;

public class GenderException extends Exception {
    public GenderException(String gender) {
        super("invalid gender :" + gender);
    }
}
