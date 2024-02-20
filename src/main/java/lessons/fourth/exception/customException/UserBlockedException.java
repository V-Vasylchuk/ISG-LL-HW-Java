package lessons.fourth.exception.customException;

public class UserBlockedException extends RuntimeException {
    public UserBlockedException(String message) {
        super(message);
    }
}
