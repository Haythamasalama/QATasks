package task;

public class MobileException extends Exception {
    public MobileException(String mobile) {
        super("invalid mobile :" + mobile);
    }
}
