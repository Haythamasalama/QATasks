package task;

public class AgeException extends Exception {
    public AgeException(int age) {
        super("invalid age :" + age);
    }
}
