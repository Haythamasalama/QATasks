package task;

public class NameException extends Exception {
    public NameException(String name) {
        super("invalid name :" + name);
    }
}
